package com.lab.sdt.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.service.EstimuladorService;
import com.lab.sdt.util.MensajeG;



@ManagedBean
@ViewScoped
public class Controlestimuladores implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serie;
	private String generacion;
	
	private String idEstadoe;
	private String acti_est;

	private String serie_b;
	
	private String buscar = "";
	
	private List<Equipo> estimuladores;
	
	private Equipo selecion_est;
	
	private int tipos_vistas;

	private Date fecha1;

	private String fallas_est;
	
	private String actualiza_est;

	private Usuario userDTO;
	
    private Mantenimiento man;

	@ManagedProperty("#{estimuladorService}")
	public EstimuladorService estimuladorService;
	


	@PostConstruct
	public void init(){
		estimuladores = new ArrayList<Equipo>();
		setSerie_b("");
		setActi_est("false");
		estimuladores = estimuladorService.lista_equipos();
		 actualiza_e(); 
	}

	public void mantenimiento() {
		if(selecion_est!=null) {
			if(selecion_est.getNoserie().equals("")) {
				 MensajeG.mostrar("Seleccione un equipo", FacesMessage.SEVERITY_ERROR);
			}else {
			      if(fecha1!=null) {
			    	  try {
			    		  registro_mantenimiento(fecha1,fallas_est,actualiza_est); 
			    		  relacion_man_equ(selecion_est.getIdequipo());
			    		  MensajeG.mostrar("Evento registrado ", FacesMessage.SEVERITY_INFO);
			    	  }catch(Exception e) {
			    		  MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
			    		  System.out.println(e.toString());
			    	  }
			      }else {
			    	  MensajeG.mostrar("Seleccione fecha", FacesMessage.SEVERITY_ERROR);
			      }
				
			}
			
		}else {
			MensajeG.mostrar("Seleccione un equipo", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void guarda_e() {
		busca_noserie();
		actualizar_registrar(0);
	}

	public void actualiza_e() {
		selecion_est = new Equipo();
		selecion_est.setNoserie("");
		actualizar_registrar(1);
	}
	public void buscar_equipo() {
		 if(serie_b.trim().length() > 0) {
			 try {
				 Equipo estimulador = new Equipo();
				 estimuladores.clear();
				 for(int jjf=1;jjf<=6;jjf++) {
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
	public void cargar_equipo() {
		selecion_est = new Equipo();
		selecion_est.setNoserie("");
		
		estimuladores = new ArrayList<Equipo>();
		setEstimuladores(estimuladorService.lista_equipos());
	}
	public void elige( SelectEvent event) {
		String[] partes_serie = selecion_est.getNoserie().split(";");
		
		setSerie(partes_serie[0]);
		setGeneracion(partes_serie[1]);
		setIdEstadoe(selecion_est.getEstado());
		setActi_est(selecion_est.getEstatus());
	}
	public void actualizar_registrar(int tipo) {
		try {
			
			if(serie.trim().length() > 0 ){
				 if(idEstadoe.trim().length() > 0) {
					 if(generacion.trim().length() > 0) {	
							 if(tipo == 0) // registro
							 {
								 if(buscar.equals("")) {
									 registro_equipos(serie,generacion,idEstadoe,acti_est,tipo);
									 MensajeG.mostrar(serie + " Registrado", FacesMessage.SEVERITY_INFO);	
								 }else {
									 MensajeG.mostrar("Equipo ya registardo", FacesMessage.SEVERITY_WARN);
								 }
							 }else if(tipo == 1) // actualizacion
							 {
								 registro_equipos(serie,generacion,idEstadoe,acti_est,tipo);
								 MensajeG.mostrar(serie + " Actualizado", FacesMessage.SEVERITY_INFO);
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
	public void busca_noserie() {
		String res = "";
		if(serie.trim().length() > 0 && generacion.trim().length() > 0) {
			res = estimuladorService.serie_est(serie+";"+generacion);
			String[] partes_serie = res.split(";");
			buscar  = partes_serie[0];
		}
		if(res!=null) {
			String[] partes_serie = res.split(";");
			setSerie_b(partes_serie[0]);
		}	
}
	public void registro_mantenimiento(Date fechaa, String fallaa, String actuaa) throws Exception{
		man = new Mantenimiento() ;
		man.setFechamantenimiento(fechaa);
		man.setTipoactualizacion(actuaa);
		man.setFalla(fallaa);
		man.setIdusuario(obtenerUsuarioEnSesion_equipo().getIdusuario());
		estimuladorService.insertarmantenimiento(man);
	}
	public void relacion_man_equ(int idequipoes) throws Exception{
		EquipoManten manequ = new EquipoManten();
		manequ.setIdequipo(idequipoes);
		manequ.setIdequipoManten(man.getIdmantenimiento());
		estimuladorService.insertarequipoManten(manequ);
		
	}
	public void registro_equipos(String serie_e, String tipo, String estado_est, String activo, int regisactua) throws Exception {
			 Equipo estimulador = new Equipo();
				if(regisactua == 0) {
					estimulador.setNoserie(serie_e+";"+tipo);
					estimulador.setEstado(estado_est);
					if(activo.equals("true")) {
						estimulador.setEstatus("true");
					}else {
						estimulador.setEstatus("false");
					}
					estimuladorService.insertarequipo(estimulador); 
				}else {
					
					estimulador = estimuladorService.encuentra_serie(serie_e+";"+tipo);
					estimulador.setEstado(estado_est);
					if(activo.equals("true")) {
						estimulador.setEstatus("true");
					}else {
						estimulador.setEstatus("false");
					}
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
		   tipos_vistas =  1;
	   }
	   public void vista_mantenimiento() {
		   tipos_vistas =  2;
	   }
	   public void vista_material() {
		   tipos_vistas =  3;
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
}
