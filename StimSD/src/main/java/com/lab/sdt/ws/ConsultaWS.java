package com.lab.sdt.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.dto.ConsultaDTO;
@WebService
public interface ConsultaWS {

	@WebResult(name="respuesta")
	RespuestaDTO tipos_usuarios(@WebParam(name="consultasoap")ConsultaDTO consulta);
	
}