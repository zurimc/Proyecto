package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.ExpeEstim;
import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteConsulta;
import com.lab.sdt.model.Hospital;
import com.lab.sdt.model.Parametro;
import com.lab.sdt.model.Presionintraocular;
import com.lab.sdt.model.Ubicacion;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.service.ConsultaOnda;
import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.service.EstadoUnidad;
import com.lab.sdt.service.EstimuladorService;
import com.lab.sdt.service.HospitalService;
import com.lab.sdt.service.U_pacientesService;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class PacienteView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int tipos_vistas;
	
	private String pnombrev;
	
	private String pfoliov;
	
	private String pnombrev1;
	
	private String pfoliov1;
	
	private String pbnombrepacientev;
	
	private String pbnombremedicov;
	
	private String pbnombrehospitalv;
	
	private String pbnombreequipov;
	
	private String pnombrepacientev;
	
	private String pnombrehospitalv;
	
	private String pnombremedicov;
	
	private String pnombrequipov;
	
	private String pnombreenfermedadav;
	
	private String pdescripcionv;
	
	private boolean exestatus;
	
	private int tipopaciente = 4;
	
	private int tipomedico = 2;
	
	private int tipo_usr = 0;
	
	private int idpaciente;
	
	private int pdosisexp;
	
	private String pbotoncrearv;
	
	@ManagedProperty("#{consultaUsuarios}")
	private ConsultaUsuarios consultaUsuarios;
	
	private List<Usuario> cuentas;

	private List<Usuario> pacientes;
	
	private List<Usuario> medicos;
	
	private Usuario seleccion_paciente;
	
	private Usuario seleccion_medico;
	
	private Usuario seleccion_user;
	
	protected List<Double> valores_g_p;
	 
	private double pafrecueciaj_p;

    private double paamplitudj_p = 5;
    
    private double patiempoj_p;

	private  double[] valores;
	
	private  double[] valores_paciente;
	
	@ManagedProperty("#{hospitalService}")
	public HospitalService hospitalService;
	
	public List<Hospital> hospitales;
	
	public Hospital seleccion_hospital;
	
	@ManagedProperty("#{estimuladorService}")
	public EstimuladorService estimuladorService;
	
	private List<Equipo> estimuladores;
	
	private Equipo selecion_estimulador;
	
	@ManagedProperty("#{u_pacientesService}")
	public U_pacientesService u_pacientesService;
	
	private List<Enfermedad> enfermedades;

	private Enfermedad seleccion_enfermedad;
	
	public List<SelectItem> enfermedadesitem;
	
	Expediente expediente_g;
	
	private List<Expediente> expedientes;

	private Expediente seleccion_expediente;
	
	private int idpacienteex = 0;
	
	private int idenfermedadex = 0;
	
	private int idmedicoex = 0;
	
	private int idhospitalex = 0;
	
	private int idequipoex = 0;
	
	private int idparametroex = 0;
	
	@ManagedProperty("#{estadoUnidad}")
	public EstadoUnidad estadoUnidad;
	
	@ManagedProperty("#{consultaOnda}")
	private ConsultaOnda consultaOnda;

	private List<Parametro> parametros_list;
	
	private Parametro seleccion_parametro;
	
	private String buscar_parametrosstring;

	private String parametrosstring;
	
	private List<ExpeEstim> expeestimes;
	
	private ExpeEstim seleccion_expeestim;

    private String exlat;
    
    private String exlog;

    private String nombre_onda;
    
    private String nombre_onda_ubica;

	 private LineChartModel lineModel1;
	 
	 private LineChartModel zoomModel;
	   
	 private String estimulos_empreados;
	 
	 private int dosis_anterior = 0;
	 private boolean termino_dosis =  false;
		/*zuri*/
		private String sexo;
		/*zuri*/
		private String edad;
		/*zuri*/
		
	     public int idExpediente;
	     private int idExpeConsul;
	     public String peso;
	     public String p_mayor;
	     public String p_menor;
	     public String temperatura;
	     public String altura;
	     public String masa_corp;
	     public String grasa_corp;
	     public String descripcionedit;
	

		public String presionI;
	     public String presionD;
	     public Date fechapresion;
	     private Date fechaI;
	 	  private Date fechaF;
	     public Date fechaConsulta;
	     private String expe_m;
	     
	     private List<Expediente> exp_id;
	     private List<ExpedienteConsulta> fecha_exp;
	     private ExpedienteConsulta seleccion_consulta;

	     private int idexp=0;
	     private int idexpedienteC;
	     private ExpedienteConsulta exp_Consul;
	     private Presionintraocular presionintraocular;
	     private boolean hay_presionintraocular = false;
	     private boolean hay_peso = false;
	     private boolean hay_pa = false;
	     private boolean hay_altura = false;
	     private boolean hay_temp= false;
	     private boolean hay_masa= false;
	     private boolean hay_grasa = false;
		private int presionMuestra = 0;
	     private int id_consultaM = 0;
	

	
	@PostConstruct
	public void init(){
		valores = new double[300];
		valores_paciente = new double[300];
		valores_g_p = new ArrayList<Double>();
		cuentas = new ArrayList<Usuario>();
		enfermedadesitem = new ArrayList<SelectItem>();
		expedientes = new ArrayList<Expediente>();
		seleccion_expediente = new Expediente();
		
		seleccion_paciente = new Usuario();
		seleccion_enfermedad =new Enfermedad();
		seleccion_medico = new Usuario();
		seleccion_hospital = new Hospital();
		selecion_estimulador = new Equipo();
		
		seleccion_expeestim = new ExpeEstim();
		

		tipos_vistas = 3;
		carga_user_todo();
		
		//carga_valores1(1) ;
		 //agrega_valores(5);
		//muestra_pacientes();
		createLineModels(5,"",1);
	}
	
///----------- zuri ----------------
	  
	   public void seleccionar_doctor() {
	    	 try {
	    		 exp_id.clear();
	    		exp_id = u_pacientesService.expediente_por_doc(seleccion_medico.getIdusuario());
	 		}catch(Exception e) {}
	     }
	     
	     public void buscar_fechas() {
	    	 //MensajeG.mostrar(":D", FacesMessage.SEVERITY_ERROR);
	    	 try {
	    		 fecha_exp.clear();
		    	fecha_exp = u_pacientesService.consulta_fechas(fechaI,fechaF, idexp);
	    		//MensajeG.mostrar("ok", FacesMessage.SEVERITY_INFO);
		    	// RequestContext.getCurrentInstance().execute("PF('m_consulta').hide();");
	    	 } catch(Exception e) {
	    		 MensajeG.mostrar("Error: "+e.toString(), FacesMessage.SEVERITY_ERROR);
	    	 }
	     }
	    

	      //asignacion de expediente
	         @SuppressWarnings("deprecation")
	         public void asignacion_expedienteC() {
	        	 tipos_vistas = 3;
	             idexp = seleccion_expediente.getIdexpediente();
	            // setIdexpedienteC((seleccion_expediente.getIdexpediente()));
	             asignacion_expediente(); 
	                 RequestContext.getCurrentInstance().execute("PF('patablaexpediente').hide();");

	         }
	         @SuppressWarnings("deprecation")
	         public void seleccionar_consulta() {
	        	 setPeso(seleccion_consulta.getPeso());
	        	 setP_mayor(seleccion_consulta.getpMayor());
	        	 setP_menor(seleccion_consulta.getpMenor());
	        	 setTemperatura(seleccion_consulta.getTemperatura());
	        	 setAltura(seleccion_consulta.getAltura());
	        	 setMasa_corp(seleccion_consulta.getMasaCorp());
	        	 setGrasa_corp(seleccion_consulta.getGrasaCorp());
	        	 setDescripcionedit(seleccion_consulta.getDescripcion());
	        	 id_consultaM = seleccion_consulta.getIdexpeconsul();
	        	 idexp = seleccion_consulta.getIdexpediente();
	        	if(id_consultaM>0) {
	        		 presionintraocular = new Presionintraocular();
	        		 presionintraocular=u_pacientesService.encuentrap(id_consultaM);
	        		 setPresionI(presionintraocular.getpIzq());
	        		 setPresionD(presionintraocular.getpDer());
	        		 if(presionintraocular.getId()>0) {
	        			 hay_presionintraocular = true; 
	        			 presionMuestra = presionintraocular.getId();
	        		 }
	        		 
	        		 
	        		// System.out.println(presionintraocular.getpIzq());
	        		// System.out.println(presionintraocular.getpDer());
	        	}
	        	 guarda_actualiza_datos();
	        	 RequestContext.getCurrentInstance().execute("PF('m_consulta').hide();");
	        	 System.out.println(id_consultaM);
	         }
	     	
	     	public void cargar_expedientesConsulta() {
	     		exp_id = new ArrayList<Expediente>();
	     		exp_id.clear();
	     		try {
	     			exp_id = u_pacientesService.entrega_expedientes();
	     		}catch(Exception e) {
	     			
	     		}
	     		
	     	}
	     	
	         /*insertar en la base y modificar*/
	     	 @SuppressWarnings("deprecation")
	     	public void modificar_consulta() {
	     		if(idexp>0) {
	     			//MensajeG.mostrar("ok", FacesMessage.SEVERITY_INFO);
	     			 RequestContext.getCurrentInstance().execute("PF('m_consulta').show();");
	     			
	     		}else {
	     			 MensajeG.mostrar("Debes seleccionar un expediente", FacesMessage.SEVERITY_ERROR);
	     		}
	     		
	     	}
	     	
	     	// @SuppressWarnings("deprecation")
	         public void crea_modi_consulta1() {
	     		if(idexp>0) {
	     			  try {
	 	     			exp_Consul = new ExpedienteConsulta();
	 	     			exp_Consul.setFechaconsulta(new Date());
	 	                exp_Consul.setDescripcion(getDescripcionedit());
	 	                exp_Consul.setPeso(getPeso());
	 	                exp_Consul.setpMayor(getP_mayor());
	 	                exp_Consul.setpMenor(getP_menor());
	 	                exp_Consul.setTemperatura(getTemperatura());
	 	                exp_Consul.setAltura(getAltura());
	 	                exp_Consul.setMasaCorp(getMasa_corp());
	 	                exp_Consul.setGrasaCorp(getGrasa_corp());
	 	                exp_Consul.setIdexpediente(idexp);
	 	                int id_con_ex =  0;
	 	               if(id_consultaM>0) {
	 	            	  id_con_ex = id_consultaM;
	 	            	  	exp_Consul.setIdexpeconsul(id_con_ex);
	 	            	 	u_pacientesService.modificarExpedienteConsulta(exp_Consul);
	 	            	 	try {
	 	            	 		if(hay_presionintraocular == true) {
	 	            	 			hay_presionintraocular = false;
	 	            	 			if(presionMuestra >0) {
	 	            	 				presionintraocular.setIdexpConsulta(id_con_ex);
	 	            	 				presionintraocular.setpIzq(presionI);
	 	            	 				presionintraocular.setpDer(presionD);
	 	            	 				presionintraocular.setFecha(new Date());
	 	            	 				presionintraocular.setId(presionMuestra);
	 	            	 				u_pacientesService.modificarPresion(presionintraocular);
	 	            	 			}else {
	 			 	                	presionintraocular.setIdexpConsulta(id_con_ex);
	 			 	                	u_pacientesService.insertarPresion(presionintraocular);
	 	            	 			}
	 	            	 		}
	 	            	 		
	 	            	 	}catch(Exception e) {
	 	            	 		
	 	            	 	}
	 	            	 
	 	            	 	 MensajeG.mostrar("Consulta modificada ", FacesMessage.SEVERITY_INFO);
	 	               }else {
	 	            	  id_con_ex =  (int)u_pacientesService.insertarConsulta(exp_Consul);
	 	            	 if(hay_presionintraocular == true) {
		 	                	hay_presionintraocular = false;
		 	                	presionintraocular.setIdexpConsulta(id_con_ex);
		 	                	u_pacientesService.insertarPresion(presionintraocular);
		 	                }
		 	                  MensajeG.mostrar("Consulta registrada ", FacesMessage.SEVERITY_INFO);
	 	               }
	 	             // System.out.println(id_consultaM);
	 	             }catch(Exception e) {
	 	                  MensajeG.mostrar("Error: "+e.toString(), FacesMessage.SEVERITY_ERROR);
	 	             }
	     		}else {
	     			 MensajeG.mostrar("Debes seleccionar un expediente", FacesMessage.SEVERITY_ERROR);
	     		}
	     	

	     		 // RequestContext.getCurrentInstance().execute("PF('patablaexpediente').hide();");
	     	 }   
	   public void registroPresionO() {
	       presionintraocular = new Presionintraocular();
	       presionintraocular.setpIzq(presionI);
	       presionintraocular.setpDer(presionD);
	       presionintraocular.setFecha(new Date());
	       hay_presionintraocular = true;
	       
	   }
	     
	   public void guarda_actualiza_datos() {
	  setPeso(getPeso());
	  try {
		  double peso_d = Double.parseDouble(getPeso()); 
		  if(peso_d>0) {
			  hay_peso = true;
		  }else {
			  hay_peso = false;
		  }
	  }catch(Exception e) {
		  hay_peso = false;
	  }
	  setP_mayor(getP_mayor());
	  try {
		  double p_mayord = Double.parseDouble(getP_mayor());
		  if(p_mayord>0) {
			  hay_pa = true;
		  }else {
			  hay_pa = false;
		  }
	  }catch(Exception e) {
		  hay_pa = false;
	  }
	  setP_menor(getP_menor());
	  try {
		  double p_menord = Double.parseDouble(getP_mayor());
		  if(p_menord>0) {
			  hay_pa = true;
		  }else {
			  hay_pa = false;
		  }
	  }catch(Exception e) {
		  hay_pa = false;
	  }
	  setTemperatura(getTemperatura());
	  try {
		  double temperaturad = Double.parseDouble(getTemperatura());
		  if(temperaturad>0) {
			  hay_temp = true;
		  }else {
			  hay_temp = false;
		  }
	  }catch(Exception e) {
		  hay_temp = false;
	  }
	  setAltura(getAltura());
	  try {
		  double alturad = Double.parseDouble(getAltura());
		  if(alturad>0) {
			  hay_altura = true;
		  }else {
			  hay_altura = false;
		  }
	  }catch(Exception e) {
		  hay_altura = false;
	  }
	  setMasa_corp(getMasa_corp());
	  try {
		  double masad = Double.parseDouble(getMasa_corp());
		  if(masad>0) {
			  hay_masa = true;
		  }else {
			  hay_masa = false;
		  }
	  }catch(Exception e) {
		  hay_masa = false;
	  }
	  setGrasa_corp(getGrasa_corp());
	  try {
		  double grasad = Double.parseDouble(getGrasa_corp());
		  if(grasad>0) {
			  hay_grasa = true;
		  }else {
			  hay_grasa = false;
		  }
	  }catch(Exception e) {
		  hay_grasa = false;
	  }
	  setDescripcionedit(getDescripcionedit());
	  setFechaConsulta(new Date());
	   }

///----------- zuri ----------------
public String conviertetipouser(String partes) {
	String regresa_tipo = "";
	estimulos_empreados = "";
	try {
		String[] partes_serie =partes.split(";");
		regresa_tipo = partes_serie[0];
		estimulos_empreados = partes_serie[1];
	}catch(Exception e){}
	
	return regresa_tipo;
}
	public void carga_user_todo() {
		cargar_tipos_user(tipopaciente);
		pacientes = cuentas;
		cargar_tipos_user(tipomedico);
		medicos = cuentas;
		cargar_hospital();
		cargar_equipos();
		cargar_enfermedad(); 
		//cargar_parametros();
		//cargar_expedientes();
		/*zuri inicio */
		tipos_vistas = 3;
		 fecha_exp = new ArrayList<ExpedienteConsulta>();
		cargar_expedientesConsulta();
		/*zuri final*/
	}
	public void cargar_enfermedad() {
		enfermedades = u_pacientesService.lista_enfermedad();
		try {
			enfermedadesitem = estadoUnidad.getLista_enfermedades();
		}catch(Exception e) {}
	}
	public void cargar_expedientes() {
		 u_pacientesService.todosExpedientes();
	}
	public void cargar_hospital() {
		hospitales = new ArrayList<Hospital>();
		hospitales.clear();
		try {
			hospitales = hospitalService.entrega_hospitales();			
		}catch(Exception e) {

		}
	}
	public void cargar_parametros() {
		parametros_list = new ArrayList<Parametro>();
		parametros_list.clear();
		try {
			parametros_list = consultaOnda.todos_parametros();
		}catch(Exception e) {

		}
	}
	public void cargar_parametros_e() {
		parametros_list = new ArrayList<Parametro>();
		parametros_list.clear();
		try {
			parametros_list = consultaOnda.parametros_equipo(idequipoex);
		}catch(Exception e) {

		}
	}
	public void cargar_equipos() {
		estimuladores = new ArrayList<Equipo>();
		estimuladores.clear();
		try {
			estimuladores = estimuladorService.lista_equipos();		
		}catch(Exception e) {

		}
	}
	public void cargar_tipos_user(int tipo) {
		tipo_usr = tipo;
		cuentas = new ArrayList<Usuario>();
		cuentas.clear();
		//seleccion_user.setCuenta("");
		try {
			cuentas = consultaUsuarios.lista_tipo_cuenta(tipo);
			
		}catch(Exception e) {

		}
	}
	public void muestra_pacientes() {
		cargar_tipos_user(tipopaciente);
		pacientes = cuentas;
	}
	public void muestra_medicos() {
		cargar_tipos_user(tipomedico);
		medicos = cuentas;
	}
	public void pdatosv() {
		setPnombrev(getPnombrev());
		setPfoliov(getPfoliov());
		setExestatus(isExestatus());
		setPdosisexp(getPdosisexp());
		setSexo(getSexo());
		setEdad(getEdad());
		
	}
	public void selecion_de_paciente() {
		try {
			expedientes.clear();
			expedientes = u_pacientesService.muestra_expedietes(seleccion_paciente.getIdusuario());
			setIdpaciente(0);
		}catch(Exception e) {}
		
	}
	public void desactivar_exs_porusurio(int idpaceinte){
		try {
        List<Expediente> exs  = new ArrayList<Expediente>(); 
        exs = u_pacientesService.muestra_expedietes(idpaceinte);
        Expediente exp = new Expediente();
         for(int ii=0;ii<=exs.size()-1;ii++) {
        	 exs.get(0).setEstatus("false");
        	 exp = exs.get(0);
        	 u_pacientesService.modificaExpediente(exp);
         }
		}catch(Exception e) {}
		
	}
	public void tipo_enfermedad_paciente() {
		try {
			expedientes.clear();
			List<Expediente> listex = u_pacientesService.muestra_expedietes(seleccion_paciente.getIdusuario());
			 for(int i = 0;i<=listex.size()-1;i++) {
				 if(listex.get(i).getIdenfermedad().equals(idpaciente)) {
					 expedientes.add(listex.get(i));
				 }
			 }
		}catch(Exception e) {}
	}
	@SuppressWarnings("deprecation")
	public void asignacion_parametros() {
		idparametroex = seleccion_parametro.getIdparametro();
		setParametrosstring(seleccion_parametro.getNombre());
		RequestContext.getCurrentInstance().execute("PF('ptablaequipo').hide();");
	}
	@SuppressWarnings("deprecation")
	public void asignacion_paciente() {
		idpacienteex = seleccion_paciente.getIdusuario();
			setPnombrepacientev(seleccion_paciente.getNombre()+" "+seleccion_paciente.getApellido1()+" "+seleccion_paciente.getApellido2());
			RequestContext.getCurrentInstance().execute("PF('ptablapaciente').hide();");
	}
	@SuppressWarnings("deprecation")
	public void asignacion_medico() {
		idmedicoex = seleccion_medico.getIdusuario();
			setPnombremedicov(seleccion_medico.getNombre()+" "+seleccion_medico.getApellido1()+" "+seleccion_medico.getApellido2());
			RequestContext.getCurrentInstance().execute("PF('ptablamedico').hide();");

	}
	@SuppressWarnings("deprecation")
	public void asignacion_hospital() {
		idhospitalex = seleccion_hospital.getIdhospital();
			setPnombrehospitalv(seleccion_hospital.getHospital()+"  C.P: "+seleccion_hospital.getCodigopostal());
			RequestContext.getCurrentInstance().execute("PF('ptablahospital').hide();");

	}

	public void asignacion_equipo() {
		idequipoex = selecion_estimulador.getIdequipo();
		cargar_parametros_e();
			setPnombrequipov(convertirserie(selecion_estimulador.getNoserie())+"  "+convertirgeneracion(selecion_estimulador.getNoserie()));
			

	}
	@SuppressWarnings("deprecation")
	public void asignacion_enfermedad() {
		idenfermedadex = seleccion_enfermedad.getIdenfermedad();
		setPnombreenfermedadav(seleccion_enfermedad.getEnfermedad());
			RequestContext.getCurrentInstance().execute("PF('ptableenfermedad').hide();");

	}
	public void asignar_ubicacion() {
		Ubicacion  ubicaex = new Ubicacion(); 
		ubicaex = u_pacientesService.ubica(seleccion_expeestim.getIdestimulacion());
		setExlat(ubicaex.getLatitud());
		setExlog(ubicaex.getLonguitud());
		setPafrecueciaj_p(Double.parseDouble(ubicaex.getFrecuencia()));
		setPatiempoj_p(Double.parseDouble(ubicaex.getTiempo()));
		setPaamplitudj_p(Double.parseDouble(ubicaex.getAmplitud()));
		conviertetipouser(seleccion_expeestim.getClinica());
		
		try {	
			int tipo_Es = 1;
			String serie_ubica =  estimuladorService.encuentra_por_id(idequipoex).getNoserie();
			String[] gene_tipo = serie_ubica.split(";");
			tipo_Es = Integer.parseInt(gene_tipo[1]);
			createLineModels(Double.parseDouble(ubicaex.getAmplitud()),ubicaex.getOndaP1(),tipo_Es);
			setNombre_onda_ubica(u_pacientesService.regresa_onda_nombre(Integer.parseInt(ubicaex.getOndaP2())).getNombre());
		}catch(Exception e) {}
		
	}
	public void asignacion_expediente() {
		try {

			seleccion_paciente = consultaUsuarios.encontra_porid(seleccion_expediente.getIdusuario());
			idpacienteex = seleccion_paciente.getIdusuario();
			sexo = seleccion_paciente.getSexo();
			edad = seleccion_paciente.getEdad();
			seleccion_enfermedad = u_pacientesService.encuentra_por_id(seleccion_expediente.getIdenfermedad());
			idenfermedadex = seleccion_enfermedad.getIdenfermedad();
			seleccion_medico = consultaUsuarios.encontra_porid(seleccion_expediente.getIdmedico());
			 idmedicoex= seleccion_medico.getIdusuario();
			seleccion_hospital = hospitalService.encuentra_por_id(seleccion_expediente.getIdhospital());
			idhospitalex = seleccion_hospital.getIdhospital();
			selecion_estimulador = estimuladorService.encuentra_por_id(seleccion_expediente.getIdequipo());
            idequipoex = selecion_estimulador.getIdequipo();
			
            seleccion_parametro = consultaOnda.parametroporkey(seleccion_expediente.getIdparametroexp());
            
			idparametroex = seleccion_parametro.getIdparametro();
			try {
				carga_valores1(seleccion_parametro.getIdonda()) ;
				setNombre_onda(seleccion_parametro.getNombre());
				 agrega_valores(Double.parseDouble(seleccion_parametro.getAmplitud()));
				 createLineModels(Double.parseDouble(seleccion_parametro.getAmplitud()),"",1);
			}catch(Exception e) {MensajeG.mostrar("Error al cargar expediente: "+e.toString(), FacesMessage.SEVERITY_ERROR);}
			
			try {
				expeestimes = u_pacientesService.lista_historico_expediente(seleccion_expediente.getIdexpediente());
				
			}catch(Exception e) {}
			
			
			setPdescripcionv(seleccion_expediente.getDescripcion());
			setPnombrequipov(convertirserie(selecion_estimulador.getNoserie())+"  "+convertirgeneracion(selecion_estimulador.getNoserie()));
			setPnombrehospitalv(seleccion_hospital.getHospital()+"  C.P: "+seleccion_hospital.getCodigopostal());
			setPnombremedicov(seleccion_medico.getNombre()+" "+seleccion_medico.getApellido1()+" "+seleccion_medico.getApellido2());
			setPnombrepacientev(seleccion_paciente.getNombre()+" "+seleccion_paciente.getApellido1()+" "+seleccion_paciente.getApellido2());
			setPnombreenfermedadav(seleccion_enfermedad.getEnfermedad());

			setPfoliov1(seleccion_expediente.getNoexpediente());
			setPnombrev1(seleccion_expediente.getNombre());
			
			
			setParametrosstring(seleccion_parametro.getNombre());
			try {
				setPdosisexp(seleccion_expediente.getDosis());
				dosis_anterior = seleccion_expediente.getDosis();
			}catch(Exception e) {setPdosisexp(0);}
			
			
			
			if(seleccion_expediente.getEstatus().equals("true")) {setExestatus(true);}else {setExestatus(false);}
			
		}catch(Exception e) {
			MensajeG.mostrar("Error al cargar expediente: "+e.toString(), FacesMessage.SEVERITY_ERROR);
		}
		//if(seleccion_expediente != null) {

			
		//}
		
		//RequestContext.getCurrentInstance().execute("PF('pexpedientemodi').hide();");

	}
	public void vista_modifica_expedeinte() {
		if(seleccion_expediente != null) {
			tipos_vistas = 2;
			asignacion_expediente();
			setPbotoncrearv("Modifica");	
		}else {
			MensajeG.mostrar("Selecciones un expediente", FacesMessage.SEVERITY_WARN);
		}
	}
	public void vista_ver_expedeinte() {
		if(seleccion_expediente != null) {
			tipos_vistas = 0;
			asignacion_expediente();
	
		}else {
			MensajeG.mostrar("Selecciones un expediente", FacesMessage.SEVERITY_WARN);
		}
	}

    private void carga_valores1(int idOnda) {
   	 double[] val = consultaOnda.valores_onda(idOnda);
   	 
   	 for(int ii =0; ii<= val.length-1; ii++) {
   		 valores[ii] = val[ii];
   	 }
    }
    private void  agrega_valores(double paamplitudj1) {
   	 valores_g_p.clear();
   	 setPaamplitudj_p(paamplitudj1);
    	 for(int ii =0; ii<= 260; ii++) {
    		 valores_g_p.add((paamplitudj1*(valores[ii]-130)/(29)/5));
    	 } 
    }
	public void vista_crear_expediente() {
		if(pnombrev.trim().length()>0) {
			if(pfoliov.trim().length()>0) {
				pnombrev1 = pnombrev;
				pfoliov1 =pfoliov;
				tipos_vistas = 1;
				idpacienteex = 0;
				idenfermedadex = 0;
                idmedicoex = 0;
                idhospitalex = 0;
                idequipoex = 0;
                idparametroex = 0;
				setPbotoncrearv("Crear");
				setPdescripcionv("");
				setPnombrequipov("");
				setPnombrehospitalv("");
				setPnombremedicov("");
				setPnombrepacientev("");
				setPnombreenfermedadav("");

			}else {
				MensajeG.mostrar("Ingrese un folio ", FacesMessage.SEVERITY_ERROR);
			}
		}else {
			MensajeG.mostrar("Ingrese un nombre ", FacesMessage.SEVERITY_ERROR);
		}
		
	}

	public void buscar_parametros() {
		if(buscar_parametrosstring.trim().length()>0) {
			 try {
					parametros_list = new ArrayList<Parametro>();
					parametros_list.clear();
					parametros_list = consultaOnda.parametros_por_nombre(buscar_parametrosstring);
				 
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		}else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	}
	public void buscar_equipo() {
		if(pbnombreequipov.trim().length() > 0) {
			 try {
				 Equipo estimulador = new Equipo();
				 estimuladores.clear();
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 estimulador =  estimuladorService.encuentra_serie(pbnombreequipov+";"+jjf);
					 if(estimulador!=null) {
						 
						 estimuladores.add(estimulador);
					 }
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		}else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	}
	public void buscar_hospital() {
		 if(pbnombrehospitalv.trim().length() > 0) {
			 try {
				 Hospital ho = new Hospital();
				 hospitales.clear();
					 ho =  hospitalService.encuentra_hospital(pbnombrehospitalv);
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
	public void buscar_paciente() {
		 if(pbnombrepacientev.trim().length() > 0) {
			 try {
				List<Usuario> cuent = new ArrayList<Usuario>();
				 pacientes.clear();
					 cuent =  consultaUsuarios.lista_usuaio_nombre(pbnombrepacientev);
					 if(cuent!=null) {
						 pacientes = cuent;
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		 }else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
		
		
	}

	public void modifica_crea_ex() {
		
		expediente_g = new Expediente();
		if(empaquetada_expediente()){
			desactivar_exs_porusurio(expediente_g.getIdusuario());
			if(tipos_vistas == 1)// se creara un nuevo expedeinte
			{
				try {
					boolean existe = false;
						 List<Expediente> listex = u_pacientesService.muestra_expedietes(idpacienteex);
						 for(int i = 0;i<=listex.size()-1;i++) {
							 if(listex.get(i).getIdenfermedad().equals(idenfermedadex)) {
								 existe = true;
							 }
						 }
						 if(existe == true) {
							 MensajeG.mostrar("Expediente ya Existente", FacesMessage.SEVERITY_WARN);
						 }else {
							// MensajeG.mostrar(listex.size()+";"+seleccion_paciente.getIdusuario(), FacesMessage.SEVERITY_WARN);
							u_pacientesService.insertaExpediente(expediente_g);
							Equipo cambiae =  estimuladorService.encuentra_por_id(expediente_g.getIdequipo());
						
							int resta_e = Integer.parseInt(cambiae.getTipo()) - expediente_g.getDosis(); 
							cambiae.setTipo(resta_e+"");
							estimuladorService.actualizarequipo(cambiae);
							Usuario paciente_mod = new Usuario();
							paciente_mod = consultaUsuarios.encontra_porid(expediente_g.getIdusuario());
							paciente_mod.setEdad(edad);
							paciente_mod.setSexo(sexo);
							consultaUsuarios.actualizaUsuario(paciente_mod);
							termino_dosis = false;
							MensajeG.mostrar("Expedinte: "+expediente_g.getNombre()+ " con folio "+expediente_g.getNoexpediente() +" Registrado", FacesMessage.SEVERITY_INFO);
						 }

				}catch(Exception e){
					MensajeG.mostrar(e.toString()+" id: "+expediente_g.getIdexpediente(),FacesMessage.SEVERITY_INFO);
				}
			}else 	if(tipos_vistas == 2)// se modifica expediente
			{
				
				try {
					expediente_g.setIdexpediente(seleccion_expediente.getIdexpediente());
					u_pacientesService.modificaExpediente(expediente_g);
					seleccion_expediente = expediente_g;
					Equipo cambiae =  estimuladorService.encuentra_por_id(expediente_g.getIdequipo());
					
					if(dosis_anterior == expediente_g.getDosis()) {
						
					}else {
						int resta_e1 = Integer.parseInt(cambiae.getTipo());
						int resta_e2 = expediente_g.getDosis(); 
						int resta_e = resta_e1 - resta_e2; 
						cambiae.setTipo(resta_e+"");
						estimuladorService.actualizarequipo(cambiae);
					}
					if(dosis_anterior<=0) {
						termino_dosis = true;
					}else {
						termino_dosis = false;
					}
					Usuario paciente_mod = new Usuario();
					paciente_mod = consultaUsuarios.encontra_porid(expediente_g.getIdusuario());
					paciente_mod.setEdad(edad);
					paciente_mod.setSexo(sexo);
					consultaUsuarios.actualizaUsuario(paciente_mod);
					MensajeG.mostrar("Expedeitne: "+expediente_g.getNombre()+ " con folio "+expediente_g.getNoexpediente() +" Modificado", FacesMessage.SEVERITY_INFO);
				}catch(Exception e) {
					MensajeG.mostrar(e.toString()+" id: "+expediente_g.getIdexpediente(),FacesMessage.SEVERITY_INFO);
				}
			}
		}
		
	}
	public boolean  empaquetada_expediente() {
		boolean ok_em = false;
		 if(getPfoliov1().trim().length()>0) {
			 if(getPnombrev1().trim().length()>0) {
				 if(idpacienteex>0) {
					 if(idenfermedadex>0) {
						 if(idmedicoex>0) {
							 if(idhospitalex>0) {
								 if(idequipoex>0) {
									 if(idparametroex>0) {
										 int num_equi_Est = 0;
										 try {
											 num_equi_Est = Integer.parseInt(estimuladorService.encuentra_por_id(idequipoex).getTipo()); 
										 }catch(Exception e) {}
										  if(num_equi_Est>=getPdosisexp()) {
												 expediente_g.setDosis(getPdosisexp());
												 expediente_g.setNoexpediente(getPfoliov1());
												 expediente_g.setNombre(getPnombrev1());
												 expediente_g.setIdusuario(idpacienteex);
												 expediente_g.setIdenfermedad(idenfermedadex);
												 expediente_g.setIdmedico(idmedicoex);
												 expediente_g.setIdhospital(idhospitalex);
												 expediente_g.setIdequipo(idequipoex);
												 expediente_g.setDescripcion(getPdescripcionv());
												
												 if(isExestatus()) {expediente_g.setEstatus("true");}else {expediente_g.setEstatus("false");}
												 expediente_g.setIdparametroexp(idparametroex);
												 ok_em = true;
											  
										  }else {
												 MensajeG.mostrar("la dosis debe de ser menos o igual a "+num_equi_Est, FacesMessage.SEVERITY_ERROR); 
											 }

									 }else {
										 MensajeG.mostrar("Seleccione Parametro", FacesMessage.SEVERITY_ERROR); 
									 }
								 }else {
									 MensajeG.mostrar("Seleccione Equipo", FacesMessage.SEVERITY_ERROR);
								 }
							 }else {
								 MensajeG.mostrar("Seleccione Hospital", FacesMessage.SEVERITY_ERROR);
							 }
						 }else {
							 MensajeG.mostrar("Seleccione Medico", FacesMessage.SEVERITY_ERROR);
						 }
					 }else {
						 MensajeG.mostrar("Seleccione Enfermedad", FacesMessage.SEVERITY_ERROR);
					 }
				 }else {
					 MensajeG.mostrar("Seleccione Paciente: ", FacesMessage.SEVERITY_ERROR);
				 }
			 }else {
				 MensajeG.mostrar("Nombre no valido", FacesMessage.SEVERITY_ERROR);
			 }
			
		 }else {
			 MensajeG.mostrar("Folio no valido", FacesMessage.SEVERITY_ERROR);
		 }
		return ok_em;
	}
	public boolean estado_ubicacion(int idkey) {
		boolean res_ubi = false;
		Ubicacion  ubicaex = new Ubicacion(); 
		ubicaex = u_pacientesService.ubica(idkey);
		if(ubicaex.getEstatus().equals("true")) {
			res_ubi = true;
		}
		return res_ubi;
	}
	public String convertirserie(String serie){
		String[] partes_serie = serie.split(";");
		return partes_serie[0];
	}
	public String convertirgeneracion(String serie){
		String[] partes_serie = serie.split(";");
		return "G. "+partes_serie[1];
	}
	public void buscar_medico() {
		 if(pbnombremedicov.trim().length() > 0) {
			 try {
				List<Usuario> cuent = new ArrayList<Usuario>();
				 medicos.clear();
					 cuent =  consultaUsuarios.lista_usuaio_nombre(pbnombremedicov);
					 if(cuent!=null) {
						 medicos = cuent;
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		 }else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
		
		
	}
	public String convertirFecha(Date fecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+1;
		return (day<10?"0"+day:day)+"/"+ (month<10?"0"+month:month) +"/"+cal.get(Calendar.YEAR);
	}
	public String convertirHora(Date fecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int min = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int second = cal.get(Calendar.SECOND);
		return (hour<10?"0"+hour:hour)+":"+ (min<10?"0"+min:min)+ ":"+(second<10?"0"+second:second);
	}
	public int getTipos_vistas() {
		return tipos_vistas;
	}

	private void createLineModels(double ampli,String datos_paciente,int tipo_esti) {
	        lineModel1 = initLinearModel(ampli,datos_paciente,tipo_esti);
	        lineModel1.setTitle("Señal de estimulación");
	        lineModel1.setLegendPosition("e");
	        Axis yAxis = lineModel1.getAxis(AxisType.Y);
	        yAxis.setMin(-5);
	        yAxis.setMax(5);

	 
	        zoomModel = initLinearModel(ampli,datos_paciente,tipo_esti);
	        zoomModel.setTitle("Zoom");
	        zoomModel.setZoom(true);
	        zoomModel.setLegendPosition("e");
	        yAxis = zoomModel.getAxis(AxisType.Y);
	        yAxis.setMin(-5);
	        yAxis.setMax(5);
	    }
	 
	 private LineChartModel initLinearModel(double ampli, String datos_paciente,int tipo_esti) {
		 LineChartModel model = new LineChartModel();
		 
	        LineChartSeries series1 = new LineChartSeries();
	        LineChartSeries series2 = new LineChartSeries();
	        series1.setLabel("Señal orioginal");
	        series2.setLabel("Series de estimulo");
	        String[] datos_onda = datos_paciente.split(":");
	        
	        
	      	 for(int ii =0; ii<= 260; ii++) {
	      		series1.set(ii,ampli*((valores[ii]-130)/29)/5);
	      		try {
	      			if(tipo_esti== 1 || tipo_esti ==2)//generaciones de estimulacion 
	      			{
	      				series2.set(ii,ampli*((valores[ii]-130)/29)/5);
	      			}else {
	      				valores_paciente[ii] = 8*((Double.parseDouble(datos_onda[ii])-127)/255);
	      				series2.set(ii,valores_paciente[ii]);
	      			}
	      		}catch(Exception e){
	      			series2.set(ii, 0);
	      		}

	       	 }
	      	
	      	/*LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Series de estimulo");
	 
	        
	        series2.set(1, 2);
	        series2.set(2, 3);
	        series2.set(3, 1);
	        series2.set(4, 2);
	        series2.set(5, 1);
	 
	 		model.addSeries(series2);*/
	      	model.addSeries(series2);
	        model.addSeries(series1);
	        
	 
	        return model;
	    }
	 
	public void setTipos_vistas(int tipos_vistas) {
		this.tipos_vistas = tipos_vistas;
	}

	public String getPnombrev() {
		return pnombrev;
	}

	public void setPnombrev(String pnombrev) {
		this.pnombrev = pnombrev;
	}

	public String getPfoliov() {
		return pfoliov;
	}

	public void setPfoliov(String pfoliov) {
		this.pfoliov = pfoliov;
	}

	public String getPnombrepacientev() {
		return pnombrepacientev;
	}

	public void setPnombrepacientev(String pnombrepacientev) {
		this.pnombrepacientev = pnombrepacientev;
	}

	public String getPnombrehospitalv() {
		return pnombrehospitalv;
	}

	public void setPnombrehospitalv(String pnombrehospitalv) {
		this.pnombrehospitalv = pnombrehospitalv;
	}

	public String getPnombremedicov() {
		return pnombremedicov;
	}

	public void setPnombremedicov(String pnombremedicov) {
		this.pnombremedicov = pnombremedicov;
	}

	public String getPnombrequipov() {
		return pnombrequipov;
	}

	public void setPnombrequipov(String pnombrequipov) {
		this.pnombrequipov = pnombrequipov;
	}

	public ConsultaUsuarios getConsultaUsuarios() {
		return consultaUsuarios;
	}

	public void setConsultaUsuarios(ConsultaUsuarios consultaUsuarios) {
		this.consultaUsuarios = consultaUsuarios;
	}

	public Usuario getSeleccion_paciente() {
		return seleccion_paciente;
	}
	public void setSeleccion_paciente(Usuario seleccion_paciente) {
		this.seleccion_paciente = seleccion_paciente;
	}
	public List<Usuario> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Usuario> cuentas) {
		this.cuentas = cuentas;
	}
	public Usuario getSeleccion_user() {
		return seleccion_user;
	}
	public void setSeleccion_user(Usuario seleccion_user) {
		this.seleccion_user = seleccion_user;
	}
	public int getTipo_usr() {
		return tipo_usr;
	}
	public void setTipo_usr(int tipo_usr) {
		this.tipo_usr = tipo_usr;
	}
	public List<Usuario> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Usuario> pacientes) {
		this.pacientes = pacientes;
	}
	public List<Usuario> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Usuario> medicos) {
		this.medicos = medicos;
	}
	public String getPbnombrepacientev() {
		return pbnombrepacientev;
	}
	public void setPbnombrepacientev(String pbnombrepacientev) {
		this.pbnombrepacientev = pbnombrepacientev;
	}
	public String getPbnombremedicov() {
		return pbnombremedicov;
	}
	public void setPbnombremedicov(String pbnombremedicov) {
		this.pbnombremedicov = pbnombremedicov;
	}
	public Usuario getSeleccion_medico() {
		return seleccion_medico;
	}
	public void setSeleccion_medico(Usuario seleccion_medico) {
		this.seleccion_medico = seleccion_medico;
	}
	public HospitalService getHospitalService() {
		return hospitalService;
	}
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	public List<Hospital> getHospitales() {
		return hospitales;
	}
	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}
	public Hospital getSeleccion_hospital() {
		return seleccion_hospital;
	}
	public void setSeleccion_hospital(Hospital seleccion_hospital) {
		this.seleccion_hospital = seleccion_hospital;
	}
	public String getPbnombrehospitalv() {
		return pbnombrehospitalv;
	}
	public void setPbnombrehospitalv(String pbnombrehospitalv) {
		this.pbnombrehospitalv = pbnombrehospitalv;
	}
	public EstimuladorService getEstimuladorService() {
		return estimuladorService;
	}
	public void setEstimuladorService(EstimuladorService estimuladorService) {
		this.estimuladorService = estimuladorService;
	}
	public List<Equipo> getEstimuladores() {
		return estimuladores;
	}
	public void setEstimuladores(List<Equipo> estimuladores) {
		this.estimuladores = estimuladores;
	}
	public Equipo getSelecion_estimulador() {
		return selecion_estimulador;
	}
	public void setSelecion_estimulador(Equipo selecion_estimulador) {
		this.selecion_estimulador = selecion_estimulador;
	}
	public String getPbnombreequipov() {
		return pbnombreequipov;
	}
	public void setPbnombreequipov(String pbnombreequipov) {
		this.pbnombreequipov = pbnombreequipov;
	}
	public String getPdescripcionv() {
		return pdescripcionv;
	}
	public void setPdescripcionv(String pdescripcionv) {
		this.pdescripcionv = pdescripcionv;
	}
	public boolean isExestatus() {
		return exestatus;
	}
	public void setExestatus(boolean exestatus) {
		this.exestatus = exestatus;
	}
	
	public U_pacientesService getU_pacientesService() {
		return u_pacientesService;
	}
	public void setU_pacientesService(U_pacientesService u_pacientesService) {
		this.u_pacientesService = u_pacientesService;
	}
	public List<Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(List<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	public Enfermedad getSeleccion_enfermedad() {
		return seleccion_enfermedad;
	}
	public void setSeleccion_enfermedad(Enfermedad seleccion_enfermedad) {
		this.seleccion_enfermedad = seleccion_enfermedad;
	}
	public String getPnombreenfermedadav() {
		return pnombreenfermedadav;
	}
	public void setPnombreenfermedadav(String pnombreenfermedadav) {
		this.pnombreenfermedadav = pnombreenfermedadav;
	}
	public String getPbotoncrearv() {
		return pbotoncrearv;
	}
	public void setPbotoncrearv(String pbotoncrearv) {
		this.pbotoncrearv = pbotoncrearv;
	}
	public Expediente getExpediente_g() {
		return expediente_g;
	}
	public void setExpediente_g(Expediente expediente_g) {
		this.expediente_g = expediente_g;
	}
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	public Expediente getSeleccion_expediente() {
		return seleccion_expediente;
	}
	public void setSeleccion_expediente(Expediente seleccion_expediente) {
		this.seleccion_expediente = seleccion_expediente;
	}
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public List<SelectItem> getEnfermedadesitem() {
		return enfermedadesitem;
	}
	public void setEnfermedadesitem(List<SelectItem> enfermedadesitem) {
		this.enfermedadesitem = enfermedadesitem;
	}
	public EstadoUnidad getEstadoUnidad() {
		return estadoUnidad;
	}
	public void setEstadoUnidad(EstadoUnidad estadoUnidad) {
		this.estadoUnidad = estadoUnidad;
	}

	public String getPnombrev1() {
		return pnombrev1;
	}

	public void setPnombrev1(String pnombrev1) {
		this.pnombrev1 = pnombrev1;
	}

	public String getPfoliov1() {
		return pfoliov1;
	}

	public void setPfoliov1(String pfoliov1) {
		this.pfoliov1 = pfoliov1;
	}
	public ConsultaOnda getConsultaOnda() {
		return consultaOnda;
	}

	public void setConsultaOnda(ConsultaOnda consultaOnda) {
		this.consultaOnda = consultaOnda;
	}

	public List<Parametro> getParametros_list() {
		return parametros_list;
	}

	public void setParametros_list(List<Parametro> parametros_list) {
		this.parametros_list = parametros_list;
	}

	public Parametro getSeleccion_parametro() {
		return seleccion_parametro;
	}

	public void setSeleccion_parametro(Parametro seleccion_parametro) {
		this.seleccion_parametro = seleccion_parametro;
	}

	public String getBuscar_parametrosstring() {
		return buscar_parametrosstring;
	}

	public void setBuscar_parametrosstring(String buscar_parametrosstring) {
		this.buscar_parametrosstring = buscar_parametrosstring;
	}

	public String getParametrosstring() {
		return parametrosstring;
	}

	public void setParametrosstring(String parametrosstring) {
		this.parametrosstring = parametrosstring;
	}

	public List<Double> getValores_g_p() {
		return valores_g_p;
	}

	public void setValores_g_p(List<Double> valores_g_p) {
		this.valores_g_p = valores_g_p;
	}

	public double getPafrecueciaj_p() {
		return pafrecueciaj_p;
	}

	public void setPafrecueciaj_p(double pafrecueciaj_p) {
		this.pafrecueciaj_p = pafrecueciaj_p;
	}

	public double getPaamplitudj_p() {
		return paamplitudj_p;
	}

	public void setPaamplitudj_p(double paamplitudj_p) {
		this.paamplitudj_p = paamplitudj_p;
	}

	public double getPatiempoj_p() {
		return patiempoj_p;
	}

	public void setPatiempoj_p(double patiempoj_p) {
		this.patiempoj_p = patiempoj_p;
	}

	
	public List<ExpeEstim> getExpeestimes() {
		return expeestimes;
	}

	public void setExpeestimes(List<ExpeEstim> expeestimes) {
		this.expeestimes = expeestimes;
	}

	public ExpeEstim getSeleccion_expeestim() {
		return seleccion_expeestim;
	}

	public void setSeleccion_expeestim(ExpeEstim seleccion_expeestim) {
		this.seleccion_expeestim = seleccion_expeestim;
	}

	public String getExlat() {
		return exlat;
	}

	public void setExlat(String exlat) {
		this.exlat = exlat;
	}

	public String getExlog() {
		return exlog;
	}

	public void setExlog(String exlog) {
		this.exlog = exlog;
	}
	public String getNombre_onda() {
		return nombre_onda;
	}

	public void setNombre_onda(String nombre_onda) {
		this.nombre_onda = nombre_onda;
	}

	public String getNombre_onda_ubica() {
		return nombre_onda_ubica;
	}

	public void setNombre_onda_ubica(String nombre_onda_ubica) {
		this.nombre_onda_ubica = nombre_onda_ubica;
	}
	 public LineChartModel getLineModel1() {
			return lineModel1;
		}

		public void setLineModel1(LineChartModel lineModel1) {
			this.lineModel1 = lineModel1;
		}

		public LineChartModel getZoomModel() {
			return zoomModel;
		}

		public void setZoomModel(LineChartModel zoomModel) {
			this.zoomModel = zoomModel;
		}
		public int getPdosisexp() {
			return pdosisexp;
		}

		public void setPdosisexp(int pdosisexp) {
			this.pdosisexp = pdosisexp;
		}
		public String getEstimulos_empreados() {
			return estimulos_empreados;
		}
		public void setEstimulos_empreados(String estimulos_empreados) {
			this.estimulos_empreados = estimulos_empreados;
		}
		public String getEdad() {
			return edad;
		}
		public void setEdad(String edad) {
			this.edad = edad;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public boolean isTermino_dosis() {
			return termino_dosis;
		}
		public void setTermino_dosis(boolean termino_dosis) {
			this.termino_dosis = termino_dosis;
		}
		 public String getPeso() {
		     return peso;
		 }
		 public void setPeso(String peso) {
		     this.peso = peso;
		 }
		 public String getP_mayor() {
		     return p_mayor;
		 }
		 public void setP_mayor(String p_mayor) {
		     this.p_mayor = p_mayor;
		 }
		 public String getP_menor() {
		     return p_menor;
		 }
		 public void setP_menor(String p_menor) {
		     this.p_menor = p_menor;
		 }
		 public String getTemperatura() {
		     return temperatura;
		 }
		 public void setTemperatura(String temperatura) {
		     this.temperatura = temperatura;
		 }
		 public String getAltura() {
		     return altura;
		 }
		 public void setAltura(String altura) {
		     this.altura = altura;
		 }
		 public String getMasa_corp() {
		     return masa_corp;
		 }
		 public void setMasa_corp(String masa_corp) {
		     this.masa_corp = masa_corp;
		 }
		 public String getGrasa_corp() {
		     return grasa_corp;
		 }
		 public void setGrasa_corp(String grasa_corp) {
		     this.grasa_corp = grasa_corp;
		 }
		
		 public String getPresionI() {
		     return presionI;
		 }
		 public void setPresionI(String presionI) {
		     this.presionI = presionI;
		 }
		 public String getPresionD() {
		     return presionD;
		 }
		 public void setPresionD(String presionD) {
		     this.presionD = presionD;
		 }
		 public Date getFechapresion() {
		     return fechapresion;
		 }
		 public void setFechapresion(Date fechapresion) {
		     this.fechapresion = fechapresion;
		 }

		 public Date getFechaConsulta() {
		     return fechaConsulta;
		 }
		 public void setFechaConsulta(Date fechaConsulta) {
		     this.fechaConsulta = fechaConsulta;
		 }


		public String getExpe_m() {
			return expe_m;
		}
		public void setExpe_m(String expe_m) {
			this.expe_m = expe_m;
		}
		public int getIdExpediente() {
		     return idExpediente;
		 }
		 public void setIdExpediente(int idExpediente) {
		     this.idExpediente = idExpediente;
		 }
		 public int getIdExpeConsul() {
		     return idExpeConsul;
		 }
		 public void setIdExpeConsul(int idExpeConsul) {
		     this.idExpeConsul = idExpeConsul;
		 }
		 public List<Expediente> getExp_id() {
		     return exp_id;
		 }
		 public void setExp_id(List<Expediente> exp_id) {
		     this.exp_id = exp_id;
		 }
		 
		 public int getIdexp() {
		     return idexp;
		 }
		 public void setIdexp(int idexp) {
		     this.idexp = idexp;
		 }
		 public ExpedienteConsulta getExp_Consul() {
		     return exp_Consul;
		 }
		 public void setExp_Consul(ExpedienteConsulta exp_Consul) {
		     this.exp_Consul = exp_Consul;
		 }
		 public int getIdexpedienteC() {
		     return idexpedienteC;
		 }
		 public Date getFechaI() {
				return fechaI;
			}
			public void setFechaI(Date fechaI) {
				this.fechaI = fechaI;
			}
			public Date getFechaF() {
				return fechaF;
			}
			public void setFechaF(Date fechaF) {
				this.fechaF = fechaF;
			}
			public ExpedienteConsulta getSeleccion_consulta() {
				return seleccion_consulta;
			}
			public void setSeleccion_consulta(ExpedienteConsulta seleccion_consulta) {
				this.seleccion_consulta = seleccion_consulta;
			}
			
			public List<ExpedienteConsulta> getFecha_exp() {
				return fecha_exp;
			}
			public void setFecha_exp(List<ExpedienteConsulta> fecha_exp) {
				this.fecha_exp = fecha_exp;
			}
			 public void setIdexpedienteC(int idexpedienteC) {
		         this.idexpedienteC = idexpedienteC;
		     }
			 public boolean isHay_presionintraocular() {
					return hay_presionintraocular;
				}

				public void setHay_presionintraocular(boolean hay_presionintraocular) {
					this.hay_presionintraocular = hay_presionintraocular;
				}
				public boolean isHay_peso() {
					return hay_peso;
				}

				public void setHay_peso(boolean hay_peso) {
					this.hay_peso = hay_peso;
				}

				public boolean isHay_pa() {
					return hay_pa;
				}

				public void setHay_pa(boolean hay_pa) {
					this.hay_pa = hay_pa;
				}

				public boolean isHay_altura() {
					return hay_altura;
				}

				public void setHay_altura(boolean hay_altura) {
					this.hay_altura = hay_altura;
				}

				public boolean isHay_temp() {
					return hay_temp;
				}

				public void setHay_temp(boolean hay_temp) {
					this.hay_temp = hay_temp;
				}

				public boolean isHay_masa() {
					return hay_masa;
				}

				public void setHay_masa(boolean hay_masa) {
					this.hay_masa = hay_masa;
				}

				public boolean isHay_grasa() {
					return hay_grasa;
				}

				public void setHay_grasa(boolean hay_grasa) {
					this.hay_grasa = hay_grasa;
				}
			     public String getDescripcionedit() {
						return descripcionedit;
					}

					public void setDescripcionedit(String descripcionedit) {
						this.descripcionedit = descripcionedit;
					}
			
}
