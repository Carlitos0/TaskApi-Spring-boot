package com.idat.springbootTaskAPI.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.springbootTaskAPI.model.AutorTask;
import com.idat.springbootTaskAPI.repository.AutorTaskRepository;
import com.idat.springbootTaskAPI.service.AutorTaskService;

@Service
public class AutorTaskImpl implements AutorTaskService {
	
	@Autowired
	AutorTaskRepository autorDao;

	@Override
	public List<AutorTask> autorTaskList() {
		return autorDao.findAll();
	}

	@Override
	public AutorTask addAutor(AutorTask autor) {
		return autorDao.save( autor );
	}

	@Override
	public AutorTask updateTask( AutorTask autor) {
		return autorDao.save(autor);
	}

	@Override
	public void deleteAutor(Long id) {
		autorDao.deleteById(id);
	}

	@Override
	public AutorTask autorById(Long id) {
		return autorDao.findById(id).orElse(null);
	}

}
