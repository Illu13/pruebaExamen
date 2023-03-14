package com.jds.instituto.model;

import java.util.Date;

public class Materia {
	
	int id;
	String nombre;
	int idNivel;
	String codigo;
	String urlClassroom;
	boolean admiteMatricula;
	java.sql.Date fechaInicio;
	
	
	public Materia() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Materia(int id, String nombre, int idNivel, String codigo, String urlClassroom, boolean admiteMatricula,
			java.sql.Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idNivel = idNivel;
		this.codigo = codigo;
		this.urlClassroom = urlClassroom;
		this.admiteMatricula = admiteMatricula;
		this.fechaInicio = fechaInicio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getIdNivel() {
		return idNivel;
	}


	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getUrlClassroom() {
		return urlClassroom;
	}


	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}

	public boolean isAdmiteMatricula() {
		return admiteMatricula;
	}


	public void setAdmiteMatricula(boolean admiteMatricula) {
		this.admiteMatricula = admiteMatricula;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(java.sql.Date fecha) {
		this.fechaInicio = fecha;
	}


	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	

}
