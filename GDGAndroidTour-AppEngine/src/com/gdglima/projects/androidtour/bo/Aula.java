package com.gdglima.projects.androidtour.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aula {
	
	@Id
	private Long id;
	
	private String nombre;
	
	
	public Aula() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
