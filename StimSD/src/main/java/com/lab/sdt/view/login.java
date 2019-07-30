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

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lab.sdt.model.Usuario;
import com.lab.sdt.util.Constantes;
import com.lab.sdt.util.MensajeG;
import com.lab.sdt.service.ConsultaUsuarios;


@ManagedBean
@ViewScoped
public class login implements Serializable {
 
private static final long serialVersionUID = 1L;
 
@ManagedProperty("#{consultaUsuarios}")
private ConsultaUsuarios consultaUsuarios;



public ConsultaUsuarios getConsultaUsuarios() {
	return consultaUsuarios;
}

public void setConsultaUsuarios(ConsultaUsuarios consultaUsuarios) {
	this.consultaUsuarios = consultaUsuarios;
}
private String nombre;

private String contrasenia;

private String resultado ="";

private Usuario userDTO;
@PostConstruct
public void init(){
	
}

public void muestra() {

	try {
	//consultaUsuarios.insertarUsuario("pedro");
	MensajeG.mostrar(consultaUsuarios.login(nombre, contrasenia), FacesMessage.SEVERITY_WARN);
	
	}catch(Exception e) {
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	}
	
	//setResultado("Prueba base de datos");
	
}
public void ingresa() {
	if(nombre.trim().length() > 0 && contrasenia.trim().length() > 0){
		try {
		userDTO = consultaUsuarios.validarusuario(nombre,contrasenia);
		guardasecciondeusuario(); 
		}catch(Exception e) {
			RequestContext.getCurrentInstance().addCallbackParam("mensaje", e.getMessage());
			MensajeG.mostrar(e.getMessage(), FacesMessage.SEVERITY_ERROR);
			RequestContext.getCurrentInstance().execute("PF('statusDialog').hide();");
			
		}
	}else{
		MensajeG.mostrar("Debe escribir usuario y password", FacesMessage.SEVERITY_ERROR);
		RequestContext.getCurrentInstance().execute("PF('statusDialog').hide();");
	}

}
public void guardasecciondeusuario() {
	try {
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	sessionMap.put("usuario",userDTO);
	if(userDTO.getIdtipo() == Constantes.TipoUsuario.ADMINISTRADOR){
		externalContext.redirect("Administrador.xhtml");
	}else if(userDTO.getIdtipo() == Constantes.TipoUsuario.DOCTOR){
		externalContext.redirect("index.xhtml");
	}else if(userDTO.getIdtipo()== Constantes.TipoUsuario.TECNICO){
		externalContext.redirect("index.xhtml");
	}else if(userDTO.getIdtipo()== Constantes.TipoUsuario.PACIENTE){
		externalContext.redirect("index.xhtml");
		}else{
		externalContext.redirect("login.xhtml");
	}
	
}catch(Exception e){
//	RequestContext.getCurrentInstance().execute("PF('statusDialog').hide();");
	MensajeG.mostrar("Ocurrió una excepción: "+e.getMessage(), FacesMessage.SEVERITY_FATAL);
}
}
public void ini_registro() {
	
	try {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("registro.xhtml");
	}catch(Exception e) {
		
	}
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}






}