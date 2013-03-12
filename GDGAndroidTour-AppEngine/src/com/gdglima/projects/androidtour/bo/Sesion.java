package com.gdglima.projects.androidtour.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sesion {
	
	@Id
	private Long id;
	
	private String aula_id;
	private String fecha_inicio;
	private String fecha_fin;
	private String nivel;
	private String track_id;
	private String titulo;
	private String resumen;
	private String[] tags;
	private String[] ponentes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAula_id() {
		return aula_id;
	}
	public void setAula_id(String aula_id) {
		this.aula_id = aula_id;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getTrack_id() {
		return track_id;
	}
	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String[] getPonentes() {
		return ponentes;
	}
	public void setPonentes(String[] ponentes) {
		this.ponentes = ponentes;
	}
	
	


}
