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
@CrossOrigin(origins = "*")
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
	@GetMapping
	public ResponseEntity<List<FoodTrucker>>listAllFoodTruckers(@RequestHeader String token, @RequestHeader int idUsuario){
		if (token.equals(idUsuario+"123456")) {
			List<FoodTrucker> foodTruckers = foodTruckerDAO.recuperarTodos("email");
			if (foodTruckers.isEmpty()) {
				System.out.println("No existen foodTruckers");
				return new ResponseEntity<List<FoodTrucker>>(HttpStatus.NO_CONTENT);
			}
			System.out.println("En total hay "+String.valueOf(foodTruckers.size())+" foodTruckers");
			return new ResponseEntity<List<FoodTrucker>>(foodTruckers,HttpStatus.OK);
		}
		return new ResponseEntity<List<FoodTrucker>>(HttpStatus.UNAUTHORIZED);
	}
	
	
	//POST
	
	@PostMapping
	public ResponseEntity<FoodTrucker> createUser(@RequestBody FoodTrucker foodTrucker){
		if (foodTruckerDAO.ConEmail(foodTrucker.getEmail()) == null) {
			foodTruckerDAO.persistir(foodTrucker);
			System.out.println("Usuario agregado");
			return new ResponseEntity<FoodTrucker>(foodTrucker,HttpStatus.CREATED);
		}
		System.out.println("Usuario existente");
		foodTrucker = null;
		return new ResponseEntity<FoodTrucker>(foodTrucker,HttpStatus.CONFLICT);
	}

	@PostMapping("/autenticacion")
	public ResponseEntity<String> login(@RequestHeader String email, @RequestHeader String contrasenia){
		if (foodTruckerDAO.ConEmail(email) != null) {
			FoodTrucker foodTrucker = foodTruckerDAO.autenticar(email, contrasenia);
			if (foodTrucker != null) {
				HttpHeaders header = new HttpHeaders();
				header.set("token", foodTrucker.getIdUsuario()+"123456");
				return new ResponseEntity<String>(header,HttpStatus.OK);
			}
			return new ResponseEntity<String>("Contrase�a incorrecta",HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("Email incorrecto",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FoodTrucker> getFoodTrucker(@PathVariable("id") int id, @RequestHeader String token){
		if (token.equals(id+"123456")) {
			FoodTrucker foodTrucker = foodTruckerDAO.recuperar(id);
			if (foodTrucker != null) {
				return new ResponseEntity<FoodTrucker>(foodTrucker,HttpStatus.OK);
			}
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodTrucker>(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FoodTrucker> updateFoodTrucker(@PathVariable("id") int id, @RequestHeader String token, @RequestBody FoodTrucker foodTruckerNuevo){
		if (token.equals(id+"123456")) {
			FoodTrucker foodTrucker = foodTruckerDAO.recuperar(id);
			if (foodTrucker != null) {
				foodTrucker.setApellido(foodTruckerNuevo.getApellido());
				foodTrucker.setNombre(foodTruckerNuevo.getNombre());
				foodTrucker.setEmail(foodTruckerNuevo.getEmail());
				foodTrucker.setContrasenia(foodTruckerNuevo.getContrasenia());
				foodTruckerDAO.actualizar(foodTrucker);
				foodTrucker = foodTruckerDAO.recuperar(id);
				return new ResponseEntity<FoodTrucker>(HttpStatus.OK);
			}
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodTrucker>(HttpStatus.UNAUTHORIZED);
	}
	
}
