package com.lab.sdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dto.RespuestaDTO;

import com.lab.sdt.model.Usuario;

import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.dto.ConsultaDTO;
import com.lab.sdt.dao.OndaMapper;
import com.lab.sdt.dao.OndaValorMapper;
import com.lab.sdt.dao.TipondaMapper;

import com.lab.sdt.dao.NumOndaMapper;

import com.lab.sdt.dao.ValorMapper;
import com.lab.sdt.model.Onda;
import com.lab.sdt.model.NumOnda;
import com.lab.sdt.model.Tiponda;
import com.lab.sdt.model.OndaValor;


import com.lab.sdt.model.OndaExample;
import com.lab.sdt.model.TipondaExample;

import com.lab.sdt.model.NumOndaExample;

@Service
@Transactional
public class ConsultaSOAP {
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Autowired
	private OndaMapper ondaMapper;
	
	@Autowired
	private OndaValorMapper ondaValorMapper;
	
	@Autowired
	private ValorMapper valorMapper;
	
	@Autowired
	private TipondaMapper tipondaMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
	public RespuestaDTO consulta_usuario(ConsultaDTO consulta) {
		RespuestaDTO respuesta = new RespuestaDTO();
		respuesta = inicio_seccion(consulta);
		return respuesta;
	}

	public RespuestaDTO inicio_seccion(ConsultaDTO consu) {
		RespuestaDTO res = new RespuestaDTO();
		res.setAutorizacion(false);
		//res.setMensaje("Sin autorización");
		res.setTipo_usuario(0);
		if(!validarConsulta(consu, res)){
			return res;
		}
		try {
			List<Usuario> contenedor_usuario = usuarioMapper.selectByCuenta(consu.getNombre());
			if(contenedor_usuario.size() >=0) {
				if(contenedor_usuario.get(0).getContrasenia().equals(consu.getContrasena())) {	
					res.setTipo_usuario(contenedor_usuario.get(0).getIdtipo());
					if(contenedor_usuario.get(0).getEstatus().equals("A")) {
						if(consu.getTipo_consulta() == 0) // inicio de sección
						{
							res.setAutorizacion(true);
							res.setMensaje("Autorizado");
						}else if(consu.getTipo_consulta() == 1) //consulta datos de los grupos de onda
						{
							res.setAutorizacion(true);
							res.setMensaje("Autorizado");
			
							res.setOndas(todos_los_grupos_de_ondas());
						
							
						}else if(consu.getTipo_consulta() == 2) // consulta datos de una onda en expecifico onda
						{
							res.setAutorizacion(true);
							res.setMensaje("Autorizado");
			
							res.setOndas(valores_de_la_onda(consu.getPeticion()));
							
						}else if(consu.getTipo_consulta() == 3)// consulta datos de los tipos de onda
						{
							res.setAutorizacion(true);
							res.setMensaje("Autorizado");
							
							res.setOndas(tipos_de_ondas(consu.getPeticion()));
						}else{
							res.setAutorizacion(false);
							res.setMensaje("Error??");
						}

					}else {
						res.setMensaje("Sin autorización");
					}
					
				}else {
					res.setMensaje("Contraseña no valida");
				} 
			}else {
				res.setMensaje("No se encuentra el usuario");
			}
		}catch(Exception e) {
			res.setMensaje("Ocurrio una excepcion: "+e.getMessage());
		}
		return res;
	}
	private String valores_de_la_onda(String idNum_Ondaa) {
		String res = "";
		String[] valores = new String[300];
		int idNum_Ondaan = 0;
		int idondaa = 0;
		try {
			idNum_Ondaan = Integer.parseInt(idNum_Ondaa);
			idondaa = numOndaMapper.selectByPrimaryKey(idNum_Ondaan).getIdonda();
			List<OndaValor> ondvalor =ondaValorMapper.selectByidOnda(idondaa);
			for(int ii =0; ii<= ondvalor.size()-1; ii++) {
				valores[ii] = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				res = res + valores[ii]+":";
			}
		}catch(Exception e) {}
		return res;
	}

	private String todos_los_grupos_de_ondas() {
		String res = "";
		TipondaExample onEx = new TipondaExample();
		Tiponda tipond = new Tiponda();
		for(int ii = 1; ii<= tipondaMapper.countByExample(onEx); ii++) {
			tipond = tipondaMapper.selectByPrimaryKey(ii);
			res =res + tipond.getIdtiponda() +"/"+tipond.getNombre()+":";
		}
		return res;
	}
	private String tipos_de_ondas(String idTipOnda1) {
		String res = "";
		NumOndaExample onumEx = new NumOndaExample();
		 List<NumOnda> todas_las_ondas = numOndaMapper.selectByExample(onumEx);
		 int idtiponda2 = 0;
	 try {
		 idtiponda2 = Integer.parseInt(idTipOnda1);
	 }catch(Exception e) {}
		for(int ii = 0; ii<= todas_las_ondas.size()-1; ii++) {
			if(todas_las_ondas.get(ii).getIdtiponda() == idtiponda2) {
				res =res + todas_las_ondas.get(ii).getIdnumOnda()+"/"+todas_las_ondas.get(ii).getNombre()+":";
			}
	//		numond = numOndaMapper.selectByPrimaryKey(1);
	//		res =res + numond.getIdnumOnda()+"/"+numond.getNombre()+":";
		}
	
		return res;
	}
	private boolean validarConsulta(ConsultaDTO consulta,RespuestaDTO respuesta) {
		if(consulta.getFecha()== null) {
			respuesta.setMensaje("Sin fecha");
			return false;
		}
		if(consulta.getLatitud()==null ) {
			respuesta.setMensaje("sin Latitud");
			return false;
		}
		if(consulta.getLongitud()==null ) {
			respuesta.setMensaje("sin Longitud");
			return false;
		}
		if(consulta.getContrasena()==null ) {
			respuesta.setMensaje("sin Contraseña");
			return false;
		}
		if(consulta.getNombre()==null ) {
			respuesta.setMensaje("sin Nombre");
			return false;
		}
		return true;
		
	}

}
