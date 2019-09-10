package com.lab.sdt.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EnfermedadMapper;
import com.lab.sdt.dao.ExpeEstimMapper;
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.NumOndaMapper;
import com.lab.sdt.dao.OndaMapper;
import com.lab.sdt.dao.UbicacionMapper;
import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import com.lab.sdt.model.ExpeEstim;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteExample;
import com.lab.sdt.model.NumOnda;
import com.lab.sdt.model.Onda;
import com.lab.sdt.model.Ubicacion;

@Service
@Transactional
public class U_pacientesService {

	@Autowired
	private EnfermedadMapper enfermedadMapper;
	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	@Autowired
	private ExpeEstimMapper expeEstimMapper;
	
	@Autowired
	private UbicacionMapper ubicacionMapper;
	
	@Autowired
	private OndaMapper ondaMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
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
	public List<ExpeEstim> lista_historico_expediente(int idExpe){
		return expeEstimMapper.selectByidExpediente(idExpe);
	}
	public Ubicacion ubica(int idkey){
		return ubicacionMapper.selectByPrimaryKey(idkey);
	}
	public NumOnda regresa_onda_nombre(int idkey) {
		return numOndaMapper.selectByidOnda(idkey).get(0);
	}

}
