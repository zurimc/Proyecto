package com.lab.sdt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EquipoMapper;
import com.lab.sdt.dao.ExpeEstimMapper;
import com.lab.sdt.dao.ExpedienteMapper;
import com.lab.sdt.dao.NumOndaMapper;
import com.lab.sdt.dao.OndaValorMapper;
import com.lab.sdt.dao.ParametroMapper;
import com.lab.sdt.dao.UbicacionMapper;
import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.dao.ValorMapper;
import com.lab.sdt.dto.PacienteDTO;
import com.lab.sdt.dto.RespuestaDTO;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.ExpeEstim;
import com.lab.sdt.model.ExpeEstimExample;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.NumOnda;
import com.lab.sdt.model.OndaValor;
import com.lab.sdt.model.Parametro;
import com.lab.sdt.model.Ubicacion;
import com.lab.sdt.model.UbicacionExample;
import com.lab.sdt.model.Usuario;

@Service
@Transactional
public class PacienteSOAP {

	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	@Autowired
	private EquipoMapper equipoMapper;
	
	@Autowired
	private ParametroMapper parametroMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
	@Autowired
	private OndaValorMapper ondaValorMapper;
	
	@Autowired
	private ValorMapper valorMapper;
	
	@Autowired
	private UbicacionMapper ubicacionMapper;
	
	@Autowired
	private ExpeEstimMapper expeEstimMapper;
	
	public RespuestaDTO consulta_paciente(PacienteDTO pacienteD) {
		RespuestaDTO respuesta = new RespuestaDTO();
		respuesta = consulta(pacienteD);
		return respuesta;
	}
	public RespuestaDTO consulta(PacienteDTO pacienteD) {
		RespuestaDTO res = new RespuestaDTO();
		res.setAutorizacion(false);
		//res.setMensaje("Sin autorización");
		res.setTipo_usuario(0);
		if(!validarpaciente(pacienteD, res)){
			return res;
		}
		try {
			if(pacienteD.getEstatus() == 1) // quiere iniciar estimulacion  
			{
				Usuario paciente = encuentra_cuenta(pacienteD.getCuenta());
				Expediente expediente_p = new Expediente();
				expediente_p = expediente_paciente(paciente.getIdusuario());
				if(expediente_p.getEstatus().equals("true")) {
					
					Equipo estimulador = encuentra_por_id_equipo(expediente_p.getIdequipo());
					Parametro parametros = parametroporkey(expediente_p.getIdparametroexp());
					NumOnda nombre_onda = numonda_paquete(parametros.getIdonda());
					Ubicacion ubica = new Ubicacion();
					ExpeEstim expeestims = new ExpeEstim();
					int id_u = 0, id_u_ex =0;

					
					int id_expe_estim_ubi = Integer.parseInt(pacienteD.getOndap2());
					
					if(id_expe_estim_ubi<=0) {
						ubica = empaquetaUbicacion(pacienteD);
						ubica.setOndaP2(parametros.getIdonda()+"");
						ubica.setEstatus("false");
						id_u = guarda_ubicacion (ubica);
						expeestims.setFechaestimulacion(new Date());
						expeestims.setIdexpediente(expediente_p.getIdexpediente());
						expeestims.setIdestimulacion(id_u);
						id_u_ex = guarda_uexpe_estim(expeestims);
					}else {
						expeestims = muestraExpeEstim(id_expe_estim_ubi);
						id_u_ex = expeestims.getIdexestim();
						
						
						ubica = muestraUbicacion(expeestims.getIdestimulacion());
						id_u = ubica.getIdestimulacion();
						
						ubica = empaquetaUbicacion(pacienteD);
						ubica.setOndaP2(parametros.getIdonda()+"");
						ubica.setEstatus("false");
						ubica.setIdestimulacion(id_u);
						actualizaUbicacion(ubica);
						
						
						expeestims.setFechaestimulacion(new Date());
						expeestims.setIdexestim(id_u_ex);
						actualizaExpeEstim(expeestims);
					}

					
					String onda = carga_valores1(parametros.getIdonda());
					String parametro = id_u_ex+";"+parametros.getAmplitud()+";"+parametros.getFrecuencia()+";"+parametros.getTiempo()
					+";"+estimulador.getNoserie()+";"+estimulador.getDetalles();
					
					res.setParametros(parametro);
					res.setOndas(onda);
					res.setTipo_usuario(Integer.parseInt(estimulador.getTipo()));
					res.setAutorizacion(true);
					res.setMensaje("La estimulación empezará en breve "+id_u_ex);
					

				}else {
					res.setAutorizacion(false);
					res.setMensaje("Expediente no activado");
				}
				
			}
		}catch(Exception e) {
			res.setMensaje("Ocurrio una excepcion: "+e.getMessage());
		}
		return res;
	}
	private Ubicacion empaquetaUbicacion(PacienteDTO pacienteD) {
		Ubicacion restul = new Ubicacion();
		restul.setLatitud(pacienteD.getLatitud());
		restul.setLonguitud(pacienteD.getLongitud());
		restul.setAmplitud(pacienteD.getAmplitud());
		restul.setFrecuencia(pacienteD.getFrecuencia());
		restul.setTiempo(pacienteD.getTiempo());
		restul.setOndaP1(pacienteD.getOndap1());
		
		return restul;
	}
    private String carga_valores1(int idOnda) {
   	 double[] val = valores_onda(idOnda);
   	 String onda = "";
   	 for(int ii =0; ii<= val.length-1; ii++) {
   		onda = onda + String.valueOf(val[ii])+":";
   	 }
   	 return onda;
    }
    private double[] valores_onda(int idOnda) {
		double[] resint = new double[270];
		String res = "";
		try {
			List<OndaValor> ondvalor =ondaValorMapper.selectByidOnda(idOnda);
			for(int ii =0; ii<= ondvalor.size()-1; ii++) {
				res = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				resint[ii] = Double.parseDouble(res);
				//valores[ii] = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				//res = res + valores[ii]+":";
			}
		}catch(Exception e) {}
		return resint;
	}

    private int guarda_ubicacion (Ubicacion ubi) {
    	ubicacionMapper.insert(ubi);
    	UbicacionExample ubiex = new UbicacionExample();
    	List<Ubicacion> listubi = ubicacionMapper.selectByExample(ubiex);
    	return listubi.get(listubi.size()-1).getIdestimulacion();
    }
    private Ubicacion muestraUbicacion(int idkey) {
    	return ubicacionMapper.selectByPrimaryKey(idkey);
    }
    private void actualizaUbicacion(Ubicacion idkey) {
    	ubicacionMapper.updateByPrimaryKey(idkey);
    }
    private int guarda_uexpe_estim (ExpeEstim expeestim) {
    	expeEstimMapper.insert(expeestim);
    	ExpeEstimExample exeex = new ExpeEstimExample();
    	List<ExpeEstim> listexets = expeEstimMapper.selectByExample(exeex);
    	return listexets.get(listexets.size()-1).getIdexestim(); 
    }
    private ExpeEstim muestraExpeEstim (int idkey) {
    	return expeEstimMapper.selectByPrimaryKey(idkey);
    }
    private void actualizaExpeEstim (ExpeEstim idkey)
    {
    	expeEstimMapper.updateByPrimaryKey(idkey);
    }
    private NumOnda numonda_paquete(int idonda) {
		return numOndaMapper.selectByidOnda(idonda).get(0);
	}
    private Parametro parametroporkey(int idparametro) {
		return parametroMapper.selectByPrimaryKey(idparametro);
	}
    private Usuario encuentra_cuenta(String cuenta) {
		Usuario usera = new Usuario();
		
		usera = usuarioMapper.selectByCuenta(cuenta).get(0);
		return usera;
	}
	
    private Equipo encuentra_por_id_equipo(int idkey) {
		return equipoMapper.selectByPrimaryKey(idkey);
	}
    private Expediente expediente_paciente(Integer idusuario) {
		Expediente expp = new Expediente();
		expp.setEstatus("false");
		List<Expediente> epps = muestra_expedietes(idusuario);
		for(int ii =0;ii<=epps.size()-1;ii++) {
			try {
				 if(epps.get(ii).getEstatus().equals("true")) {
					expp = epps.get(ii);
				}
			}catch(Exception e) {}
			
		}
		return expp;
	}
    private List<Expediente> muestra_expedietes(Integer idusuario) {
		return expedienteMapper.selectByidUsuario(idusuario);
	}
	private boolean validarpaciente(PacienteDTO pacienteD,RespuestaDTO respuesta) {
		if(pacienteD.getAmplitud()== null) {
			respuesta.setMensaje("Sin amplitud");
			return false;
		}
		if(pacienteD.getCuenta()==null ) {
			respuesta.setMensaje("sin cuenta");
			return false;
		}
		if(pacienteD.getFrecuencia()==null ) {
			respuesta.setMensaje("sin frecuencia");
			return false;
		}if(pacienteD.getLatitud()==null ) {
			respuesta.setMensaje("sin latitud");
			return false;
		}if(pacienteD.getLongitud()==null ) {
			respuesta.setMensaje("sin longitud");
			return false;
		}if(pacienteD.getOndap1()==null || pacienteD.getOndap2()==null) {
			respuesta.setMensaje("sin Onda");
			return false;
		}if(pacienteD.getPeticion()==null ) {
			respuesta.setMensaje("sin petición");
			return false;
		}if(pacienteD.getTiempo()==null ) {
			respuesta.setMensaje("sin tiempo");
			return false;
		}
		return true;
		
	}
}
