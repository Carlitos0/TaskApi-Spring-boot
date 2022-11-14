package com.idat.springbootTaskAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "autorTask" )
public class AutorTask {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idAutor;
	
	@Column( name = "nombres", length = 70, nullable = false )
	private String nombres;
	
	@Column( name = "email" , length = 50, nullable = false )
	private String email;
	
	@Column( name = "telefono" , length = 9, nullable = false )
	private String telefono;

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
