package com.idat.springbootTaskAPI.service;

import java.util.List;

import com.idat.springbootTaskAPI.model.AutorTask;

public interface AutorTaskService {

	List<AutorTask> autorTaskList();
	
	AutorTask addAutor ( AutorTask autor );
	
	AutorTask updateTask ( AutorTask autor );
	
	void deleteAutor ( Long id );
	
	AutorTask autorById ( Long id );
	
}
