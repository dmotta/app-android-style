package com.gdglima.projects.androidtour.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
	
	@Id
	private Long id;
	private String nombre;
	private String color;
	private String resumen;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	
}
