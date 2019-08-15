package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.FlowEvent;

import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.model.Especialidad;
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



private String nombre;
private String apellido1;
private String apellido2;
private String calle;
private String num;
private String colonia;
private String codigoPostal;
private int idEstado;
private int idEstado1;
private String telefono;
private String email;
private int idTipo;
private String cuenta;
private String cuenta1;
private String contrasenia;
private String especialidad1;

private int user_a = 0;
private int grado;

private boolean estatus = false;

private boolean ingresa_grado = false;



public String resultado ="";

public String estado;

public int tipoUsuario;
public int tipoUsuario1;

public int tipo_menu  =0;


public List<SelectItem> estados;
public List<SelectItem> grados;

public List<SelectItem> tipoUsuarios;
private List<Usuario> cuentas1;

private Usuario seleccion_user;
private Usuario seleccion_user_empaque;

private String buscador = "";

@PostConstruct
public void init(){
	setCuenta("");
	cuentas1 = new ArrayList<Usuario>();
	estados = new ArrayList<SelectItem>();
	grados =  new ArrayList<SelectItem>();
	tipoUsuarios = new ArrayList<SelectItem>();

	seleccion_user_empaque = new Usuario();
	tipo_cuenta_1() ;
	try {
		grados = estadoUnidad.getLista_grado();
		estados = estadoUnidad.getLista_estados();
		tipoUsuarios = consultaUsuarios.lista_tipousuarios();
		cuentas1 = consultaUsuarios.lista_cuentas();
		
	}catch(Exception e) {
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	}
}

public void carga_datos_user() {
	seleccion_user_empaque = seleccion_user;
	setCuenta1(seleccion_user_empaque.getCuenta());
	setTipoUsuario1(seleccion_user_empaque.getIdtipo());
	setNombre(seleccion_user_empaque.getNombre());
	setApellido1(seleccion_user_empaque.getApellido1());
	setApellido2(seleccion_user_empaque.getApellido2());
	setContrasenia(seleccion_user_empaque.getContrasenia());
	setCalle(seleccion_user_empaque.getCalle());
    setNum(seleccion_user_empaque.getNum());
    setColonia(seleccion_user_empaque.getColonia());
    setCodigoPostal(seleccion_user_empaque.getCodigopostal());
    setIdEstado1(seleccion_user_empaque.getIdestado());
    setTelefono(seleccion_user_empaque.getTelefono());
    setEmail(seleccion_user_empaque.getEmail());
	try {
		if(seleccion_user.getEstatus().equals("A")) {
			setEstatus(true);
		}else {
			setEstatus(false);
		}
	}catch(Exception e) {
		setEstatus(false);
	}
	
	setIngresa_grado(false);
	setGrado(0);
	setEspecialidad1(" --- ");

}
public void cargar_todos_user() {
	cuentas1 = new ArrayList<Usuario>();
	cuentas1.clear();
	try {
		cuentas1 = consultaUsuarios.lista_cuentas();
		
	}catch(Exception e) {

	}
}

public void cargar_tipos_user() {
	cuentas1 = new ArrayList<Usuario>();
	cuentas1.clear();
	try {
		cuentas1 = consultaUsuarios.lista_tipo_cuenta(tipoUsuario);
		
	}catch(Exception e) {

	}
}
public void ingresoescialdiad() {
	guarda_actualiza_datos_in();
	if(isIngresa_grado()) {
		
	}else {
		setEspecialidad1(" --- ");
	}

	
}
public void especiladiad() {
	guarda_actualiza_datos_in();
	setEspecialidad1(" --- ");
	try {
		if(consultaUsuarios.cuenta_registro(getCuenta1())==null) {
			setEspecialidad1(" --- ");
		}else {
			user_a = consultaUsuarios.encuentra_cuenta(getCuenta1()).getIdusuario();
			List<Especialidad> especialidades =  consultaUsuarios.obtenerEspeciladadUser(user_a);
			for(int jj = 0; jj<=especialidades.size()-1;jj++) {
				if(especialidades.get(jj).getIdgrado() == grado) {
					setEspecialidad1(especialidades.get(jj).getEspecialidad());
				}
			}
		//	user_a
			
		}
		
	}catch(Exception e) {
		setEspecialidad1(e.toString());
	}
}
public void guarda_actualiza_datos_in() {
	
	setCuenta1(getCuenta1());
	setTipoUsuario1(getTipoUsuario1());
	setNombre(getNombre());
	setApellido1(getApellido1());
	setApellido2(getApellido2());
	setContrasenia(getContrasenia());
	setCalle(getCalle());
    setNum(getNum());
    setColonia(getColonia());
    setCodigoPostal(getCodigoPostal());
    setIdEstado1(getIdEstado1());
    setTelefono(getTelefono());
    setEmail(getEmail());
    setEstatus(isEstatus());
    setGrados(getGrados());
    setIngresa_grado(isIngresa_grado());
    setEspecialidad1(getEspecialidad1());
	//seleccion_user_empaque.setCuenta(getCuenta1());
}
public void guarda_actualiza_datos() {
	try {
		if(getCuenta1().trim().length() > 0) {
			if(consultaUsuarios.cuenta_registro(getCuenta1())==null) {
				user_a = registroUsuario(0,0);
				if(isIngresa_grado()) {registroespecialidad();}
				MensajeG.mostrar("Se guardo la cuenta: "+getCuenta1(), FacesMessage.SEVERITY_INFO);
				
			}else {
				user_a = registroUsuario(1,consultaUsuarios.encuentra_cuenta(getCuenta1()).getIdusuario());
				if(isIngresa_grado()) {registroespecialidad();}
				MensajeG.mostrar("Se Actualizo la cuenta: "+getCuenta1(), FacesMessage.SEVERITY_INFO);
			}
			cargar_todos_user();
		}else {
			MensajeG.mostrar("Ingrese una cuenta", FacesMessage.SEVERITY_INFO);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
	}
}
public void buscar_cuentas() {
	 if(cuenta.trim().length() > 0) {
		 try {
			 Usuario cuent = new Usuario();
			
			 cuentas1.clear();
			 
				 cuent =  consultaUsuarios.encuentra_cuenta(cuenta);
				 if(cuent!=null) {
					 
					 cuentas1.add(cuent);
				 
			 }
		 }catch(Exception e) {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	 }else {
		 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
	 }
	
	
}
public void registroespecialidad() {
	boolean actualiza = false;

	List<Especialidad> especialidades =  consultaUsuarios.obtenerEspeciladadUser(user_a);
		for(int jj = 0; jj<=especialidades.size()-1;jj++) {
			if(especialidades.get(jj).getIdgrado() == grado) {
				actualiza = true;
				Especialidad espe = new Especialidad();
				espe.setEspecialidad(getEspecialidad1());
				espe.setIdgrado(grado);
				espe.setIdusuario(user_a);
				espe.setEspecialidad(getEspecialidad1());
				espe.setIdespecialidad(especialidades.get(jj).getIdespecialidad());
				consultaUsuarios.actualizaEspecialidad(espe);
			}
		}

	if(actualiza == false) {
		Especialidad espe = new Especialidad();
		espe.setEspecialidad(getEspecialidad1());
		espe.setIdgrado(grado);
		espe.setIdusuario(user_a);
		consultaUsuarios.insertarEspecialidad(espe);
	}

}
private boolean skip;
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
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect("login.xhtml");
			

		}else {
			 MensajeG.mostrar("ya existe un usuario con esta cuenta: "+consultaUsuarios.cuenta_registro(getCuenta()), FacesMessage.SEVERITY_WARN);
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
	}
}

public int registroUsuario(int tipo,int id_user) throws Exception{
	 
	int id_user_1 = 0;
	Usuario User = new Usuario();
	User.setCuenta(getCuenta1());
	User.setIdtipo(getTipoUsuario1());
	User.setNombre(getNombre());
	User.setApellido1(getApellido1());
	User.setApellido2(getApellido2());
	User.setCalle(getCalle());
	User.setNum(getNum());
	User.setColonia(getColonia());
	User.setCodigopostal(getCodigoPostal());
	User.setIdestado(getIdEstado1());
	User.setTelefono(getTelefono());
	User.setEmail(getEmail());
	User.setContrasenia(getContrasenia());
	if(isEstatus()) {
		User.setEstatus("A");
	}else {
		User.setEstatus("D");
	}
	if(tipo == 0) {
		id_user_1 = consultaUsuarios.insertarUsuario(User);
	}else {
		User.setIdusuario(id_user);
		id_user_1 = consultaUsuarios.actualizaUsuario(User);
	}
 return id_user_1;
}
public void tipo_cuenta_1() {
	tipo_menu = 1;
}
public void tipo_cuenta_2() {
	tipo_menu = 2;
}
public void tipo_cuenta_3() {
	tipo_menu = 3;
}
public void tipo_cuenta_4() {
	tipo_menu = 4;
}
public void tipo_cuenta_5() {
	tipo_menu = 5;
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


public String getBuscador() {
	return buscador;
}
public void setBuscador(String buscador) {
	this.buscador = buscador;
}

public int getTipo_menu() {
	return tipo_menu;
}
public void setTipo_menu(int tipo_menu) {
	this.tipo_menu = tipo_menu;
}

public int getTipoUsuario() {
	return tipoUsuario;
}

public void setTipoUsuario(int tipoUsuario) {
	this.tipoUsuario = tipoUsuario;
}
public String getCuenta1() {
	return cuenta1;
}

public void setCuenta1(String cuenta1) {
	this.cuenta1 = cuenta1;
}
public int getTipoUsuario1() {
	return tipoUsuario1;
}

public void setTipoUsuario1(int tipoUsuario1) {
	this.tipoUsuario1 = tipoUsuario1;
}
public boolean isEstatus() {
	return estatus;
}

public void setEstatus(boolean estatus) {
	this.estatus = estatus;
}
public int getIdEstado1() {
	return idEstado1;
}

public void setIdEstado1(int idEstado1) {
	this.idEstado1 = idEstado1;
}
public List<SelectItem> getGrados() {
	return grados;
}

public void setGrados(List<SelectItem> grados) {
	this.grados = grados;
}
public int getGrado() {
	return grado;
}

public void setGrado(int grado) {
	this.grado = grado;
}
public boolean isIngresa_grado() {
	return ingresa_grado;
}

public void setIngresa_grado(boolean ingresa_grado) {
	this.ingresa_grado = ingresa_grado;
}
public String getEspecialidad1() {
	return especialidad1;
}

public void setEspecialidad1(String especialidad1) {
	this.especialidad1 = especialidad1;
}
}