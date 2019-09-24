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
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.NumOndaMapper;
import com.lab.sdt.dao.OndaMapper;
import com.lab.sdt.dao.UbicacionMapper;
import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.ExpeEstim;
import com.lab.sdt.model.ExpeEstimExample;
import com.lab.sdt.model.ExpeEstimExample.Criteria;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteExample;

import com.lab.sdt.model.NumOnda;
import com.lab.sdt.model.Onda;
import com.lab.sdt.model.Ubicacion;


@Service
@Transactional
public class U_pacientesService {
	/*zuri*/
	private final int FECHA_INICIO = 1;
	private final int FECHA_FIN = 2;

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
	
	/*zuri*/
	public List<ExpeEstim> por_fecha_estimulacion(int idexpediente, Date fecha_I, Date fecha_F){
		List<ExpeEstim> res = new ArrayList<ExpeEstim>();
		List<Expediente> lista_estim =  lista_exp_estim(idexpediente);
		for(int i = 0;i<=lista_estim.size()-1;i++) {
			
			ExpeEstimExample exMan = new ExpeEstimExample();
			Criteria criteria = exMan.createCriteria();
			
			criteria.andFechaestimulacionBetween(generarFecha(fecha_I, FECHA_INICIO), generarFecha(fecha_F, FECHA_FIN));
			ExpeEstim expt = new ExpeEstim();
			expt = expeEstimMapper.selectByPrimaryKey(lista_estim.get(i).getIdexpediente());
			//if(generarFecha(fecha_I, FECHA_INICIO).after(man.getFechamantenimiento())) {
			//	if(fecha_F.before(man.getFechamantenimiento())) {
			expt.setFechaestimulacion(fecha_I);;
					res.add(expt);
			//	}
			//}
			
		}
		//res.add(mantenimientoMapper.selectByPrimaryKey(1));
		return res;
		
	}
	

	/*zuri*/
	
	public List<ExpeEstim> ver_historico(int idexpediente){
		List<ExpeEstim> resp = new ArrayList<ExpeEstim>();
		List<Expediente> lista_estimulacion = lista_exp_estim(idexpediente);
		for(int i = 0;i<=lista_estimulacion.size()-1;i++) {
			resp.add(expeEstimMapper.selectByPrimaryKey(lista_estimulacion.get(i).getIdexpediente()));
		}
		return resp;
	}
	public List<Expediente> lista_exp_estim(int idexpediente ){
		return expedienteMapper.selectByExpediente(idexpediente);
	}
	
	
	
	/*zuri*/
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
