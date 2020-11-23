package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.config.PersistenceConfig;
import ttps.spring.interfacesDAO.FoodTruckerDAO;
import ttps.spring.interfacesDAO.OrganizadorEventosDAO;
import ttps.spring.model.OrganizadorEventos;

@RestController
@RequestMapping(value = "/Organizador", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizadoresController {
	
	@Autowired
	OrganizadorEventosDAO organizadorDAO;
	
	private void onStartup() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceConfig.class);
		ctx.scan("ttps.spring.clasesDAO");
		ctx.refresh();
		organizadorDAO = ctx.getBean(OrganizadorEventosDAO.class);
		ctx.close();
	}
	
	
	@GetMapping("/listAllOrganizadores")
	public ResponseEntity<List<OrganizadorEventos>> listAllOrganizadores(){
		List<OrganizadorEventos> organizadores = organizadorDAO.recuperarTodos("email");
		return new ResponseEntity<List<OrganizadorEventos>>(organizadores,HttpStatus.OK);
	}
	
	
}
