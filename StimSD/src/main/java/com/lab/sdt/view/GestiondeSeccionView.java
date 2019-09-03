package com.lab.sdt.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.lab.sdt.model.Usuario;
import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class GestiondeSeccionView implements Serializable{
	private static final long serialVersionUID = 1L;
	private Usuario userDTO;
	

	

	@PostConstruct
	public void init(){
		obtenerUsuarioEnSesion();
		
		if(userDTO == null || userDTO.getCuenta().equals("")){
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		//	ec.invalidateSession();
			try {
				ec.redirect("login.xhtml");
				return;
			} catch (IOException e) {
				System.out.println("ERROR AL REDIRIGIR USERDTO");
			}
		}
	}
	public Usuario obtenerUsuarioEnSesion(){
		System.out.println("Entro a obtenerUsuarioEnSesion");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if(!ec.isResponseCommitted()){
			try {
				Map<String, Object> session = ec.getSessionMap();
				userDTO = (Usuario)session.get("usuario");
				if(userDTO == null){
					ec.invalidateSession();
					ec.redirect("login.xhtml");
				}
			} catch (IOException e) {
				MensajeG.mostrar("No se pudo obtener al usuario y ocurrió un error al redirigir", FacesMessage.SEVERITY_FATAL);
			}
		}
		return userDTO;
	}
	public void cerrarSesionUsuario(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if(!ec.isResponseCommitted()){

			ec.invalidateSession();
			try {
				MensajeG.mostrar("Adiós, Gracias por visitarme :)", FacesMessage.SEVERITY_INFO);
				ec.getFlash().setKeepMessages(true);
				ec.redirect("login.xhtml");
			} catch (IOException e) {
				MensajeG.mostrar("Ocurrió un error al redirigir al Login", FacesMessage.SEVERITY_FATAL);
			}
		}
	}
	
	public Usuario getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(Usuario userDTO) {
		this.userDTO = userDTO;
	}
}
