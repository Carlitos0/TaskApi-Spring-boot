package com.idat.springbootTaskAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.springbootTaskAPI.model.AutorTask;
import com.idat.springbootTaskAPI.service.AutorTaskService;

@RestController
@RequestMapping( "/autorTask" )
public class AutorTaskController {

	@Autowired
	AutorTaskService service;
	
	@GetMapping
	public ResponseEntity<List<AutorTask>> allAutors(){
		List<AutorTask> obj = service.autorTaskList();
		return new ResponseEntity<List<AutorTask>> (obj, HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> addAutorTask( @RequestBody AutorTask autor ){
		AutorTask obj = null;
		Map<String, Object> rpta = new HashMap<>();
		try {
			obj = service.addAutor(autor);
		} catch (DataAccessException e) {
			rpta.put("message", "No se pudo añadir el registro");
			rpta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		rpta.put("message", "Register added succesfully");
		rpta.put("data", obj);
		return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<?> updateAutorTask( @RequestBody AutorTask autor ){
		AutorTask obj = null;
		Map<String, Object> rpta = new HashMap<>();
		try {
			obj = service.updateTask(autor);
		} catch (DataAccessException e) {
			rpta.put("message", "No se pudo añadir el registro");
			rpta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		rpta.put("message", "Register has update succesfully");
		rpta.put("data", obj);
		return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAutor( @PathVariable Long id ) throws Exception{
		Map<String, Object> rpta = new HashMap<>();
		try {
			service.deleteAutor(id);
		} catch (DataAccessException e) {
			rpta.put("message", "No se pudo eliminar el registro");
			rpta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		rpta.put("message", "Register has removed succesfully");
		return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> autorById( @PathVariable Long id ) throws Exception{
		AutorTask obj = null;
		Map<String, Object> rpta = new HashMap();
		
		try {
			obj = service.autorById(id);
		}catch (DataAccessException e) {
			// TODO: handle exception
			rpta.put("mensaje", "Error. No se produjo la consulta en la base de datos.");
			rpta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (obj == null) {
			rpta.put("mensaje", "No se encontraron coincidencias.");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AutorTask>(obj, HttpStatus.OK);
	}
}
