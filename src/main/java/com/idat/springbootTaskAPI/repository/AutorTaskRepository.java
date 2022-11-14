package com.idat.springbootTaskAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.springbootTaskAPI.model.AutorTask;

public interface AutorTaskRepository extends JpaRepository< AutorTask , Long > {
	
}
