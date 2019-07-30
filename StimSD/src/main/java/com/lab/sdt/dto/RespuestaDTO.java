package com.lab.sdt.dto;

public class RespuestaDTO {

	private boolean autorizacion;
	private int tipo_usuario;
	private String mensaje;
	private String ondas;
	

	public String getOndas() {
		return ondas;
	}
	public void setOndas(String ondas) {
		this.ondas = ondas;
	}
	public boolean isAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(boolean autorizacion) {
		this.autorizacion = autorizacion;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
