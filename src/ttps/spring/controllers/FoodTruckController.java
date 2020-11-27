package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.config.PersistenceConfig;
import ttps.spring.interfacesDAO.FoodTruckDAO;
import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;

@RestController
@RequestMapping(value = "/FoodTruck", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodTruckController {
	
	@Autowired
	FoodTruckDAO foodTruckDAO;
	
	@Autowired
	FoodTruckerDAO foodtruckerDAO;
	
	private void onStartup() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceConfig.class);
		ctx.scan("ttps.spring.clasesDAO");
		ctx.refresh();
		foodTruckDAO = ctx.getBean(FoodTruckDAO.class);
		foodtruckerDAO = ctx.getBean(FoodTruckerDAO.class);
		ctx.close();
	}
	
	//POST
	@PostMapping("/createFoodTruck")
	public ResponseEntity<FoodTruck> createFoodTruck(@RequestBody FoodTruck foodtruck, @RequestParam int id){
		
		 FoodTrucker ft = foodtruckerDAO.recuperar(id);
		 if (ft == null) { 
		 	return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.CONFLICT); 
		 }
		 
		 System.out.println("food trucker recuperado"); 
		 foodtruck.setFoodtrucker(ft);
		 
		
		foodTruckDAO.persistir(foodtruck);
		System.out.println("Foodtrucker creado!");
		
		return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getFoodTruck")
	public ResponseEntity<FoodTruck> getFoodTruck(@RequestParam int id){
		FoodTruck foodtruck = foodTruckDAO.getFoodTruck(id);
		return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.OK);
	}
	
	@PutMapping("/updateFoodTruck")
	public ResponseEntity<FoodTruck> updateFoodTruck(@RequestParam int id, @RequestBody FoodTruck foodtrucknuevo){
		FoodTruck foodtruck = foodTruckDAO.getFoodTruck(id);
		if (foodtruck != null) {
			foodtruck.setDescripcion(foodtrucknuevo.getDescripcion());
			foodtruck.setInstagram(foodtrucknuevo.getInstagram());
			foodtruck.setNombre(foodtrucknuevo.getNombre());
			foodtruck.setServicio(foodtrucknuevo.getServicio());
			foodtruck.setTwitter(foodtrucknuevo.getTwitter());
			foodtruck.setWebsite(foodtrucknuevo.getWebsite());
			foodtruck.setWhatsapp(foodtrucknuevo.getWhatsapp());
			foodTruckDAO.actualizar(foodtruck);
			foodtruck = foodTruckDAO.getFoodTruck(id);
			return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.OK);
		}
		return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/deleteFoodTruck")
	public ResponseEntity<FoodTruck> deleteFoodTruck(@RequestParam int id){
		FoodTruck foodtruck = foodTruckDAO.getFoodTruck(id);
		if (foodtruck == null) {
			System.out.println("No es posible eliminar, no se encuentra foodtruck con id "+id);
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		foodTruckDAO.borrar(foodtruck);
		System.out.println("Foodtruck con id "+id+" borrado");
		return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
	}
}
