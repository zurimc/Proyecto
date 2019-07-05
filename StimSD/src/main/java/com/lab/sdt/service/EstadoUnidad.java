package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EstadoMapper;
import com.lab.sdt.dto.EstadoDTO;
import com.lab.sdt.model.Estado;
import com.lab.sdt.model.EstadoExample;

import com.lab.sdt.model.EstadoExample.Criteria;



@Service
@Transactional
public class EstadoUnidad {
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	public List<String> selectEstado_v(){
		SelectItemGroup g1 = new SelectItemGroup("estado");
		List<Estado> todos_los_estados  = new ArrayList<Estado>();
		List<String> listaestados = new ArrayList<String>();
		/*listaestados.add(""+0);
		listaestados.add(""+1);
		listaestados.add(estadoMapper.selectByPrimaryKey(2).getEstado());
		listaestados.add(""+3);
		listaestados.add(""+4);
		*/
		for(int ii = 1; ii<= 33; ii++) {
			//estadoMapper.selectByPrimaryKey(2).getEstado()
		//listaestados.add(""+0);
			listaestados.add(estadoMapper.selectByPrimaryKey(ii).getEstado());
		}
		return listaestados;
	}
	

	
}
