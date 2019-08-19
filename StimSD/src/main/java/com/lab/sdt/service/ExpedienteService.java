package com.lab.sdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteExample;


@Service
@Transactional
public class ExpedienteService {

	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public List<Expediente> expedientes;
	public List<Expediente> pacientes;
	
	
	public List<Expediente> lista_exp() {
		List<Expediente> list_exp = new ArrayList<Expediente>();
		ExpedienteExample ExpedienteEx = new ExpedienteExample();
		list_exp = expedienteMapper.selectByExample(ExpedienteEx);
		return list_exp;
	}
	//lista para pacientes
	/*public List<Expediente> lista_pacientes() {
		List<Expediente> lista_pacientes = new ArrayList<Expediente>();
		ExpedienteExample ExpedientePa = new ExpedienteExample();
		list_pa = expedienteMapper.selectByExample(ExpedientePa);
		return list_pa;
	}*/
	
	//encuentra expediente
	public Expediente encuentra_expediente (String noExpediente) {
		Expediente expedienta = new Expediente();
		expedienta = expedienteMapper.selectByExpediente(noExpediente).get(0);
		return expedienta;
	}
	
	//actualizar expediente
	
	public void actualizar_expediente(Expediente e) {
		expedienteMapper.updateByPrimaryKey(e);
	}
	
	public String actualizarexp (String actualizarexp) {
		
		String ex = null;
		try {
			ex= encuentra_expediente(actualizarexp).getNoexpediente();
		}catch(Exception e) {
			ex = null;
		}
		return ex;
	}
	
	//insertar en base de datos
	public void insertarexpediente(Expediente noExpediente) throws Exception {
		expedienteMapper.insert(noExpediente);
		
	}
	
}
