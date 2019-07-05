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
import javax.faces.model.SelectItemGroup;

import org.primefaces.context.RequestContext;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import com.lab.sdt.dto.EstadoDTO;
import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class EstadoView implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@ManagedProperty("#{estadoUnidad}")
	public EstadoUnidad estadoUnidad;
	
	
	public EstadoUnidad getEstadoUnidad() {
		return estadoUnidad;
	}

	public void setEstadoUnidad(EstadoUnidad estadoUnidad) {
		this.estadoUnidad = estadoUnidad;
	}

	//public List<EstadoDTO> estados;
	public List<SelectItem> listaestados;
	//private int idEstado;
	
	@PostConstruct
	public void init(){
		listaestados = new ArrayList<SelectItem>();
		SelectItemGroup g1 = new SelectItemGroup("estado");
		//g1.setSelectItems(new SelectItem[] {new SelectItem(estadoUnidad.selectEstado_v())});
		//listaestados.add(g1);
		//listaestados = estadoUnidad.selectEstado_v();
		//EstadoDTO j = new EstadoDTO();
		//for(int i = 0; i >= estadoUnidad.selectEstado_v().size()-1; i++){
			//listaestados.set(i, estadoUnidad.selectEstado_v().get(i).getEstado()); 
			//j.setEstado(estadoUnidad.selectEstado_v().get(i).getEstado());
			//j.setIdEstado(estadoUnidad.selectEstado_v().get(i).getIdestado());
			//estados.add(j);
		//}
	}

	public List<SelectItem> getListaestados() {
		return listaestados;
	}

	public void setListaestados(List<SelectItem> listaestados) {
		this.listaestados = listaestados;
	}
	public void muestra() {

		//EstadoDTO j = new EstadoDTO();
				//for(int i = 0; i >= estadoUnidad.selectEstado_v().size()-1; i++){
					//listaestados.set(i, estadoUnidad.selectEstado_v().get(i).getEstado()); 
					//j.setEstado(estadoUnidad.selectEstado_v().get(i).getEstado());
					//j.setIdEstado(estadoUnidad.selectEstado_v().get(i).getIdestado());
					//estados.add(j);
				//}
		//listaestados.set(0, estadoUnidad.selectEstado_v().size()+""); listaestados.get(0)
		try {
			//EstadoDTO j = new EstadoDTO();
			//int j = estadoUnidad.selectEstado_v().size();
			//listaestados =  estadoUnidad.selectEstado_v();
		//consultaUsuarios.insertarUsuario("prueba");
		MensajeG.mostrar(estadoUnidad.selectEstado_v().get(0)+"", FacesMessage.SEVERITY_WARN);
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
		
		//setResultado("Prueba base de datos");
		
		
	}
	
}
