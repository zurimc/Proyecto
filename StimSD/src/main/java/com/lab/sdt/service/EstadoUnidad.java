package com.lab.sdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EstadoMapper;
import com.lab.sdt.dto.EstadoDTO;
import com.lab.sdt.model.Estado;



@Service
@Transactional
public class EstadoUnidad {
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	public List<Estado> selectEstado_v(){

		return estadoMapper.selectEstado();
	}
}
