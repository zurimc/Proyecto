package com.lab.sdt.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lab.sdt.model.Usuario;


@ManagedBean
@ViewScoped

public class administrador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{gestiondeSeccionView}")
	private GestiondeSeccionView gestiondeSeccionView;




	private String inicio;

	
	@PostConstruct
	public void init(){
		Usuario userDTO = gestiondeSeccionView.obtenerUsuarioEnSesion();
		setInicio(" Hola "+userDTO.getNombre() +" "+userDTO.getApellido1()+ " "+userDTO.getApellido2());
	}
	
	public String getInicio() {
		return inicio;
	}


	public void setInicio(String inicio) {
		this.inicio = inicio;
	}



	public GestiondeSeccionView getGestiondeSeccionView() {
		return gestiondeSeccionView;
	}

	public void setGestiondeSeccionView(GestiondeSeccionView gestiondeSeccionView) {
		this.gestiondeSeccionView = gestiondeSeccionView;
	}

}
