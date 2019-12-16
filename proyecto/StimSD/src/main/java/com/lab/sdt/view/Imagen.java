package com.lab.sdt.view;

import java.io.Serializable;

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
	
	//insertar datos en la tabla fotos
	public void registroFotos() {
		Fotos fotos1 = new Fotos();
		
		fotos1.setNombreFoto("hola");
		
		  try {
	        	
	                MensajeG.mostrar("Se guardo foto: " +nombre_foto, FacesMessage.SEVERITY_INFO);
	                
	        	
	        	
	            
	        } catch (Exception e) {
	            MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
	        }
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
	
	
	
	   
	 
}