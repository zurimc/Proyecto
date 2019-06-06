package com.lab.sdt.view;

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
import com.lab.sdt.util.MensajeG;

import com.lab.sdt.service.ConsultaUsuarios;



@ManagedBean
@ViewScoped
public class hello implements Serializable {
 
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