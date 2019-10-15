package com.lab.sdt.dto;

public class PacienteDTO {

	private String cuenta;
	private String latitud;
	private String longitud;
	private String peticion;
	private int estatus;
	private String frecuencia;
	private String amplitud;
	private String tiempo;
	private String ondap1;
	private String ondap2;
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
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
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}


	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getAmplitud() {
		return amplitud;
	}
	public void setAmplitud(String amplitud) {
		this.amplitud = amplitud;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getOndap1() {
		return ondap1;
	}
	public void setOndap1(String ondap1) {
		this.ondap1 = ondap1;
	}
	public String getOndap2() {
		return ondap2;
	}
	public void setOndap2(String ondap2) {
		this.ondap2 = ondap2;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	
}
