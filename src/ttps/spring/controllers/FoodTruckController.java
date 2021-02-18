package ttps.spring.controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;

import ttps.spring.config.PersistenceConfig;
import ttps.spring.interfacesDAO.FoodTruckDAO;
import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;

@RestController
@CrossOrigin(origins = "*")
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
	//@PostMapping("/createFoodTruck")
	@PostMapping
	public ResponseEntity<FoodTruck> createFoodTruck(@RequestBody FoodTruck foodtruck, @RequestHeader int idUsuario, @RequestHeader String token){
		if (token.equals(idUsuario+"123456")) {
			FoodTrucker ft = foodtruckerDAO.recuperar(idUsuario);
			if (ft == null) { 
				return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.CONFLICT); 
			}
			 
			System.out.println("food trucker recuperado"); 
			foodtruck.setFoodtrucker(ft);
			 
			foodTruckDAO.persistir(foodtruck);
			System.out.println("Foodtrucker creado!");
			
			return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.CREATED);
		}
		return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);	
	}
	
	@Transactional
	@GetMapping("/{id}")
	public ResponseEntity<FoodTruck> getFoodTruck(@PathVariable("id") int id, @RequestHeader String token, @RequestHeader int idUsuario){
		if (token.equals(idUsuario+"123456")) {
			FoodTruck foodtruck = foodTruckDAO.recuperar(id);
			return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.OK);
		}
		return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<FoodTruck> updateFoodTruck(@PathVariable("id") int id, @RequestBody FoodTruck foodtrucknuevo, @RequestHeader String token, @RequestHeader int idUsuario){
		if (token.equals(idUsuario+"123456")) {
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
				Hibernate.initialize(foodtruck.getImagen());
				return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.OK);
			}
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTruck> deleteFoodTruck(@PathVariable("id") int id, @RequestHeader String token, @RequestHeader int idUsuario){
		if (token.equals(idUsuario+"123456")) {
			FoodTruck foodtruck = foodTruckDAO.getFoodTruck(id);
			if (foodtruck == null) {
				System.out.println("No es posible eliminar, no se encuentra foodtruck con id "+id);
				return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
			}
			foodTruckDAO.borrar(foodtruck);
			System.out.println("Foodtruck con id "+id+" borrado");
			return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
	}
}
