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
import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.service.HospitalService;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class HospitalView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{hospitalService}")
	public HospitalService hospitalService;
	@ManagedProperty("#{estadoUnidad}")
	public EstadoUnidad estadoUnidad;

	
	public String nom_hospital;
	public String hospital;
	public String hospital_b;	
	public String calle;
	public String numero;
	public String colonia;
	public String codigoPostal;
	public int idEstado;
	public String telefono;
	public char estatus;
	private boolean skiph;
	private int tipos_vistas;
	
	
	public List<SelectItem> hospitales1;
	private List<Hospital> hospitales;
	public List<SelectItem> estados;
	
	private Hospital seleccion_hosp;
	private String buscador = "";
	
	@PostConstruct
	public void init(){
		setHospital("");
		
		hospitales = new ArrayList<Hospital>();
		hospitales = hospitalService.lista_hospital();
		
		hospitales1 = new ArrayList<SelectItem>();
		estados = new ArrayList<SelectItem>();
		seleccion_hosp = new Hospital();
		try {
			hospitales1 = hospitalService.getLista_hospital();
			estados = estadoUnidad.getLista_estados();
			
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}

}

	public void buscar_hospitales() {
		 if(hospital_b.trim().length() > 0) {
			 try {
				 Hospital ho = new Hospital();
				
				 hospitales.clear();
				 
					 ho =  hospitalService.encuentra_hospital(hospital_b);
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
	//cargar toda la lista de hospitales
	public void cargar_lis_hospi() {
		hospitales = new ArrayList<Hospital>();
		hospitales.clear();
		try {
			hospitales = hospitalService.lista_hospital();
			
		}catch(Exception e) {
			
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
		
		setNom_hospital(seleccion_hosp.getHospital());
		setCalle(seleccion_hosp.getCalle());
		setNumero(seleccion_hosp.getNumero());
		setColonia(seleccion_hosp.getColonia());
		setCodigoPostal(seleccion_hosp.getCodigopostal());
		setIdEstado(seleccion_hosp.getIdestado());
		setTelefono(seleccion_hosp.getTelefono());
		
		
	}
	
	//CAMBIAR VISTAS
    public void vista_hospital() {
          hospitales = new ArrayList<Hospital>();
          hospitales = hospitalService.lista_hospital();
          tipos_vistas =  1;
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
	public void muestra() {

		try {

		
		MensajeG.mostrar("", FacesMessage.SEVERITY_WARN);
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
		
		//setResultado("Prueba base de datos");
		
		
	}
	//insertar datos de hospital
	
    public void registroHospital(int tipo) {
        
        Hospital hospital1 = new Hospital();
    	hospital1.setHospital(nom_hospital);
		hospital1.setCalle(calle);
		hospital1.setNumero(numero);
		hospital1.setColonia(colonia);
		hospital1.setCodigopostal(codigoPostal);
		hospital1.setIdestado(idEstado);
		hospital1.setTelefono(telefono);
        
        
        try {
        	if(tipo==0) {
        		hospitalService.insertarHospital(hospital1);
                MensajeG.mostrar("Se guardo hospital: " +nom_hospital, FacesMessage.SEVERITY_WARN);
                
        	} else {
        		hospital1.setIdhospital(hospitalService.encuentra_hospital(nom_hospital).getIdhospital());
        		hospitalService.actualizar_registro(hospital1);
        		  MensajeG.mostrar("Se actualizo el hospital: "+nom_hospital, FacesMessage.SEVERITY_INFO);
        	}
        	
            
        } catch (Exception e) {
            MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
        }
        
        
    }
    public void guarda_actualiza_datos() {
    	setNom_hospital(getNom_hospital());
    	setCalle(getCalle());
    	setNumero(getNumero());
    	setColonia(getColonia());
    	setCodigoPostal(getCodigoPostal());
    	setIdEstado(getIdEstado());
    	setTelefono(getTelefono());
    }
    
    //ACTUALIZAR DATOS
    public void actualizar() {
    	try {
    		if(nom_hospital.trim().length() > 0) {
    			if(hospitalService.actualizarh(nom_hospital)== null) {
    				
    				 //MensajeG.mostrar(hospitalService.actualizarh(nom_hospital)+":"+nom_hospital, FacesMessage.SEVERITY_WARN);
    				registroHospital(0);
    			}else {
    				 //MensajeG.mostrar(hospitalService.actualizarh(nom_hospital)+":"+nom_hospital, FacesMessage.SEVERITY_WARN);
     				
    				registroHospital(1);
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
    	}
    }
	public HospitalService getHospitalService() {
		return hospitalService;
	}


	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}




	public String getNom_hospital() {
		return nom_hospital;
	}

	public void setNom_hospital(String nom_hospital) {
		this.nom_hospital = nom_hospital;
	}

	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public EstadoUnidad getEstadoUnidad() {
		return estadoUnidad;
	}

	public void setEstadoUnidad(EstadoUnidad estadoUnidad) {
		this.estadoUnidad = estadoUnidad;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}
	public String getHospital_b() {
		return hospital_b;
	}

	public void setHospital_b(String hospital_b) {
		this.hospital_b = hospital_b;
	}

	public char getEstatus() {
		return estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}

	public int getTipos_vistas() {
		return tipos_vistas;
	}

	public void setTipos_vistas(int tipos_vistas) {
		this.tipos_vistas = tipos_vistas;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	
}
