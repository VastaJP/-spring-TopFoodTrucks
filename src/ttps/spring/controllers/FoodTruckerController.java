package ttps.spring.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import ttps.spring.config.PersistenceConfig;
import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/FoodTrucker", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodTruckerController {
	
	@Autowired
	FoodTruckerDAO foodTruckerDAO;
	
	private void onStartup() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceConfig.class);
		ctx.scan("ttps.spring.clasesDAO");
		ctx.refresh();
		foodTruckerDAO = ctx.getBean(FoodTruckerDAO.class);
		ctx.close();
	}
	
	
	//GET
	@GetMapping("/listAllFoodTruckers")
	public ResponseEntity<List<FoodTrucker>>listAllFoodTruckers(){
		List<FoodTrucker> foodTruckers = foodTruckerDAO.recuperarTodos("email");
		if (foodTruckers.isEmpty()) {
			System.out.println("No existen foodTruckers");
			return new ResponseEntity<List<FoodTrucker>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("En total hay "+String.valueOf(foodTruckers.size())+" foodTruckers");
		return new ResponseEntity<List<FoodTrucker>>(foodTruckers,HttpStatus.OK);
	}
	
	
	//POST
	@PostMapping("/createUser")
	public ResponseEntity<FoodTrucker> createUser(@RequestBody FoodTrucker foodTrucker){
		if (foodTruckerDAO.ConEmail(foodTrucker.getEmail()) == null) {
			foodTruckerDAO.persistir(foodTrucker);
			System.out.println("Usuario agregado");
			return new ResponseEntity<FoodTrucker>(foodTrucker,HttpStatus.CREATED);
		}
		System.out.println("Usuario existente");
		return new ResponseEntity<FoodTrucker>(foodTrucker,HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody String email, @RequestBody String contrasenia){
		if (foodTruckerDAO.ConEmail(email) != null) {
			FoodTrucker foodTrucker = foodTruckerDAO.autenticar(email, contrasenia);
			if (foodTrucker != null) {
				HttpHeaders header = new HttpHeaders();
				header.set("token", foodTrucker.getIdUsuario()+"123456");
				return new ResponseEntity<String>(header,HttpStatus.OK);
			}
			return new ResponseEntity<String>("Contraseña incorrecta",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Email incorrecto",HttpStatus.FORBIDDEN);
	}
	
//	@GetMapping("/getFoodTrucker")
//	public ResponseEntity<FoodTrucker> getFoodTrucker(@RequestParam int id){
//		
//	}
	
}
