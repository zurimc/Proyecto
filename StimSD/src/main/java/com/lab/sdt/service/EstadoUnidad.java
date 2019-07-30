package com.lab.sdt.service;

import java.util.ArrayList;

import java.util.List;


import javax.faces.model.SelectItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EstadoMapper;
import com.lab.sdt.model.Estado;

import com.lab.sdt.model.EstadoExample;







@Service
@Transactional
public class EstadoUnidad {
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	public List<SelectItem> lista_estados;
       	

	public List<Estado> estados1;
	
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
