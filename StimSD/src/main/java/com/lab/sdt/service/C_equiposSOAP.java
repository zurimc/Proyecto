package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EquipoMantenMapper;
import com.lab.sdt.dao.EquipoMapper;
import com.lab.sdt.dao.MantenimientoMapper;
import com.lab.sdt.dao.NumOndaMapper;

import com.lab.sdt.dto.EquipoDTO;
import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.MantenimientoExample;


@Service
@Transactional
public class C_equiposSOAP {
	@Autowired
	private EquipoMapper equipoMapper;
	
	@Autowired
	private MantenimientoMapper mantenimientoMapper;
	
	@Autowired
	private EquipoMantenMapper equipoMantenMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
	
	public RespuestaDTO consulta_equipos(EquipoDTO equipoD) {
		RespuestaDTO respuesta = new RespuestaDTO();
		respuesta = ingresaequipo(equipoD);
		return respuesta;
	}
	public RespuestaDTO ingresaequipo(EquipoDTO equipoD) {
		RespuestaDTO res = new RespuestaDTO();
		res.setAutorizacion(false);
		//res.setMensaje("Sin autorización");
		res.setTipo_usuario(0);
		if(!validarequipos(equipoD, res)){
			return res;
			
		}
		try {
			 if(equipoD.geteTipo() ==  0) // desea registrar un equipo 
			 {
				 String[] partes_serie = equipoD.geteSerie().split(";");
				 if(!buscar_serie(equipoD.geteSerie())){
					 registro_equiposSOAP(equipoD);
					res.setAutorizacion(true);
					res.setMensaje("Equipo: "+partes_serie[0]+" registrado");
				 }else {
					 res.setAutorizacion(false);
					res.setMensaje("Ya existe: "+partes_serie[0]);
				 }
			 }else if(equipoD.geteTipo() ==  1) // desea ver registro de un equipo 
			 {
				 Equipo estimulador2 = new Equipo();
				 estimulador2.setIdequipo(0);
				 try { 
					 estimulador2 =  busca_equipo(equipoD.geteSerie());
				 }catch(Exception e) {
					 res.setMensaje("Equipo no registrado "+e.toString());
				 }
				 if(estimulador2.getIdequipo() == 0){
					 res.setAutorizacion(false);
					 res.setMensaje("Equipo no registrado ");
				 }else {
					 
					 if(estimulador2.getEstatus().equals("true")) {
						 res.setAutorizacion(true);
						 res.setTipo_usuario(1);
						 res.setMensaje("Equipo Autorizado");
					 }else {
						 res.setAutorizacion(true);
						 res.setTipo_usuario(0);
						 res.setMensaje("Equipo No autorizado");
					 }
				 }
			 }else if(equipoD.geteTipo() ==  2) // desea modificar numero de botón y tipo de onda
			 {
				 Equipo estimulador2 =  busca_equipo(equipoD.geteSerie());
				 estimulador2.setOndapredeterminada(equipoD.getEonda());
				 estimulador2.setTipo(equipoD.getEtipoOnda());
				 //equipoMapper.updateByPrimaryKey(estimulador2);
				 registro_mantenimientoSOAP(equipoD.getElatitud(),equipoD.getElongitud(),"Cambio de configuración del botón a: "+equipoD.getEtipoOnda()+" veces de activación con la onda: "+equipoD.getEonda() +" del equipo","Configuración Equipo",estimulador2.getIdequipo(),equipoD.getEid_usuario());
				 res.setAutorizacion(true);
				 res.setMensaje("Evento registrado");
			 }else if(equipoD.geteTipo() ==  3) // desea modificar parametros 
			 {
				 Equipo estimulador2 =  busca_equipo(equipoD.geteSerie());
				 
				 double ef = Double.parseDouble(equipoD.getEfrecuencia());
				 String efs = String.valueOf(ef);
				 
				 double ea = Double.parseDouble(equipoD.getEamplitud());
				 String eas = String.valueOf(ea);
				 
				 double et = Double.parseDouble(equipoD.getEtiempo());
				 String ets = String.valueOf(et);
				 
				 registro_mantenimientoSOAP(equipoD.getElatitud(),equipoD.getElongitud(),
						 "Cambio de configuración de parámetros: Frecuencias = "+efs+" Hz"+
						 ", Amplitud = "+eas +" V"+", Tiempo = "+ets+" min"+
								 " de la onda "+equipoD.getEonda()+" del equipo" ,"Configuración Parámetros",estimulador2.getIdequipo(),equipoD.getEid_usuario());
				 res.setAutorizacion(true);
				 res.setMensaje("Evento registrado");
			 }else if(equipoD.geteTipo() ==  4) // desea modificar la onda 
			 {
				 int idNum_Ondaane = Integer.parseInt(equipoD.getEnumonda());
				 String onda_nom = entrega_onda(idNum_Ondaane);
				 Equipo estimulador2 =  busca_equipo(equipoD.geteSerie()); 
				 estimulador2.setOndapredeterminada(equipoD.getEonda());
				 String[] partes_serie_l = estimulador2.getDetalles().split(";");
				 estimulador2.setDetalles(partes_serie_l[0]+";"+partes_serie_l[1]+";"+partes_serie_l[2]+";"+onda_nom);
				 equipoMapper.updateByPrimaryKey(estimulador2);
				 
				 registro_mantenimientoSOAP(equipoD.getElatitud(),equipoD.getElongitud(),"Cambio en la localidad "+equipoD.getEonda() +" del equipo"
						 +" con la forma de onda "+onda_nom+" del servidor","Configuración Onda",estimulador2.getIdequipo(),equipoD.getEid_usuario());
				 res.setAutorizacion(true);
				 res.setMensaje("Evento registrado");
			 }
			 else if(equipoD.geteTipo() ==  5){ // se esta probando el equipo y sus formas de onda 
				 Equipo estimulador2 =  busca_equipo(equipoD.geteSerie());

				 
				 registro_mantenimientoSOAP(equipoD.getElatitud(),equipoD.getElongitud(),
						 "Prueba forma de onda "+equipoD.getEonda() +" del equipo","Prueba Forma Onda",estimulador2.getIdequipo(),equipoD.getEid_usuario());
				 res.setAutorizacion(true);
				 res.setMensaje("Evento registrado");
			 }else{
			  res.setAutorizacion(false);
				res.setMensaje("Evento no registrado");
			 }
			
		}catch(Exception e) {
			res.setMensaje("Ocurrio una excepcion: "+e.getMessage());
		}
		return res;
	}
	private  boolean buscar_serie(String serie_bus) {
		boolean hay_s = false;
		String[] partes_serie = serie_bus.split(";");
		Equipo estimulador = new Equipo();
		if(serie_bus.trim().length() > 0) {
			 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
			 {
				 estimulador = equipoMapper.selectBySerie(partes_serie[0]+";"+jjf);
				 if(estimulador!=null) {
					 hay_s = true;
					 return hay_s;
				 }
			 }
		}
		return hay_s;
	}
	private Equipo busca_equipo(String serie_bus) {
		Equipo estimulador = new Equipo();
		Equipo estimulador1 = new Equipo();
		String[] partes_serie = serie_bus.split(";");
		if(serie_bus.trim().length() > 0) {
			 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
			 {
				 String serieg = partes_serie[0]+";"+jjf;
				try {
					 estimulador1 = equipoMapper.selectBySerie(serieg);
					 if(estimulador1.getIdequipo()>0) {
						 estimulador = estimulador1;
						 return estimulador;
					 }
				}catch(Exception e) {}
			 }
		}
		return estimulador;
	}
	private void registro_equiposSOAP(EquipoDTO equipoD) {
		Equipo estimulador = new Equipo();
		estimulador.setNoserie(equipoD.geteSerie());
		estimulador.setDetalles(equipoD.geteLote()+";"+equipoD.getEComunicacion()+";"+equipoD.geteIMEI());
		estimulador.setEstado("");
		estimulador.setOndapredeterminada(equipoD.getEonda());
		estimulador.setTipo(equipoD.getEtipoOnda());
		estimulador.setEstatus("false");
		equipoMapper.insert(estimulador);

	}
	public void registro_mantenimientoSOAP(String lat, String log, String fallaa, String actuaa, int id_equipo, int id_usuario)  throws Exception{
			String mate_estatus = "";
			Mantenimiento man = new Mantenimiento() ;
			man.setFechamantenimiento(new Date());
			man.setTipoactualizacion(actuaa);
			man.setFalla(fallaa);
			man.setEstatus(mate_estatus);
			man.setIdusuario(id_usuario);
			man.setLatitud(lat);
			man.setLonguitud(log);
			mantenimientoMapper.insert(man);
			relacion_man_equ(id_equipo);
	}
	public void relacion_man_equ(int idequipoes) throws Exception{
		EquipoManten manequ = new EquipoManten();
		manequ.setIdequipo(idequipoes);
		 List<Mantenimiento> list_man = new ArrayList<Mantenimiento>();
		 MantenimientoExample man_ex = new  MantenimientoExample();
		 list_man = mantenimientoMapper.selectByExample(man_ex);
		 manequ.setIdmantenimiento(list_man.get(list_man.size()-1).getIdmantenimiento());
		 equipoMantenMapper.insert(manequ);

	}
	private boolean validarequipos(EquipoDTO equipoD,RespuestaDTO respuesta) {
		if(equipoD.geteIMEI()== null) {
			respuesta.setMensaje("Sin IMEI");
			return false;
		}
		if(equipoD.geteSerie()==null ) {
			respuesta.setMensaje("sin serie");
			return false;
		}
		if(equipoD.geteLote()==null ) {
			respuesta.setMensaje("sin lote");
			return false;
		}
		if(equipoD.getEComunicacion()==null ) {
			respuesta.setMensaje("sin comunicación especifica");
			return false;
		}if(equipoD.getEtipoOnda()==null ) {
			respuesta.setMensaje("sin botón predetermiando");
			return false;
		}if(equipoD.getEonda()==null ) {
			respuesta.setMensaje("sin forma de onda predetermidad");
			return false;
		}
		return true;
		
	}
	public String entrega_onda(int idNum_Ondaa) {
		return numOndaMapper.selectByPrimaryKey(idNum_Ondaa).getNombre();
	}

}
