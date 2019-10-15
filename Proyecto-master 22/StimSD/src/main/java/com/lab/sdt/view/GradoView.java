package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.lab.sdt.service.GradoService;
import com.lab.sdt.util.MensajeG;



@ManagedBean
@ViewScoped
public class GradoView implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	
	@ManagedProperty("#{gradoService}")
	public GradoService gradoService;

	
	public String grado;
	public String especialidad;
	
	public List<SelectItem> grados1;
	public List<SelectItem> especialidad1;
	
	
	@PostConstruct
	public void init(){
		grados1 = new ArrayList<SelectItem>();
		especialidad1 = new ArrayList<SelectItem>();
		try {
			grados1 = gradoService.getLista_grado();
			especialidad1 = gradoService.getLista_especialidad();
			
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
	}


	public GradoService getGradoService() {
		return gradoService;
	}


	public void setGradoService(GradoService gradoService) {
		this.gradoService = gradoService;
	}


	public String getGrado() {
		return grado;
	}


	public void setGrado(String grado) {
		this.grado = grado;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public List<SelectItem> getGrados1() {
		return grados1;
	}


	public void setGrados1(List<SelectItem> grados1) {
		this.grados1 = grados1;
	}


	public List<SelectItem> getEspecialidad1() {
		return especialidad1;
	}


	public void setEspecialidad1(List<SelectItem> especialidad1) {
		this.especialidad1 = especialidad1;
	}
	
	

}
