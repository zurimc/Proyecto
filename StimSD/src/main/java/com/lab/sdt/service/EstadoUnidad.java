package com.lab.sdt.service;

import java.util.ArrayList;

import java.util.List;


import javax.faces.model.SelectItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EnfermedadMapper;
import com.lab.sdt.dao.EstadoMapper;
import com.lab.sdt.dao.GradoMapper;
import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import com.lab.sdt.model.Estado;
import com.lab.sdt.model.EstadoExample;
import com.lab.sdt.model.GradoExample;


@Service
@Transactional
public class EstadoUnidad {
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	@Autowired
	private GradoMapper gradoMapper;
	
	@Autowired
	private EnfermedadMapper enfermedadMapper;
	
	private List<SelectItem> lista_estados;
       	
	private List<SelectItem> lista_grado;

	private List<SelectItem> lista_enfermedades;
	
	public List<SelectItem> getLista_grado() {
		this.lista_grado = new ArrayList<SelectItem>();
		GradoExample exEstG = new GradoExample();
		for(int ii = 1; ii<= gradoMapper.countByExample(exEstG); ii++) {
			SelectItem grado = new SelectItem(ii,gradoMapper.selectByPrimaryKey(ii).getGrado());
			this.lista_grado.add(grado);
		}
		return lista_grado;
	}


	public void setLista_grado(List<SelectItem> lista_grado) {
		this.lista_grado = lista_grado;
	}

   public Estado estado_por_id(int id_estado) {
	   return estadoMapper.selectByPrimaryKey(id_estado);
   }
	public List<SelectItem> getLista_estados() {
		this.lista_estados = new ArrayList<SelectItem>();
		EstadoExample exEst = new EstadoExample();
		
		for(int ii = 1; ii<= estadoMapper.countByExample(exEst); ii++) {
			//estadoMapper.selectByPrimaryKey(2).getEstado()
		//listaestados.add(""+0);
			SelectItem estados = new SelectItem(ii,estadoMapper.selectByPrimaryKey(ii).getEstado());
			this.lista_estados.add(estados);
			//listaestados.add(estadoMapper.selectByPrimaryKey(ii).getEstado());
		}
		return lista_estados;
	}


	public void setLista_estados(List<SelectItem> lista_estados) {
		this.lista_estados = lista_estados;
	}


	public List<SelectItem> getLista_enfermedades() {
		this.lista_enfermedades = new ArrayList<SelectItem>();
		 EnfermedadExample exen = new EnfermedadExample();
		 List<Enfermedad> list_en = new ArrayList<Enfermedad>();
		 list_en =  enfermedadMapper.selectByExample(exen);
		 for(int ii = 1; ii<= enfermedadMapper.countByExample(exen); ii++) {
			 SelectItem enfermedad = new SelectItem(list_en.get(ii-1).getIdenfermedad(),list_en.get(ii-1).getEnfermedad());
				this.lista_enfermedades.add(enfermedad);
		 }
		return lista_enfermedades;
	}


	public void setLista_enfermedades(List<SelectItem> lista_enfermedades) {
		this.lista_enfermedades = lista_enfermedades;
	}
	
	
}
