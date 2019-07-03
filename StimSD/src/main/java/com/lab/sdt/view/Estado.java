package com.lab.sdt.view;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import com.lab.sdt.dto.EstadoDTO;
import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@ManagedProperty("#{estadoUnidad}")
	private EstadoUnidad estadoUnidad;
	
	
	public EstadoUnidad getEstadoUnidad() {
		return estadoUnidad;
	}

	public void setEstadoUnidad(EstadoUnidad estadoUnidad) {
		this.estadoUnidad = estadoUnidad;
	}

	//public List<EstadoDTO> estados;
	public List<String> listaestados;
	//private int idEstado;
	
	@PostConstruct
	public void init(){
		//EstadoDTO j = new EstadoDTO();
		for(int i = 0; i >= estadoUnidad.selectEstado_v().size()-1; i++){
			listaestados.set(i, estadoUnidad.selectEstado_v().get(i).getEstado()); 
			//j.setEstado(estadoUnidad.selectEstado_v().get(i).getEstado());
			//j.setIdEstado(estadoUnidad.selectEstado_v().get(i).getIdestado());
			//estados.add(j);
		}
	}

	public List<String> getListaestados() {
		return listaestados;
	}

	public void setListaestados(List<String> listaestados) {
		this.listaestados = listaestados;
	}
	
	
}
