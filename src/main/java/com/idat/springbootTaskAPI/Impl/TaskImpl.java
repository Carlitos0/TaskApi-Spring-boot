package com.idat.springbootTaskAPI.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.springbootTaskAPI.model.Task;
import com.idat.springbootTaskAPI.repository.TaskRepository;
import com.idat.springbootTaskAPI.service.TaskService;

@Service
public class TaskImpl implements TaskService {

	@Autowired
	TaskRepository taskDao;
	
	@Override
	public List<Task> taskList() {
		return taskDao.findAll();
	}

	@Override
	public Task addTask(Task task) {
		return taskDao.save( task );
	}

	@Override
	public Task updateTask(Task task) {
		return taskDao.save( task );
	}

	@Override
	public void deletedTask(Long id) {
		taskDao.deleteById(id);
	}

	@Override
	public Task taskById(Long id) {
		return taskDao.findById(id).orElse(null);
	}

}
