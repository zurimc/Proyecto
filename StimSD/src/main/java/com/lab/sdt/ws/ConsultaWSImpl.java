package com.lab.sdt.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.service.ConsultaSOAP;
import com.lab.sdt.dto.ConsultaDTO;

@Service
public class ConsultaWSImpl implements ConsultaWS{
	
	@Autowired
	private ConsultaSOAP consultasoap;
	
	@Override
	public RespuestaDTO tipos_usuarios(ConsultaDTO consulta) {
		
		return consultasoap.consulta_usuario(consulta);
	}

}
