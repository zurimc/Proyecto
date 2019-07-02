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
public class RegistroUsuario implements Serializable {
 
private static final long serialVersionUID = 1L;
 
@ManagedProperty("#{consultaUsuarios}")
private ConsultaUsuarios consultaUsuarios;



public ConsultaUsuarios getConsultaUsuarios() {
	return consultaUsuarios;
}

public void setConsultaUsuarios(ConsultaUsuarios consultaUsuarios) {
	this.consultaUsuarios = consultaUsuarios;
}
public String nombre;
public String apellido1;
public String apellido2;
public String calle;
public String num;
public String colonia;
public String codigoPostal;
public int idEstado;
public String telefono;
public String email;
public int idTipo;
public String cuenta;
public String contrasenia;
public char estatus;
public String resultado ="";

@PostConstruct
public void init(){
	
}
public void muestra() {

	try {
	//consultaUsuarios.insertarUsuario("prueba");
	MensajeG.mostrar("", FacesMessage.SEVERITY_WARN);
	}catch(Exception e) {
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	}
	
	//setResultado("Prueba base de datos");
	
	
}

public void registroUsuario(){
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
	User.setIdtipo(idTipo);
	User.setCuenta(cuenta);
	User.setContrasenia(contrasenia);
	User.setEstatus("");
	try {
		consultaUsuarios.registroUsuario(User);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
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

public int getIdTipo() {
	return idTipo;
}

public void setIdTipo(int idTipo) {
	this.idTipo = idTipo;
}

public String getCuenta() {
	return cuenta;
}

public void setCuenta(String cuenta) {
	this.cuenta = cuenta;
}

public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}

public char getEstatus() {
	return estatus;
}

public void setEstatus(char estatus) {
	this.estatus = estatus;
}

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}





}