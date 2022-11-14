package com.idat.springbootTaskAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.springbootTaskAPI.model.Task;
import com.idat.springbootTaskAPI.service.TaskService;

@RestController
@RequestMapping( "/task" )
public class TaskController {
	
	@Autowired
	TaskService service;
	
	@GetMapping()
	public ResponseEntity<List<Task>> allTask(){
		List<Task> obj = service.taskList();
		return new ResponseEntity<List<Task>> (obj, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> addTask( @RequestBody Task task ){
		Task obj = null;
		Map<String, Object> rpta = new HashMap<>();
		try {
			obj = service.addTask(task);
		} catch (DataAccessException e) {
			rpta.put("message", "No se pudo añadir el registro");
			rpta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		rpta.put("message", "Register added succesfully");
		rpta.put("data", obj);
		return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.CREATED);
	}
}
