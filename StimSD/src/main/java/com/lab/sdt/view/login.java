package com.lab.sdt.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lab.sdt.model.Usuario;
import com.lab.sdt.util.Constantes;
import com.lab.sdt.util.MensajeG;
import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.service.EstadoUnidad;


@ManagedBean
@ViewScoped
public class login implements Serializable {
 
private static final long serialVersionUID = 1L;
 
@ManagedProperty("#{consultaUsuarios}")
private ConsultaUsuarios consultaUsuarios;


@ManagedProperty("#{estadoUnidad}")
public EstadoUnidad estadoUnidad;


private String nombre;

private String contrasenia;

private String resultado ="";

private Usuario userDTO;


private String cuenta;
private String apellido1;
private String apellido2;
private String telefono;
private String email;
private String calle;
private String num;
private String colonia;
private String codigoPostal;
private int idEstado;
private int idEstado1;

private String estado;


private List<SelectItem> estados;

private int tipo_vista = 0;


public void registroUsuario_primero(){
	Usuario User = new Usuario();
	User.setNombre(nombre);
	User.setApellido1(apellido1);
	User.setApellido2(apellido2);
	User.setCalle(calle);
	User.setNum(num);
	User.setColonia(colonia);
	User.setCodigopostal(codigoPostal);
	User.setIdestado(idEstado);
	User.setTelefono(telefono);
	User.setEmail(email);
	User.setIdtipo(6);/* por definir*/
	User.setCuenta(cuenta);
	User.setContrasenia(contrasenia);
	User.setEstatus("D");
	try {
		if(consultaUsuarios.cuenta_registro(getCuenta())==null) {
			MensajeG.mostrar("Registro exitoso", FacesMessage.SEVERITY_INFO);
			consultaUsuarios.registroUsuario(User);
			cambio_login_a_login();
			//ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			//externalContext.redirect("login.xhtml");
		}else {
			 MensajeG.mostrar("ya existe un usuario con esta cuenta: "+consultaUsuarios.cuenta_registro(getCuenta()), FacesMessage.SEVERITY_WARN);
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
	}
}

@PostConstruct
public void init(){
	estados = new ArrayList<SelectItem>();
	try {
		estados = estadoUnidad.getLista_estados();
		tipo_vista = 1;
	}catch(Exception e) {
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	}
}
public void cambio_login_a_login() {
	
	tipo_vista = 0;
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
		externalContext.redirect("TipoCuenta.xhtml");
	}else if(userDTO.getIdtipo() == Constantes.TipoUsuario.DOCTOR){
		externalContext.redirect("paciente.xhtml");
	}else if(userDTO.getIdtipo()== Constantes.TipoUsuario.TECNICO){
		externalContext.redirect("estimuladores.xhtml");
	}else if(userDTO.getIdtipo()== Constantes.TipoUsuario.PACIENTE){
		
	}else if(userDTO.getIdtipo()== Constantes.TipoUsuario.OPERADOR){
		externalContext.redirect("TipoCuenta.xhtml");
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

public String getCuenta() {
	return cuenta;
}

public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
}

public String getApellido1() {
	return apellido1;
}

public void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
}

public String getApellido2() {
	return apellido2;
}

public void setApellido2(String apellido2) {
	this.apellido2 = apellido2;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCalle() {
	return calle;
}

public void setCalle(String calle) {
	this.calle = calle;
}

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
}

public String getColonia() {
	return colonia;
}

public void setColonia(String colonia) {
	this.colonia = colonia;
}

public String getCodigoPostal() {
	return codigoPostal;
}

public void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}

public int getIdEstado() {
	return idEstado;
}

public void setIdEstado(int idEstado) {
	this.idEstado = idEstado;
}

public int getIdEstado1() {
	return idEstado1;
}

public void setIdEstado1(int idEstado1) {
	this.idEstado1 = idEstado1;
}

public List<SelectItem> getEstados() {
	return estados;
}

public void setEstados(List<SelectItem> estados) {
	this.estados = estados;
}


public EstadoUnidad getEstadoUnidad() {
	return estadoUnidad;
}

public void setEstadoUnidad(EstadoUnidad estadoUnidad) {
	this.estadoUnidad = estadoUnidad;
}

public ConsultaUsuarios getConsultaUsuarios() {
	return consultaUsuarios;
}

public void setConsultaUsuarios(ConsultaUsuarios consultaUsuarios) {
	this.consultaUsuarios = consultaUsuarios;
}

public String getEstado() {
	try {
		estado = estados.get(idEstado-1).getLabel();
	}catch(Exception e ) {}
	
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}
public int getTipo_vista() {
	return tipo_vista;
}

public void setTipo_vista(int tipo_vista) {
	this.tipo_vista = tipo_vista;
}

}