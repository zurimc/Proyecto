package com.lab.sdt.view;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean

public class Estado implements Serializable {

	private List<Estado> estados;
	private String estado;
	
	@PostConstruct
	public void init(){
		estados = unidadService.obtenerUnidadesPorIdCliente(usuarioDTO.getIdCliente());
		if(estados.isEmpty()){
			estados.add(generarUnidadVacia());
		}
	}
	public void generarEstados(){
		Estado estado = obtenerUnidadPorId();
		if(estado == null){
			MensajeGrowl.mostrar("Debe seleccionar una unidad", FacesMessage.SEVERITY_WARN);
			return;
		}
	}
	private List<Estado> getEstados() {
		return estados;
	}
	private void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	private String getEstado() {
		return estado;
	}
	private void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
