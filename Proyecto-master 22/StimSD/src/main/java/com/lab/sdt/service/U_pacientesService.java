package com.lab.sdt.service;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EnfermedadMapper;
import com.lab.sdt.dao.ExpeEstimMapper;
import com.lab.sdt.dao.ExpedienteConsultaMapper;
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.NumOndaMapper;

import com.lab.sdt.dao.PresionintraocularMapper;
import com.lab.sdt.dao.UbicacionMapper;
import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import com.lab.sdt.model.ExpeEstim;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteConsulta;
import com.lab.sdt.model.ExpedienteConsultaExample;
import com.lab.sdt.model.ExpedienteConsultaExample.Criteria;
import com.lab.sdt.model.ExpedienteExample;
import com.lab.sdt.model.NumOnda;

import com.lab.sdt.model.Presionintraocular;
import com.lab.sdt.model.PresionintraocularExample;
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
	private NumOndaMapper numOndaMapper;
	
	@Autowired
	private ExpedienteConsultaMapper expedienteConsultaMapper;

	@Autowired
	private PresionintraocularMapper presionintraocularMapper;
	
	private final int FECHA_INICIO = 1;
	private final int FECHA_FIN = 2;
	
	public void actulizar_consulta(ExpedienteConsulta ec) {
		expedienteConsultaMapper.updateByPrimaryKey(ec);
	}
		


	public List<ExpedienteConsulta> consulta_fechas(Date inicio_f, Date fin_f, int idexp) {
		ExpedienteConsultaExample exp_ex = new ExpedienteConsultaExample();
			Criteria critexp = exp_ex.createCriteria();
		critexp.andFechaconsultaBetween(generarFecha(inicio_f, FECHA_INICIO), generarFecha(fin_f, FECHA_FIN));
		critexp.andIdexpedienteEqualTo(idexp);
		
		return expedienteConsultaMapper.selectByExample(exp_ex);
	}
	
	
	public void registroConsulta(ExpedienteConsulta EXPC) throws Exception{
		
		insertarConsulta(EXPC);
	}
	
public void registroPresion(Presionintraocular presI) throws Exception{
		
		insertarPresion(presI);
	}

	public int insertarConsulta(ExpedienteConsulta expedienteConsulta)throws Exception{
		expedienteConsultaMapper.insert(expedienteConsulta);
		ExpedienteConsultaExample exp_ex = new ExpedienteConsultaExample();
		Criteria critexp = exp_ex.createCriteria();
		critexp.andIdexpedienteEqualTo(expedienteConsulta.getIdexpediente());
		List<ExpedienteConsulta> expconl =  expedienteConsultaMapper.selectByExample(exp_ex);
		return expconl.get(expconl.size() -1).getIdexpeconsul();
	}
	public void insertarPresion(Presionintraocular presionintraocular)throws Exception{
		presionintraocularMapper.insert(presionintraocular);
	}
	public void modificarPresion(Presionintraocular presionintraocular)throws Exception{
		presionintraocularMapper.updateByPrimaryKey(presionintraocular);
	}
	public void modificarExpedienteConsulta(ExpedienteConsulta expedienteConsulta)throws Exception{
		expedienteConsultaMapper.updateByPrimaryKey(expedienteConsulta);
	}
	
public Presionintraocular encuentrap (int idexpC) {
	PresionintraocularExample ex_pre = new PresionintraocularExample();
	com.lab.sdt.model.PresionintraocularExample.Criteria criPre = ex_pre.createCriteria();
	criPre.andIdexpConsultaEqualTo(idexpC);
	List<Presionintraocular> exp_presion = presionintraocularMapper.selectByExample(ex_pre);
	return exp_presion.get(exp_presion.size()-1);
}
//buscador de expedient
public List<Expediente> lista_exp(){
	
	List<Expediente> list_expediente =  new ArrayList<Expediente>();
	ExpedienteExample expedienteEx =  new ExpedienteExample();
	list_expediente = expedienteMapper.selectByExample(expedienteEx);
	return list_expediente;
}

public List<Expediente> entrega_expedientes(){
	ExpedienteExample exC = new ExpedienteExample();
	return expedienteMapper.selectByExample(exC);
}


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
	public List<Expediente> expediente_por_doc (int idmedico) {
		return expedienteMapper.selectByidDoctor(idmedico);
	}
	private Date generarFecha(Date fecha, int tipoFecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		if(tipoFecha == FECHA_INICIO){
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 1);
		}else if(tipoFecha == FECHA_FIN){
			cal.set(Calendar.HOUR, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
		}
		return cal.getTime();
	}
}
