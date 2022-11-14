package com.idat.springbootTaskAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.springbootTaskAPI.model.Task;

public interface TaskRepository extends JpaRepository< Task , Long > {

}
