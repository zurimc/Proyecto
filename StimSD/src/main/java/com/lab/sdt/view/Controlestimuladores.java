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
	private String generacion;
	
	private String idEstadoe;
	private String acti_est;

	private String serie_b;
	
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
	
	private String[] estatus_mante = new String[200];

	private int se_tulizo;
	
	private int se_tulizo_m = 0;
	private int id_man = 0;

	private List<Equipo> estimuladores;
	
	private List<Material> materiales;
	
	private List<Material> materiales_m;
	
	private List<Material> materiales_utlizados;

	private Equipo selecion_est;
	
	private Material selecion_mat;
	
	private Material selecion_mat_m;
	
	private Material selecion_mat_utlizados;

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
	int cantidad_util = 0;
	public void material_ocupado(){
		se_tulizo_m = selecion_mat_m.getIdmaterial();
		
		cantidad_util = estimuladorService.datosMaterial(selecion_mat_m.getIdmaterial()).getCantidad();
		serie_m_m = selecion_mat_m.getMaterial();
	}
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
	public void elige( SelectEvent event) {
		String[] partes_serie = selecion_est.getNoserie().split(";");
		
		setSerie(partes_serie[0]);
		setGeneracion(partes_serie[1]);
		setIdEstadoe(selecion_est.getEstado());
		setActi_est(selecion_est.getEstatus());
		setBoton_f(selecion_est.getTipo());
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
			
			if(serie.trim().length() > 0 ){
				 if(idEstadoe.trim().length() > 0) {
					 if(generacion.trim().length() > 0) {	
							 if(tipo == 0) // registro
							 {
								 if(buscar.equals("")) {
									 registro_equipos(serie,generacion,idEstadoe,acti_est,boton_f,tipo);
									 MensajeG.mostrar(serie + " Registrado", FacesMessage.SEVERITY_INFO);	
								 }else {
									 MensajeG.mostrar("Equipo ya registardo", FacesMessage.SEVERITY_WARN);
								 }
							 }else if(tipo == 1) // actualizacion
							 {
								 registro_equipos(serie,generacion,idEstadoe,acti_est,boton_f,tipo);
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
	public void registro_mantenimiento(Date fechaa, String fallaa, String actuaa){
		try {
			String mate_estatus = "";
			//for(int i = 0;i<=materiales_utlizados.size()-1;i++) {
		//		mate_estatus =  mate_estatus + estatus_mante[i]+";";
		//	}
			man = new Mantenimiento() ;
			man.setFechamantenimiento(fechaa);
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
	public void registro_equipos(String serie_e, String tipo, String estado_est, String activo,String b_f, int regisactua) throws Exception {
			 Equipo estimulador = new Equipo();
				if(regisactua == 0) {
					estimulador.setNoserie(serie_e+";"+tipo);
					estimulador.setEstado(estado_est);
					estimulador.setTipo(b_f);
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
			estimuladores = new ArrayList<Equipo>();
			estimuladores = estimuladorService.lista_equipos();
		   tipos_vistas =  1;
	   }
	   public void vista_mantenimiento() {
			materiales_m = new ArrayList<Material>();
			materiales_utlizados = new ArrayList<Material>();
			materiales_m = estimuladorService.lista_material();
		   tipos_vistas =  2;
	   }
	   public void vista_material() {
		   materiales = new ArrayList<Material>();
		   materiales = estimuladorService.lista_material();
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

}
