package com.jds.instituto.model;

public class CentroEducativo {
	
	int id;
	String descripcion;
	
	
	public CentroEducativo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CentroEducativo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return descripcion;
	}
	
	

}
