package com.lab.sdt.dto;

import java.io.Serializable;

public class EquipoDTO implements Serializable{

	private static final long serialVersionUID = 4357669810836595990L;

	private String eSerie;
	
	private String eIMEI;
	
	private String eLote;

	private String Eonda;

	private String EComunicacion;

	private String EtipoOnda;

	private String Elongitud;
	
	private String Elatitud;
	
	private String efrecuencia;
	
	private String eamplitud;
	
	private String etiempo;
	
	private int Eid_usuario;
	
	private String enumonda;

	public int geteTipo() {
		return eTipo;
	}

	public void seteTipo(int eTipo) {
		this.eTipo = eTipo;
	}

	private int eTipo;

	public String geteSerie() {
		return eSerie;
	}

	public void seteSerie(String eSerie) {
		this.eSerie = eSerie;
	}

	public String geteIMEI() {
		return eIMEI;
	}

	public void seteIMEI(String eIMEI) {
		this.eIMEI = eIMEI;
	}

	public String geteLote() {
		return eLote;
	}

	public void seteLote(String eLote) {
		this.eLote = eLote;
	}

	public String getEonda() {
		return Eonda;
	}

	public void setEonda(String eonda) {
		Eonda = eonda;
	}


	public String getEtipoOnda() {
		return EtipoOnda;
	}

	public void setEtipoOnda(String etipoOnda) {
		EtipoOnda = etipoOnda;
	}

	public String getEComunicacion() {
		return EComunicacion;
	}

	public void setEComunicacion(String EComunicacion) {
		this.EComunicacion = EComunicacion;
	}
	public String getElongitud() {
		return Elongitud;
	}

	public void setElongitud(String elongitud) {
		Elongitud = elongitud;
	}

	public String getElatitud() {
		return Elatitud;
	}

	public void setElatitud(String elatitud) {
		Elatitud = elatitud;
	}
	public int getEid_usuario() {
		return Eid_usuario;
	}

	public void setEid_usuario(int eid_usuario) {
		Eid_usuario = eid_usuario;
	}

	public String getEfrecuencia() {
		return efrecuencia;
	}

	public void setEfrecuencia(String efrecuencia) {
		this.efrecuencia = efrecuencia;
	}

	public String getEamplitud() {
		return eamplitud;
	}

	public void setEamplitud(String eamplitud) {
		this.eamplitud = eamplitud;
	}

	public String getEtiempo() {
		return etiempo;
	}

	public void setEtiempo(String etiempo) {
		this.etiempo = etiempo;
	}

	public String getEnumonda() {
		return enumonda;
	}

	public void setEnumonda(String enumonda) {
		this.enumonda = enumonda;
	}
	
}
