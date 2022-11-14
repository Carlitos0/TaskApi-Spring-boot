package com.idat.springbootTaskAPI.service;

import java.util.List;

import com.idat.springbootTaskAPI.model.Task;

public interface TaskService {
	
	List<Task> taskList();
	
	Task addTask ( Task task );
	
	Task updateTask ( Task task );
	
	void deletedTask ( Long id );
	
	Task taskById ( Long id );

}
