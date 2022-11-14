package com.idat.springbootTaskAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "task" )
public class Task {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idTask;
	
	
	@Column( name = "description", length = 50, nullable = false )
	private String description;
	
	@ManyToOne
	@JoinColumn( name = "idAutor" )
	private AutorTask autor;

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AutorTask getAutor() {
		return autor;
	}

	public void setAutor(AutorTask autor) {
		this.autor = autor;
	}

	
	
	
}
