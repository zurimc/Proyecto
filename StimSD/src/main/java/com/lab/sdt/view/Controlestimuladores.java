package com.lab.sdt.view;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.MantenimientoMaterial;
import com.lab.sdt.model.Material;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.service.EstimuladorService;

import com.lab.sdt.util.MensajeG;




@ManagedBean
@ViewScoped
public class Controlestimuladores implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serie;
	private String serieh;
	private String seriem;
	
	private String generacion;
	private String generacionh;
	private String generacionm;
	
	private String idEstadoe;
	private String acti_est;

	private boolean acti_ests;
	private String serie_b;
	private String serie_bh;
	
	private String serie_m;
	
	private String serie_m_m;

	private String buscar = "";
	
	private String buscar_m = "";
	
	private String boton_f;
	
	private String material;
	
	private String cantidad;
	
	private String unidad;
	
	private String modelo;
	
	private String noserie;
	
	private String onda_pref;
	
	private String[] estatus_mante = new String[200];

	private int se_tulizo;
	
	private String lote;
	
	private String imei;
	
	private String tipo_comu;
	
	private String qr_equipo;
	
	private String epotencial;

	private int se_tulizo_m = 0;
	private int id_man = 0;
	int cantidad_util = 0;
	
	private List<Equipo> estimuladores;
	
	private List<Equipo> estimuladoresh; 
	
	private List<Material> materiales;
	
	private List<Material> materiales_m;
	
	private List<Material> materiales_utlizados;
	

	private Equipo selecion_est;
	
	private Equipo selecion_esth;
	
	private Material selecion_mat;
	
	private Material selecion_mat_m;
	
	private Material selecion_mat_utlizados;

	private int tipos_vistas;

	private Date fecha1;

	private String fallas_est;
	
	private String actualiza_est;

	private Usuario userDTO;
	
    private Mantenimiento man;
    
    private Mantenimiento man_selec;
    
    private List<Mantenimiento> his_man;
     
    private List<Mantenimiento> detallesh;
 
    private boolean tipo_user; 

    private String fallas_hist;

    private String actualiza_hist;
    
    private String elat;
    
    private String elog;

	private String tecnico_m;
	
	private String hora_his;
    
	private String fech_his;


	@ManagedProperty("#{estimuladorService}")
	public EstimuladorService estimuladorService;
	/*zuri inicio*/
	private Date fechaI;
	private Date fechaF;
	 
	private int registro;

	/*zuri*/
	@SuppressWarnings("deprecation")
	public void buscar_fechasC() {
	
			// MensajeG.mostrar("ok", FacesMessage.SEVERITY_INFO);
		RequestContext.getCurrentInstance().execute("PF('bFecha').show();");
	
		}
	 public void encontrar_fechaEx() {
	    	MensajeG.mostrar(":D", FacesMessage.SEVERITY_ERROR);
	    } 
	public void guarda_actualiza_datos() {
		/*if(fechaI.after(fechaF)){
			MensajeG.mostrar("La fecha final no puede ser anterior a la fecha inicial", FacesMessage.SEVERITY_ERROR);
			return;
		}
		his_man = new ArrayList<Mantenimiento>();
		
		try {
			his_man.clear();
			his_man = estimuladorService.por_fecha(selecion_esth.getIdequipo(),getFechaI(),getFechaF());	
			registro = his_man.size();
			if(registro == 0){
				MensajeG.mostrar("No se encontraron registros en esa fecha", FacesMessage.SEVERITY_WARN);
			}
		}catch(Exception e) {
			MensajeG.mostrar("Ocurrió una excepción al recuperar el historial", FacesMessage.SEVERITY_FATAL);
		}*/
		MensajeG.mostrar(":D", FacesMessage.SEVERITY_ERROR);
		
		
		
	}
	
	   public void seleccionarFechaInicial(){
			if(fechaI.after(fechaF)){
				MensajeG.mostrar("La fecha final no puede ser anterior a la fecha inicial", FacesMessage.SEVERITY_ERROR);
				return;
				
			}
			
		}
	   
		
		public void actualizar_fecha() {
			setFechaI(getFechaI());
			setFechaF(getFechaF());
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

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}
/*zuri fin*/
	@PostConstruct
	public void init(){
		actualiza_e(); 	
		vista_equipo();
		setQr_equipo("stim-SD");
		Calendar cal = Calendar.getInstance();
		//fechaI = cal.getTime();
		fechaF = cal.getTime();
	}

	public void mantenimiento() {
		if(selecion_est!=null) {
			if(selecion_est.getNoserie().equals("")) {
				 MensajeG.mostrar("Seleccione un equipo", FacesMessage.SEVERITY_ERROR);
			}else {
			    
			    	  try {
			    		  registro_mantenimiento(fallas_est,actualiza_est); 
			    		  relacion_man_equ(selecion_est.getIdequipo());
			    		  MensajeG.mostrar("Evento registrado ", FacesMessage.SEVERITY_INFO);
			    	  }catch(Exception e) {
			    		  MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
			    		  System.out.println(e.toString());
			    	  }
			      
				
			}
			
		}else {
			MensajeG.mostrar("Seleccione un equipo", FacesMessage.SEVERITY_ERROR);
		}
	}
	public void guarda_m() {
		busca_noserie_m();
		actualizar_materia(0);
	}
	public void guarda_e() {

		busca_noserie();
		actualizar_registrar(0);
	}
	public void actualizar_m() {
		selecion_mat = new Material();
		selecion_mat.setMaterial("");
		actualizar_materia(1);
	}
	public void actualiza_e() {
		selecion_est = new Equipo();
		selecion_est.setNoserie("");
		actualizar_registrar(1);
	}
	public void buscar_material_m() {
		if(serie_m_m.trim().length()>0) {
			try {
				materiales_m.clear();
				materiales_m = estimuladorService.encuntra_material(serie_m_m);
			}catch(Exception e) {
				MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			}
		}else {
			MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		}
	}
	public void buscar_material() {
		if(serie_m.trim().length()>0) {
			try {
				materiales.clear();
				materiales = estimuladorService.encuntra_material(serie_m);
			}catch(Exception e) {
				MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			}
		}else {
			MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		}
		
	}
	public void buscar_equipom() {
		if(seriem.trim().length() > 0) {
			 try {
				 Equipo estimulador = new Equipo();
				 estimuladoresh.clear();
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 estimulador =  estimuladorService.encuentra_serie(seriem+";"+jjf);
					 if(estimulador!=null) {
						 
						 estimuladoresh.add(estimulador);
					 }
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		}else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	}
	public void buscar_equipoh() {
		if(serie_bh.trim().length() > 0) {
			 try {
				 Equipo estimulador = new Equipo();
				 estimuladoresh.clear();
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 estimulador =  estimuladorService.encuentra_serie(serie_bh+";"+jjf);
					 if(estimulador!=null) {
						 
						 estimuladoresh.add(estimulador);
					 }
				 }
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		}else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	}
	public void buscar_equipo() {
		 if(serie_b.trim().length() > 0) {
			 try {
				 Equipo estimulador = new Equipo();
				 estimuladores.clear();
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 estimulador =  estimuladorService.encuentra_serie(serie_b+";"+jjf);
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
	public void cargar_materiales1() {
		materiales_m = estimuladorService.lista_material();
		serie_m_m = "";
	}
	public void cargar_materiales() {
		  materiales = new ArrayList<Material>();
		   materiales = estimuladorService.lista_material();
		   
		selecion_mat = new Material();
		selecion_mat.setnSerie("");
	}
	
	public void cargar_equipo() {
		estimuladores = new ArrayList<Equipo>();
		estimuladores = estimuladorService.lista_equipos();
		
		selecion_est = new Equipo();
		selecion_est.setNoserie("");
	}
	public void cargar_equipoh() {
		estimuladoresh = new ArrayList<Equipo>();
		estimuladoresh = estimuladorService.lista_equipos();
		
		selecion_esth = new Equipo();
		selecion_esth.setNoserie("");

	}

	public void material_ocupado(){
		se_tulizo_m = selecion_mat_m.getIdmaterial();
		
		cantidad_util = estimuladorService.datosMaterial(selecion_mat_m.getIdmaterial()).getCantidad();
		serie_m_m = selecion_mat_m.getMaterial();
	}
	@SuppressWarnings("deprecation")
	public void cantidad_ocupada(){
		boolean hay_1 = false;
		int donde_hay = 0;
		if(se_tulizo_m<=0) {
			MensajeG.mostrar("Seleccioné algún material", FacesMessage.SEVERITY_FATAL);
		}else if(cantidad_util<se_tulizo) {
			
			MensajeG.mostrar("La cantidad de componentes no existe en almacen", FacesMessage.SEVERITY_FATAL);
		}else{
			
			if(se_tulizo<=0) {
				MensajeG.mostrar("Inidque alguna cantidad", FacesMessage.SEVERITY_FATAL);
			}else {
				for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
					if(materiales_utlizados.get(i).getIdmaterial().equals(se_tulizo_m)){
						hay_1 = true;
						donde_hay = i;
					}
				}
				if(hay_1 == true) {
					estatus_mante[donde_hay] = se_tulizo+":"+se_tulizo_m;
					materiales_utlizados.get(donde_hay).setCantidad(se_tulizo);
				}else {
					selecion_mat_m.setCantidad(se_tulizo);
					materiales_utlizados.add(selecion_mat_m);
					estatus_mante[materiales_utlizados.size()-1] = se_tulizo+":"+se_tulizo_m; 
				}
				MensajeG.mostrar(selecion_mat_m.getMaterial()+" agregad@", FacesMessage.SEVERITY_INFO);
				se_tulizo_m = 0;
				se_tulizo = 0;
				RequestContext.getCurrentInstance().execute("PF('agrega_m').hide();");
			}

		}
	}
	public void quita_elemento()
	{
		boolean hay = false;
		for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
			if(materiales_utlizados.get(i).equals(selecion_mat_utlizados)){
				hay =  true; 
				materiales_utlizados.remove(i);
			}
			if(hay == true) {
				estatus_mante[i] = estatus_mante[i+1]; 
			}
		}
	}
	public void mostar_Cantidad() {
		for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
			if(materiales_utlizados.get(i).equals(selecion_mat_utlizados)){
				String[] partes_estatus_mante = estatus_mante[i].split(":");
				MensajeG.mostrar("Cantidad: "+partes_estatus_mante[0], FacesMessage.SEVERITY_INFO);
			}
		}
		
	}
	public void elige_m(SelectEvent event) {
		setMaterial(selecion_mat.getMaterial());
		setCantidad(selecion_mat.getCantidad()+"");
		setUnidad(selecion_mat.getUnidad());
		setNoserie(selecion_mat.getnSerie());
		setModelo(selecion_mat.getModelo());
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
	public String convertirserie(String serie){
		String[] partes_serie = serie.split(";");
		return partes_serie[0];
	}
	public String convertirgeneracion(String serie){
		String[] partes_serie = serie.split(";");
		return "G. "+partes_serie[1];
	}
	public void elige_hist( SelectEvent event) {
		String[] partes_serie = selecion_esth.getNoserie().split(";");
		setSerieh(partes_serie[0]);
		setGeneracionh(partes_serie[1]);
		
		his_man = new ArrayList<Mantenimiento>();
		try {
			his_man.clear();
			his_man = estimuladorService.ver_historico(selecion_esth.getIdequipo());	
		}catch(Exception e) {
			
		}
		
	}
	public void elige_mant( SelectEvent event) {
		setFallas_hist(man_selec.getTipoactualizacion());
		setActualiza_hist(man_selec.getFalla());
		setElat(man_selec.getLatitud());
		setElog(man_selec.getLonguitud());
		setHora_his(convertirHora(man_selec.getFechamantenimiento()));
		setFech_his(convertirFecha(man_selec.getFechamantenimiento()));
		Usuario userm = estimuladorService.encuentraIdUsuatio(man_selec.getIdusuario());
		setTecnico_m(userm.getNombre() + " "+ userm.getApellido1());
		materiales_utlizados = new ArrayList<Material>();
		materiales_utlizados.clear();
		materiales_utlizados = estimuladorService.encuntra_material_man(man_selec.getIdmantenimiento());
		
	}

	public void elige( SelectEvent event) {
		String[] partes_serie = selecion_est.getNoserie().split(";");

		setSerie(partes_serie[0]);
		setGeneracion(partes_serie[1]);
		setIdEstadoe(selecion_est.getEstado());
		setActi_ests(true);
		setActi_est(selecion_est.getEstatus());
		setBoton_f(selecion_est.getTipo());		
		try {
			setOnda_pref(selecion_est.getOndapredeterminada());
			String[] partes_serie_l = selecion_est.getDetalles().split(";");
			setLote(partes_serie_l[0]);
			setImei(partes_serie_l[2]);
			setTipo_comu(partes_serie_l[1]);
			setQr_equipo(getSerie()+";"+getTipo_comu()+";"+getImei());
			if(partes_serie_l.length>3) {
				setEpotencial(partes_serie_l[3]);
			}else {
				setEpotencial("");
			}
		}catch(Exception e) {
			setQr_equipo("stim-SD");
			setLote("");
			setImei("");
			setTipo_comu("");
			setOnda_pref("1");
		}
	
	}
	public void actualizar_materia(int tipo) {
		try {
			if(material.trim().length()>0) {
				if(cantidad.trim().length()>0) {
					if(noserie.trim().length()>0) {
						if(tipo == 1) {
							registro_materia(tipo);
							MensajeG.mostrar(noserie +" Actualizado", FacesMessage.SEVERITY_INFO);
							cargar_materiales();
						}else {
							if(buscar_m.equals("") ||  buscar_m == null) {
								registro_materia(tipo);
								MensajeG.mostrar(noserie +" Guardado", FacesMessage.SEVERITY_INFO);
								cargar_materiales();
							}else {
								MensajeG.mostrar("Material ya registardo", FacesMessage.SEVERITY_WARN);
							}	
						}
					}else {
						MensajeG.mostrar("Indique el numero de serie", FacesMessage.SEVERITY_WARN);
					}
				}else {
					MensajeG.mostrar("Indique la cantidad", FacesMessage.SEVERITY_WARN);
				}
			}else {
				MensajeG.mostrar("Nombre no valido", FacesMessage.SEVERITY_WARN);
			}
			
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
		}
		
	}
	public void actualizar_registrar(int tipo) {
		try {
			
			if(serie.trim().length()==10){
				 if(idEstadoe.trim().length() > 0) {
					 if(generacion.trim().length() > 0) {	
							 if(tipo == 0) // registro
							 {
								 if(buscar.equals("")) {
									 registro_equipos(serie,generacion,idEstadoe,acti_est,boton_f,tipo);
									 MensajeG.mostrar(serie+" (G."+generacion+")" + " Registrado", FacesMessage.SEVERITY_INFO);	
								 }else {
									 MensajeG.mostrar("Equipo ya registardo", FacesMessage.SEVERITY_WARN);
								 }
							 }else if(tipo == 1) // actualizacion
							 {
								 registro_equipos(serie,generacion,idEstadoe,acti_est,boton_f,tipo);
								 MensajeG.mostrar(serie +" (G."+generacion+")" + " Actualizado", FacesMessage.SEVERITY_INFO);
							 }
					 }else {
						 MensajeG.mostrar("Indique el modelo del equipo", FacesMessage.SEVERITY_WARN);
					 }
				 }else {
					 MensajeG.mostrar("Indique el estado del equipo", FacesMessage.SEVERITY_WARN);
				 }
			}else {
				MensajeG.mostrar("Número de serie no valido", FacesMessage.SEVERITY_WARN);
			}
		}catch(Exception e) {
			//MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
		}
	}
	public void busca_noserie_m() {
		if(noserie.trim().length()>0) {
			try {
				buscar_m = estimuladorService.encutra_noserie(noserie).getMaterial();
			}catch(Exception e) {
				buscar_m ="";
			}
			
		}
	}
	public void busca_noserie() {
		String res = "";
		buscar = "";
		Equipo estimulador = new Equipo();
		if(serie.trim().length() > 0) {
			 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
			 {
				 estimulador = estimuladorService.encuentra_serie(serie+";"+jjf);
				 if(estimulador!=null) {
					 res =estimulador.getNoserie();
					 String[] partes_serie = res.split(";");
					 buscar  = partes_serie[0];
					 break;
				 }
			 }
		}
		if(res!=null) {
			String[] partes_serie = res.split(";");
			setSerie_b(partes_serie[0]);
		}	
}
	public void registro_mantenimiento(String fallaa, String actuaa){
		try {
			String mate_estatus = "";
			//for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
		//		mate_estatus =  mate_estatus + estatus_mante[i]+";";
		//	}
			man = new Mantenimiento() ;
			man.setFechamantenimiento(new Date());
			man.setTipoactualizacion(actuaa);
			man.setFalla(fallaa);
			man.setEstatus(mate_estatus);
			man.setIdusuario(obtenerUsuarioEnSesion_equipo().getIdusuario());
			estimuladorService.insertarmantenimiento(man);
			
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
		
	}
	public void relacion_man_equ(int idequipoes) throws Exception{
		EquipoManten manequ = new EquipoManten();
		manequ.setIdequipo(idequipoes);
		manequ.setIdequipoManten(id_man);
		  relacion_man_mate(estimuladorService.insertarequipoManten(manequ));
	}
	public void relacion_man_mate(int id_manm) {
		try {
			int cantidad_mac = 0;
			for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
				MantenimientoMaterial manmate = new MantenimientoMaterial();
				Material materi = new Material();
				
				
					manmate.setIdmantenimiento(id_manm);
					manmate.setIdmaterial(materiales_utlizados.get(i).getIdmaterial());
					manmate.setCantTipo(materiales_utlizados.get(i).getCantidad());
					
					materi = estimuladorService.datosMaterial(materiales_utlizados.get(i).getIdmaterial());
					cantidad_mac = materi.getCantidad() - materiales_utlizados.get(i).getCantidad();
					materi.setCantidad(cantidad_mac);
					estimuladorService.actualizarMaterial(materi);
					
					estimuladorService.insertamantenimetomaterial(manmate);
				}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	public void registro_materia(int tipo) {
		try {
			Material mat = new Material();
			mat.setMaterial(material);
			mat.setCantidad(Integer.parseInt(cantidad));
			mat.setUnidad(unidad);
			mat.setModelo(modelo);
			
			if(tipo == 0) {
				mat.setnSerie(noserie);
				estimuladorService.insertaMaterial(mat);
			}else {
				mat.setIdmaterial(estimuladorService.encutra_noserie(noserie).getIdmaterial());
				estimuladorService.actualizarmaterial(mat);
			}

		}catch(Exception e) {}
	}
	public void actualiza_lote() {
		setLote(getLote());
		setTipo_comu(getTipo_comu());
		setImei(getImei());
		setOnda_pref(getOnda_pref());
		setGeneracion(getGeneracion());
		setEpotencial("");
	}
	public void registro_equipos(String serie_e, String tipo, String estado_est, String activo,String b_f, int regisactua) throws Exception {
			 Equipo estimulador = new Equipo();
				if(regisactua == 0) {
					estimulador.setNoserie(serie_e+";"+tipo);
					estimulador.setEstado(estado_est);
					estimulador.setTipo(b_f);
					estimulador.setDetalles(getLote()+";"+getTipo_comu()+";"+getImei());
					estimulador.setOndapredeterminada(getOnda_pref());
					if(activo.equals("true")) {
						estimulador.setEstatus("true");
					}else {
						estimulador.setEstatus("false");
					}
					estimuladorService.insertarequipo(estimulador); 
				}else {
					
					estimulador = estimuladorService.encuentra_serie(serie_e+";"+tipo);
					
					estimulador.setEstado(estado_est);
					estimulador.setTipo(b_f);
					estimulador.setDetalles(getLote()+";"+getTipo_comu()+";"+getImei());
					estimulador.setOndapredeterminada(getOnda_pref());
					if(activo.equals("true")) {
						estimulador.setEstatus("true");
					}else {
						estimulador.setEstatus("false");
					}
					//estimulador.setNoserie(serie_e+";"+getGeneracion());
					estimuladorService.actualizarequipo(estimulador);
				}
				estimuladores = estimuladorService.lista_equipos();
			
	}
	public Usuario obtenerUsuarioEnSesion_equipo(){
		System.out.println("Entro a obtenerUsuarioEnSesion");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if(!ec.isResponseCommitted()){
			try {
				Map<String, Object> session = ec.getSessionMap();
				userDTO = (Usuario)session.get("usuario");
				if(userDTO == null){
					ec.invalidateSession();
					ec.redirect("login.xhtml");
				}
			} catch (IOException e) {
				MensajeG.mostrar("No se pudo obtener al usuario y ocurrió un error al redirigir", FacesMessage.SEVERITY_FATAL);
			}
		}
		return userDTO;
	}

	   public void vista_equipo() {
			estimuladores = new ArrayList<Equipo>();
			estimuladores = estimuladorService.lista_equipos();
		   tipos_vistas =  1;
	   }
	   public void vista_mantenimiento() {
			materiales_m = new ArrayList<Material>();
			materiales_utlizados = new ArrayList<Material>();
			materiales_m = estimuladorService.lista_material();
		   tipos_vistas =  2;
		   cargar_equipoh();
	   }
	   public void vista_material() {
		   materiales = new ArrayList<Material>();
		   materiales = estimuladorService.lista_material();
		   tipos_vistas =  3;
	   }
	   public void vista_historia() {
			estimuladoresh = new ArrayList<Equipo>();
			estimuladoresh = estimuladorService.lista_equipos();
			
			selecion_esth = new Equipo();
			selecion_esth.setNoserie("");
		   tipos_vistas =  4; 
	   }
	  
	 
		
	public String getIdEstadoe() {
		return idEstadoe;
	}
	public void setIdEstadoe(String idEstadoe) {
		this.idEstadoe = idEstadoe;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getSerie_b() {
		return serie_b;
	}
	public void setSerie_b(String serie_b) {
		this.serie_b = serie_b;
	}
	public String getActi_est() {
		return acti_est;
	}

	public void setActi_est(String acti_est) {
		this.acti_est = acti_est;
	}
	
	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
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
	public Equipo getSelecion_est() {
		return selecion_est;
	}

	public void setSelecion_est(Equipo selecion_est) {
		this.selecion_est = selecion_est;
	}
	public int getTipos_vistas() {
		return tipos_vistas;
	}

	public void setTipos_vistas(int tipos_vistas) {
		this.tipos_vistas = tipos_vistas;
	}
	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public String getFallas_est() {
		return fallas_est;
	}

	public void setFallas_est(String fallas_est) {
		this.fallas_est = fallas_est;
	}

	public String getActualiza_est() {
		return actualiza_est;
	}

	public void setActualiza_est(String actualiza_est) {
		this.actualiza_est = actualiza_est;
	}
	
	public Usuario getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(Usuario userDTO) {
		this.userDTO = userDTO;
	}
	public String getBoton_f() {
		return boton_f;
	}

	public void setBoton_f(String boton_f) {
		this.boton_f = boton_f;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNoserie() {
		return noserie;
	}

	public void setNoserie(String noserie) {
		this.noserie = noserie;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
	
	public Material getSelecion_mat() {
		return selecion_mat;
	}

	public void setSelecion_mat(Material selecion_mat) {
		this.selecion_mat = selecion_mat;
	}
	public String getSerie_m() {
		return serie_m;
	}

	public void setSerie_m(String serie_m) {
		this.serie_m = serie_m;
	}
	public List<Material> getMateriales_m() {
		return materiales_m;
	}

	public void setMateriales_m(List<Material> materiales_m) {
		this.materiales_m = materiales_m;
	}
	public Material getSelecion_mat_m() {
		return selecion_mat_m;
	}

	public void setSelecion_mat_m(Material selecion_mat_m) {
		this.selecion_mat_m = selecion_mat_m;
	}
	public String getSerie_m_m() {
		return serie_m_m;
	}

	public void setSerie_m_m(String serie_m_m) {
		this.serie_m_m = serie_m_m;
	}
	
	public List<Material> getMateriales_utlizados() {
		return materiales_utlizados;
	}

	public void setMateriales_utlizados(List<Material> materiales_utlizados) {
		this.materiales_utlizados = materiales_utlizados;
	}
	
	public Material getSelecion_mat_utlizados() {
		return selecion_mat_utlizados;
	}

	public void setSelecion_mat_utlizados(Material selecion_mat_utlizados) {
		this.selecion_mat_utlizados = selecion_mat_utlizados;
	}
	public int getSe_tulizo() {
		return se_tulizo;
	}

	public void setSe_tulizo(int se_tulizo) {
		this.se_tulizo = se_tulizo;
	}
	public int getSe_tulizo_m() {
		return se_tulizo_m;
	}

	public void setSe_tulizo_m(int se_tulizo_m) {
		this.se_tulizo_m = se_tulizo_m;
	}

	public boolean isTipo_user() {
		return tipo_user;
	}

	public void setTipo_user(boolean tipo_user) {
		this.tipo_user = tipo_user;
	}

	public List<Equipo> getEstimuladoresh() {
		return estimuladoresh;
	}

	public void setEstimuladoresh(List<Equipo> estimuladoresh) {
		this.estimuladoresh = estimuladoresh;
	}

	public Equipo getSelecion_esth() {
		return selecion_esth;
	}

	public void setSelecion_esth(Equipo selecion_esth) {
		this.selecion_esth = selecion_esth;
	}

	public String getSerie_bh() {
		return serie_bh;
	}

	public void setSerie_bh(String serie_bh) {
		this.serie_bh = serie_bh;
	}

	public Mantenimiento getMan_selec() {
		return man_selec;
	}

	public void setMan_selec(Mantenimiento man_selec) {
		this.man_selec = man_selec;
	}

	public List<Mantenimiento> getHis_man() {
		return his_man;
	}

	public void setHis_man(List<Mantenimiento> his_man) {
		this.his_man = his_man;
	}

	public String getSerieh() {
		return serieh;
	}

	public void setSerieh(String serieh) {
		this.serieh = serieh;
	}

	public String getGeneracionh() {
		return generacionh;
	}

	public void setGeneracionh(String generacionh) {
		this.generacionh = generacionh;
	}

	public List<Mantenimiento> getDetallesh() {
		return detallesh;
	}

	public void setDetallesh(List<Mantenimiento> detallesh) {
		this.detallesh = detallesh;
	}

	public String getFallas_hist() {
		return fallas_hist;
	}

	public void setFallas_hist(String fallas_hist) {
		this.fallas_hist = fallas_hist;
	}
	public String getTecnico_m() {
		return tecnico_m;
	}

	public void setTecnico_m(String tecnico_m) {
		this.tecnico_m = tecnico_m;
	}

	public String getSeriem() {
		return seriem;
	}

	public void setSeriem(String seriem) {
		this.seriem = seriem;
	}

	public String getGeneracionm() {
		return generacionm;
	}

	public void setGeneracionm(String generacionm) {
		this.generacionm = generacionm;
	}

	public boolean isActi_ests() {
		return acti_ests;
	}

	public void setActi_ests(boolean acti_ests) {
		this.acti_ests = acti_ests;
	}
	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getTipo_comu() {
		return tipo_comu;
	}

	public void setTipo_comu(String tipo_comu) {
		this.tipo_comu = tipo_comu;
	}

	public String getOnda_pref() {
		return onda_pref;
	}

	public void setOnda_pref(String onda_pref) {
		this.onda_pref = onda_pref;
	}
	public String getQr_equipo() {
		return qr_equipo;
	}

	public void setQr_equipo(String qr_equipo) {
		this.qr_equipo = qr_equipo;
	}
    public String getActualiza_hist() {
		return actualiza_hist;
	}

	public void setActualiza_hist(String actualiza_hist) {
		this.actualiza_hist = actualiza_hist;
	}

	public String getElat() {
		return elat;
	}

	public void setElat(String elat) {
		this.elat = elat;
	}

	public String getElog() {
		return elog;
	}

	public void setElog(String elog) {
		this.elog = elog;
	}
	public String getHora_his() {
		return hora_his;
	}

	public void setHora_his(String hora_his) {
		this.hora_his = hora_his;
	}
	
	public String getFech_his() {
		return fech_his;
	}

	public void setFech_his(String fech_his) {
		this.fech_his = fech_his;
	}

	public String getEpotencial() {
		return epotencial;
	}

	public void setEpotencial(String epotencial) {
		this.epotencial = epotencial;
	}

	
}