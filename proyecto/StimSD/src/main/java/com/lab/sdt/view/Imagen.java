package com.lab.sdt.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.lab.sdt.model.Fotos;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Logger;


@ManagedBean
public class Imagen implements Serializable{
private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{imagenService}")

	private int idFoto;
	private int idUsuario;
	private String nombre_foto;
	
	private byte[] foto1;
	private Imagen file;
	
	
	public Imagen getFile() {
		return file;
	}

	public void setFile(Imagen file) {
		this.file = file;
	}

//insertar datos en la tabla fotos
	/*public void registroFotos() {
	 try{
	 
		Fotos fotos1 = new Fotos();
		fotos1.setNombreFoto(nombre_foto);
		fotos1.setFoto1(foto1);
		 FacesMessage message = new FacesMessage("Successful", nombre_foto.getBytes() + " is uploaded.");
         FacesContext.getCurrentInstance().addMessage(null, message);
         } catch (Exception e){
         FacesMessage message = new FacesMessage("error de conexion");
         FacesContext.getCurrentInstance().addMessage(null, message);
         }
	}*/
public String upload() {
	return "success";
	
}
	
	public int getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre_foto() {
		return nombre_foto;
	}
	public void setNombre_foto(String nombre_foto) {
		this.nombre_foto = nombre_foto;
	}
	public byte[] getFoto1() {
		return foto1;
	}
	public void setFoto1(byte[] foto1) {
		this.foto1 = foto1;
	}
	
	
	
	   
	 
}
