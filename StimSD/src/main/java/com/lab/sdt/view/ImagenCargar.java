package com.lab.sdt.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class ImagenCargar implements Serializable{
	private static final long serialVersionUID = 1L;
	private UploadedFile file;
	private int idFoto;
	private int idUsuario;
	private String nombre_foto;
	private byte[] foto1;
	
	
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
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
