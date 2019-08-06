package com.lab.sdt.view;

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
import org.primefaces.event.FlowEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.util.MensajeG;

import com.lab.sdt.service.ConsultaUsuarios;


@ManagedBean
@ViewScoped
public class RegistroUsuario implements Serializable {
 
private static final long serialVersionUID = 1L;
 
@ManagedProperty("#{consultaUsuarios}")
private ConsultaUsuarios consultaUsuarios;


@ManagedProperty("#{estadoUnidad}")
public EstadoUnidad estadoUnidad;



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

public String estado;
private boolean skip;
public String tipoUsuario;



public List<SelectItem> estados;
public List<SelectItem> tipoUsuarios;
private List<Usuario> cuentas1;

private Usuario seleccion_user;
private int tipos_vistas;
private String buscador = "";

@PostConstruct
public void init(){
	cuentas1 = new ArrayList<Usuario>();
	cuentas1 = consultaUsuarios.lista_cuentas();
	
	
	estados = new ArrayList<SelectItem>();
	tipoUsuarios = new ArrayList<SelectItem>();
	
	try {
		estados = estadoUnidad.getLista_estados();
		tipoUsuarios = consultaUsuarios.getLista_tipousuarios();
		
	}catch(Exception e) {
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	}
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
public void carga_Estados() {

	
	//setResultado("Prueba base de datos");
	
	
}

public boolean isSkip() {
    return skip;
}

public void setSkip(boolean skip) {
    this.skip = skip;
}

public String onFlowProcess(FlowEvent event) {
    if(skip) {
        skip = false;   //reset in case user goes back
        return "confirm";
    }
    else {
        return event.getNewStep();
    }
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
	User.setIdtipo(4);/* paciente*/
	User.setCuenta(cuenta);
	User.setContrasenia(contrasenia);
	User.setEstatus("D");
	try {
		 if(consultaUsuarios.cuenta_registro(cuenta)==null) {
			 consultaUsuarios.registroUsuario(User);
			
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				externalContext.redirect("login.xhtml");
				 MensajeG.mostrar("Registro exitoso", FacesMessage.SEVERITY_INFO);
		 }else {
			 MensajeG.mostrar("ya existe un usuario con esta cuenta", FacesMessage.SEVERITY_WARN);
		 }
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
	}
}

public void ini_login() {
	
	try {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("login.xhtml");
	}catch(Exception e) {
		
	}
}

public void vista_cuenta() {
	   tipos_vistas =  1;
}
public void vista_actualizar() {
	   tipos_vistas =  2;
}
public void buscar_cuentas() {
	 if(cuenta.trim().length() > 0) {
		 try {
			 Equipo estimulador = new Equipo();
			 cuentas1.clear();
			 for(int jjf=1;jjf<=6;jjf++) {
				 estimulador =  consultaUsuarios.encuentra_cuenta(cuenta+";"+jjf);
				 if(estimulador!=null) {
					 
					 cuentas1.addAll(cuentas1);
				 }
			 }
		 }catch(Exception e) {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	 }else {
		 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
	 }
	
	
}



public String getEstado() {
	estado = estados.get(idEstado-1).getLabel();
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public List<SelectItem> getEstados() {
	
	return estados;
}

public void setEstados(List<SelectItem> estados) {
	this.estados = estados;
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

public String getTipoUsuario() {
	return tipoUsuario;
}
public void setTipoUsuario(String tipoUsuario) {
	this.tipoUsuario = tipoUsuario;
}
public List<SelectItem> getTipoUsuarios() {
	return tipoUsuarios;
}
public void setTipoUsuarios(List<SelectItem> tipoUsuarios) {
	this.tipoUsuarios = tipoUsuarios;
}
public List<Usuario> getCuentas1() {
	return cuentas1;
}
public void setCuentas1(List<Usuario> cuentas1) {
	this.cuentas1 = cuentas1;
}

public Usuario getSeleccion_user() {
	return seleccion_user;
}
public void setSeleccion_user(Usuario seleccion_user) {
	this.seleccion_user = seleccion_user;
}
public int getTipos_vistas() {
	return tipos_vistas;
}
public void setTipos_vistas(int tipos_vistas) {
	this.tipos_vistas = tipos_vistas;
}


}