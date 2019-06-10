package com.lab.sdt.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.util.MensajeG;



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
	
	@PostConstruct
	public void init(){
		
	}
	public void muestra() {
		try {
		//consultaUsuarios.insertarUsuario("pedro");
		MensajeG.mostrar(consultaUsuarios.insertarUsuario("pedro"), FacesMessage.SEVERITY_WARN);
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
		
		//setResultado("Prueba base de datos");
		
		
	}

	
	
}
