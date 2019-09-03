package com.lab.sdt.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EnfermedadMapper;
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteExample;

@Service
@Transactional
public class U_pacientesService {

	@Autowired
	private EnfermedadMapper enfermedadMapper;
	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	public List<Enfermedad> lista_enfermedad(){
		  List<Enfermedad> list_en = new ArrayList<Enfermedad>();
		  EnfermedadExample exen = new EnfermedadExample();
		  list_en =  enfermedadMapper.selectByExample(exen);
		 return list_en;
	}
	public void insertaExpediente(Expediente exp) {
		expedienteMapper.insert(exp);
	}
	public List<Expediente> muestra_expedietes(Integer idusuario) {
		return expedienteMapper.selectByidUsuario(idusuario);
	}
	public List<Expediente> todosExpedientes(){
		 List<Expediente> list_expe = new ArrayList<Expediente>();
		 ExpedienteExample exexpe = new ExpedienteExample();
		 list_expe = expedienteMapper.selectByExample(exexpe);
		 return list_expe;
	}
	public Enfermedad encuentra_por_id(int idkey) {
		return enfermedadMapper.selectByPrimaryKey(idkey);
	}
	public void modificaExpediente(Expediente exp) {
		expedienteMapper.updateByPrimaryKey(exp);
	}
}
