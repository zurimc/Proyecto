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

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;


import com.lab.sdt.model.Hospital;

import com.lab.sdt.service.HospitalService;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class HospitalView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{hospitalService}")
	public HospitalService hospitalService;
	
	public String hospital;
	public String calle;
	public int numero;
	public String colonia;
	public String codigoPostal;
	public int idEstado;
	public String telefono;
	private boolean skiph;
	
	
	public List<SelectItem> hospitales1;
	private List<Hospital> hospitales;
	
	
	private Hospital seleccion_hosp;
	private String buscador = "";
	
	@PostConstruct
	public void init(){
		setHospital("");
		
		hospitales = new ArrayList<Hospital>();
		hospitales = hospitalService.lista_hospital();
		
		hospitales1 = new ArrayList<SelectItem>();
		
		try {
			hospitales1 = hospitalService.getLista_hospital();
			
			
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}

}

	public void buscar_hospitales() {
		 if(hospital.trim().length() > 0) {
			 try {
				 Hospital ho = new Hospital();
				
				 hospitales.clear();
				 
					 ho =  hospitalService.encuentra_hospital(hospital);
					 if(ho!=null) {
						 
						 hospitales.add(ho);
					 
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		 }else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
		
		
	}
	
	//cargar hospitales
	
	public void cargar_hos() {
		hospitales = new ArrayList<Hospital>();
		hospitales = hospitalService.lista_hospital();
		
		seleccion_hosp = new Hospital();
		seleccion_hosp.setHospital("");
	}
	
	//ELEGIR UN HOSPITAL
	public void elige_hospital( SelectEvent event) {
		String[] lishopital = seleccion_hosp.getHospital().split(hospital);
		//setHospital(lishospital[0]);
		
	}
	//cambiar el flujo
	public boolean isSkiph() {
	    return skiph;
	}

	public void setSkiph(boolean skiph) {
	    this.skiph = skiph;
	}

	public String onFlowProcess(FlowEvent event) {
	    if(skiph) {
	        skiph = false;   //reset in case user goes back
	        return "confirm";
	    }
	    else {
	        return event.getNewStep();
	    }
	}
	
	//insertar datos de hospital
	public void registroHospital() {
		
		Hospital hospital1 = new Hospital();
		hospital1.setHospital(hospital);
		hospital1.setCalle(calle);
		hospital1.setNumero(numero);
		hospital1.setColonia(colonia);
		hospital1.setCodigopostal(codigoPostal);
		hospital1.setIdestado(idEstado);
		hospital1.setTelefono(telefono);
		try {
			
		}catch(Exception e ) {
			
		}
		
	}
	public HospitalService getHospitalService() {
		return hospitalService;
	}


	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}


	public String getHospital() {
		return hospital;
	}


	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
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


	public List<SelectItem> getHospitales1() {
		return hospitales1;
	}


	public void setHospitales1(List<SelectItem> hospitales1) {
		this.hospitales1 = hospitales1;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}

	public Hospital getSeleccion_hosp() {
		return seleccion_hosp;
	}

	public void setSeleccion_hosp(Hospital seleccion_hosp) {
		this.seleccion_hosp = seleccion_hosp;
	}

	public String getBuscador() {
		return buscador;
	}

	public void setBuscador(String buscador) {
		this.buscador = buscador;
	}
	
	
}
