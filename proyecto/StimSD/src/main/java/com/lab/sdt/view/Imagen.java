package com.lab.sdt.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.lab.sdt.model.Fotos;
import com.lab.sdt.service.ImagenService;
import com.lab.sdt.util.MensajeG;



@ManagedBean
public class Imagen implements Serializable{
private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{imagenService}")
	private ImagenService imagenService;

	
	private int idUsuario;
	private String nombre_foto;

	private byte[] foto1;
	private List<Fotos> fotos1;
	
	//insertar datos en la tabla fotos
	public void registroFotos() {
		Fotos fotosn = new Fotos();
		fotosn.setIdusuario(2);
		fotosn.setNombreFoto(nombre_foto);
		
		  try {
			  imagenService.insertarFoto(fotosn);
			 
	                MensajeG.mostrar("Se guardo foto: " + nombre_foto, FacesMessage.SEVERITY_INFO);
	           
	            
	        } catch (Exception e) {
	            MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	        }
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

	public ImagenService getImagenService() {
		return imagenService;
	}

	public void setImagenService(ImagenService imagenService) {
		this.imagenService = imagenService;
	}


	public List<Fotos> getFotos1() {
		return fotos1;
	}


	public void setFotos1(List<Fotos> fotos1) {
		this.fotos1 = fotos1;
	}
	
	
	
	   
	 
}