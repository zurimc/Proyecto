package com.lab.sdt.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.dto.ConsultaDTO;
import com.lab.sdt.dto.EquipoDTO;
import com.lab.sdt.dto.PacienteDTO;
@WebService
public interface ConsultaWS {

	@WebResult(name="respuesta")
	RespuestaDTO tipos_usuarios(@WebParam(name="consultasoap")ConsultaDTO consulta);
	
	@WebResult(name="respuesta")
	RespuestaDTO tipos_equipos(@WebParam(name="equiposoap")EquipoDTO equipoD);
	
	@WebResult(name="respuesta")
	RespuestaDTO tipos_paciente(@WebParam(name="pacientesoap")PacienteDTO pacienteD);
}