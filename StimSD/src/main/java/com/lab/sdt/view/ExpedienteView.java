package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import java.util.List;

import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.service.EstimuladorService;
import com.lab.sdt.service.ExpedienteService;
import com.lab.sdt.service.HospitalService;
import com.lab.sdt.util.MensajeG;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.Hospital;



@ManagedBean
@ViewScoped
public class ExpedienteView implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{expedienteService}")
	public ExpedienteService expedienteService;
	@ManagedProperty("#{hospitalService}")
	public HospitalService hospitalService;
	@ManagedProperty("#{consultaUsuarios}")
	private ConsultaUsuarios consultaUsuarios;
	@ManagedProperty("#{estimuladorService}")
	public EstimuladorService estimuladorService;
	
	
	public String noExpediente;
	public String expediente;
	public int idUsuario;
	public int idHospital;
	public String descripcion;
	public int idEquipo;
	public char estatus;
	public int idMedico;
	public String nombre;
	public String buscarexp;
	public String hospital;
	public String equipo;
	
	private int tipos_vistas;
	public String hospital_b;
	public String equipo_b;
	public List<SelectItem> tipoUsuarios;
	public List<SelectItem> hospitales1;
	private Expediente seleccion_exp;
	private Expediente seleccion_pa;
	
	private List<Expediente> expedientes;
	private List<Expediente> pacientes;
	private List<Hospital> hospitales;
	private List<Equipo> equipos;
	private Hospital seleccion_hosp;
	private Equipo seleccion_equipo;
	
	@PostConstruct
	public void init() {
		
		hospitales = new ArrayList<Hospital>();
		hospitales = hospitalService.lista_hospital();
		hospitales1 = new ArrayList<SelectItem>();
		tipoUsuarios = new ArrayList<SelectItem>();
		seleccion_hosp = new Hospital();
		seleccion_equipo = new Equipo();
		try {
			hospitales1 = hospitalService.getLista_hospital();
			tipoUsuarios = consultaUsuarios.lista_tipousuarios();
		}
		catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
	}
	
	//registro de expediente
	
	public void registroExpediente() {
		Expediente expediente1 = new Expediente();
		expediente1.setNoexpediente("hj");
		expediente1.setIdusuario(1);
		expediente1.setIdhospital(1);
		expediente1.setDescripcion("jdje");
		expediente1.setIdequipo(1);
		expediente1.setEstatus("d");
		expediente1.setIdmedico(1);
		expediente1.setNombre("ser");
	
		
	}
	
	//carga lista para el ajax
	public void carga_lis_expe() {
		
		expedientes = new ArrayList<Expediente>();
		expedientes.clear();
		try {
			
			expedientes = expedienteService.lista_exp();
		}catch(Exception e) {
			
		}
				
	}
	//cargar expediente
	public void cargar_exp() {
		expedientes = new ArrayList<Expediente>();
		expedientes = expedienteService.lista_exp();
		
		seleccion_exp = new Expediente();
		seleccion_exp.setNoexpediente("");;
	}
	public void cargar_hos() {
		hospitales = new ArrayList<Hospital>();
		hospitales = hospitalService.lista_hospital();
		
		seleccion_hosp = new Hospital();
		seleccion_hosp.setHospital("");
	}
	public void cargar_equipo() {
		equipos = new ArrayList<Equipo>();
		equipos = estimuladorService.lista_equipos();
		
		seleccion_equipo = new Equipo();
		seleccion_equipo.setNoserie("");
	}
	//CAMBIAR VISTAS
    public void vista_expediente() {
          expedientes = new ArrayList<Expediente>();
          expedientes = expedienteService.lista_exp();
          tipos_vistas =  1;
     }
     public void vista_exregistro() {
    	 expedientes = new ArrayList<Expediente>();
    	 expedientes = expedienteService.lista_exp();
          tipos_vistas =  2;
     }
	//cargar pacientes
	/*public void cargar_pacientes() {
		pacientes = new ArrayList<Expediente>();
		pacientes = expedienteService.lista_pacientes();
		
		seleccion_pa = new Expediente();
		seleccion_pa.idUsuario("");
	}*/
	
	//buscar expediente
	public void buscar_expediente() {
		if(buscarexp.trim().length() > 0) {
			try {
				Expediente ex = new Expediente();
				expedientes.clear();
				ex = expedienteService.encuentra_expediente(buscarexp);
				if(ex!=null) {
					expedientes.add(ex);
				}
			}catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			}
		}
		else {
			MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		}
	}
	public void buscar_hospitales() {
		 if(hospital_b.trim().length() > 0) {
			 try {
				 Hospital ho = new Hospital();
				
				 hospitales.clear();
				 
					 ho =  hospitalService.encuentra_hospital(hospital_b);
					 if(ho!=null) {
						 
						 hospitales.add(ho);
					 
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		 }else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
		
		
	}
	public void buscar_equipos() {
		 if(equipo_b.trim().length() > 0) {
			 try {
				 Equipo eq = new Equipo();
				
				 equipos.clear();
				 
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 eq =  estimuladorService.encuentra_serie(equipo_b+";"+jjf);
					 if(eq!=null) {
						 
						 equipos.add(eq);
					 
				 }
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		 }else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
		
		
	}
	//Guardar datos de cada campo
	public void guarda_expe() {
		setNoExpediente(getNoExpediente());
		setIdUsuario(getIdUsuario());
		setIdHospital(getIdHospital());
		setDescripcion(getDescripcion());
		setIdEquipo(getIdEquipo());
		setIdMedico(getIdMedico());
		setNombre(getNombre());
	}
	
	//ACTUALIZAR EXPEDIENTE

	public String getNoExpediente() {
		return noExpediente;
	}
	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public char getEstatus() {
		return estatus;
	}
	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ExpedienteService getExpedienteService() {
		return expedienteService;
	}

	public void setExpedienteService(ExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}

	public Expediente getSeleccion_exp() {
		return seleccion_exp;
	}

	public void setSeleccion_exp(Expediente seleccion_exp) {
		this.seleccion_exp = seleccion_exp;
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public String getBuscarexp() {
		return buscarexp;
	}

	public void setBuscarexp(String buscarexp) {
		this.buscarexp = buscarexp;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public Expediente getSeleccion_pa() {
		return seleccion_pa;
	}

	public void setSeleccion_pa(Expediente seleccion_pa) {
		this.seleccion_pa = seleccion_pa;
	}

	public List<Expediente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Expediente> pacientes) {
		this.pacientes = pacientes;
	}

	public int getTipos_vistas() {
		return tipos_vistas;
	}

	public void setTipos_vistas(int tipos_vistas) {
		this.tipos_vistas = tipos_vistas;
	}

	public HospitalService getHospitalService() {
		return hospitalService;
	}

	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}

	public List<SelectItem> getHospitales1() {
		return hospitales1;
	}

	public void setHospitales1(List<SelectItem> hospitales1) {
		this.hospitales1 = hospitales1;
	}

	public ConsultaUsuarios getConsultaUsuarios() {
		return consultaUsuarios;
	}

	public void setConsultaUsuarios(ConsultaUsuarios consultaUsuarios) {
		this.consultaUsuarios = consultaUsuarios;
	}

	public List<SelectItem> getTipoUsuarios() {
		return tipoUsuarios;
	}

	public void setTipoUsuarios(List<SelectItem> tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}

	public Hospital getSeleccion_hosp() {
		return seleccion_hosp;
	}

	public void setSeleccion_hosp(Hospital seleccion_hosp) {
		this.seleccion_hosp = seleccion_hosp;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getHospital_b() {
		return hospital_b;
	}

	public void setHospital_b(String hospital_b) {
		this.hospital_b = hospital_b;
	}

	public EstimuladorService getEstimuladorService() {
		return estimuladorService;
	}

	public void setEstimuladorService(EstimuladorService estimuladorService) {
		this.estimuladorService = estimuladorService;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo getSeleccion_equipo() {
		return seleccion_equipo;
	}

	public void setSeleccion_equipo(Equipo seleccion_equipo) {
		this.seleccion_equipo = seleccion_equipo;
	}

	public String getEquipo_b() {
		return equipo_b;
	}

	public void setEquipo_b(String equipo_b) {
		this.equipo_b = equipo_b;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
		

}
