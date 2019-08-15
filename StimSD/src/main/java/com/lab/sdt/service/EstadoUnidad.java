package com.lab.sdt.service;

import java.util.ArrayList;

import java.util.List;


import javax.faces.model.SelectItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EstadoMapper;
import com.lab.sdt.dao.GradoMapper;


import com.lab.sdt.model.EstadoExample;
import com.lab.sdt.model.GradoExample;


@Service
@Transactional
public class EstadoUnidad {
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	@Autowired
	private GradoMapper gradoMapper;
	
	private List<SelectItem> lista_estados;
       	
	private List<SelectItem> lista_grado;


	
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
}
