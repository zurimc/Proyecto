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
private String nombre;
private String apellido1;
private String apellido2;
private String calle;
private String num;
private String colonia;
private String codigoPostal;
private int idEstado;
private String telefono;
private String email;
private int idTipo;
private String cuenta;
private String contrasenia;
private char estatus;


private String resultado ="";

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
	User.setCodigopostal("codigopostal");
	User.setIdestado(idEstado);
	User.setTelefono(telefono);
	User.setEmail(email);
	User.setIdtipo(idTipo);
	User.setCuenta(cuenta);
	User.setContrasenia(contrasenia);
	User.setEstatus("a");
	try {
		consultaUsuarios.registroUsuario(User);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



private String getNombre() {
	return nombre;
}

private void setNombre(String nombre) {
	this.nombre = nombre;
}

private String getApellido1() {
	return apellido1;
}

private void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
}

private String getApellido2() {
	return apellido2;
}

private void setApellido2(String apellido2) {
	this.apellido2 = apellido2;
}

private String getCalle() {
	return calle;
}

private void setCalle(String calle) {
	this.calle = calle;
}

private String getNum() {
	return num;
}

private void setNum(String num) {
	this.num = num;
}

private String getColonia() {
	return colonia;
}

private void setColonia(String colonia) {
	this.colonia = colonia;
}

private String getCodigoPostal() {
	return codigoPostal;
}

private void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}

private int getIdEstado() {
	return idEstado;
}

private void setIdEstado(int idEstado) {
	this.idEstado = idEstado;
}

private String getTelefono() {
	return telefono;
}

private void setTelefono(String telefono) {
	this.telefono = telefono;
}

private String getEmail() {
	return email;
}

private void setEmail(String email) {
	this.email = email;
}

private int getIdTipo() {
	return idTipo;
}

private void setIdTipo(int idTipo) {
	this.idTipo = idTipo;
}

private String getCuenta() {
	return cuenta;
}

private void setCuenta(String cuenta) {
	this.cuenta = cuenta;
}

private String getContrasenia() {
	return contrasenia;
}

private void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}

private char getEstatus() {
	return estatus;
}

private void setEstatus(char estatus) {
	this.estatus = estatus;
}

private static long getSerialversionuid() {
	return serialVersionUID;
}

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}


}