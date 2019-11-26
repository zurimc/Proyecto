package com.lab.sdt.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.service.C_equiposSOAP;
import com.lab.sdt.service.ConsultaSOAP;
import com.lab.sdt.service.PacienteSOAP;
import com.lab.sdt.dto.ConsultaDTO;
import com.lab.sdt.dto.EquipoDTO;
import com.lab.sdt.dto.PacienteDTO;

@Service
public class ConsultaWSImpl implements ConsultaWS{
	
	@Autowired
	private ConsultaSOAP consultasoap;
	
	@Autowired
	private C_equiposSOAP c_equiposSOAP;
	
	@Autowired
	private PacienteSOAP pacienteSOAP;
	
	@Override
	public RespuestaDTO tipos_usuarios(ConsultaDTO consulta) {
		
		return consultasoap.consulta_usuario(consulta);
	}
	
	@Override
	public RespuestaDTO tipos_equipos(EquipoDTO equipoD) {
		
		return c_equiposSOAP.consulta_equipos(equipoD);
	}
	
	@Override
	public RespuestaDTO tipos_paciente(PacienteDTO pacienteD) {
		
		return pacienteSOAP.consulta_paciente(pacienteD);
	}

}
