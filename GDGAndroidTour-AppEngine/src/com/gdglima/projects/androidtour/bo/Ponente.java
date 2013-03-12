package com.gdglima.projects.androidtour.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ponente {
	
	@Id
	private Long gplus_id;
	
	private String nombre;
	private String apellido;
	private String alias;
	private String gplus_url;
	private String photo_url;
	private String resumen;
	public Long getGplus_id() {
		return gplus_id;
	}
	public void setGplus_id(Long gplus_id) {
		this.gplus_id = gplus_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getGplus_url() {
		return gplus_url;
	}
	public void setGplus_url(String gplus_url) {
		this.gplus_url = gplus_url;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	
}
