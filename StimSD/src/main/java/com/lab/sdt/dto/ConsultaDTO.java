package com.lab.sdt.dto;

import java.io.Serializable;

public class ConsultaDTO implements Serializable{

	private static final long serialVersionUID = 4357669810836595990L;
	

	private String contrasena;
	private String latitud;
	private String longitud;
	private String fecha;
	private String nombre;
	private int tipo_consulta;
	private String peticion;
	
	
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public int getTipo_consulta() {
		return tipo_consulta;
	}
	public void setTipo_consulta(int tipo_consulta) {
		this.tipo_consulta = tipo_consulta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
