package com.lab.sdt.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.ExpedienteConsultaMapper;
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.PresionintraocularMapper;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteConsulta;

import com.lab.sdt.model.ExpedienteExample;
import com.lab.sdt.model.Parametro;
import com.lab.sdt.model.Presionintraocular;


@Service
@Transactional
public class ConsultaService {

	@Autowired
	private ExpedienteConsultaMapper expedienteConsultaMapper;

	@Autowired
	private PresionintraocularMapper presionintraocularMapper;
	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	public void registroConsulta(ExpedienteConsulta EXPC) throws Exception{
		
		insertarConsulta(EXPC);
	}
	
public void registroPresion(Presionintraocular presI) throws Exception{
		
		insertarPresion(presI);
	}
public void actulizar_consulta(ExpedienteConsulta ec) {
	expedienteConsultaMapper.updateByPrimaryKey(ec);
}
	

	//REGISTRAR UN HOSPITAL

	
	public void insertarConsulta(ExpedienteConsulta expedienteConsulta)throws Exception{
		expedienteConsultaMapper.insert(expedienteConsulta);
	}
	public void insertarPresion(Presionintraocular presionintraocular)throws Exception{
		presionintraocularMapper.insert(presionintraocular);
	}
	
	public ExpedienteConsulta obtenerConsulta(Date fconsulta) {
		List<ExpedienteConsulta> contenedor_consulta = expedienteConsultaMapper.selectByFechaConsulta(fconsulta);
		return contenedor_consulta.get(0);
	}
	
	public Presionintraocular obtenerPresion(Date fpresion) {
		List<Presionintraocular> contenedor_presion = presionintraocularMapper.selectByFechaPresion(fpresion);
		return contenedor_presion.get(0);
	}
	
public Date registro_consulta(Date fconsulta) {
	Date res= null;
	try {
	res= obtenerConsulta(fconsulta).getFechaconsulta();
	}catch(Exception e) {
		res=null;
	}
	return res;
}

public Date registro_presion(Date fpresion) {
	Date resp= null;
	try {
	resp= obtenerPresion(fpresion).getFecha();
	}catch(Exception e) {
		resp=null;
	}
	return resp;
}
//buscador de expedient
public List<Expediente> lista_exp(){
	
	List<Expediente> list_expediente =  new ArrayList<Expediente>();
	ExpedienteExample expedienteEx =  new ExpedienteExample();
	list_expediente = expedienteMapper.selectByExample(expedienteEx);
	return list_expediente;
}
public List<Expediente> encuentra_expediente (String noExpediente) {
	List<Expediente> exped= new ArrayList<Expediente>();
	exped= expedienteMapper.selectByNoSerie(noExpediente);
	return exped;
}
}
