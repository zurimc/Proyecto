package com.lab.sdt.dto;
import java.io.Serializable;

import com.lab.sdt.model.Estado;

public class EstadoDTO  implements Serializable{

	private static final long serialVersionUID = 1228694890109458290L;
	
	private int idEstado;
	private String estado;
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
