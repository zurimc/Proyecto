package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.context.RequestContext;

import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.Parametro;
import com.lab.sdt.service.ConsultaOnda;
import com.lab.sdt.service.EstimuladorService;
import com.lab.sdt.util.MensajeG;


@ManagedBean
@ViewScoped
public class PotencialesAccion  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<SelectItem> general;
    
	private int idTipoOnda;
	 
	private int tipos_vistas = 0;
	
    protected List<Double> valores_g;

    private double pafrecueciaj;

    private double paamplitudj = 5;
    
    private double patiempoj;
    
    private String nombre_equipo;
    
    private String padesceipcionj;
    
    private String panombrej;
    
    private String panombrej1;
    
    private String pabnombreequipov;
    private int idequipoon = 0;
    
    private  double[] valores;
	@ManagedProperty("#{consultaOnda}")
	private ConsultaOnda consultaOnda;

	@ManagedProperty("#{estimuladorService}")
	public EstimuladorService estimuladorService;
	
	private List<Equipo> estimuladores;
	
	private Equipo selecion_estimulador;
	
	private int idequipopa=0;
	
	private int idparametros = 0;
	 
	private Parametro parametro_g;
	
	private List<Parametro> parametros_list;
	
	private Parametro seleccion_parametro;
	
	private String pabnombreparametrosv;
	
	private int idTipoOndapase = 0; 
	
	@PostConstruct
    public void init() {
		 valores_g = new ArrayList<Double>();
		 valores= new double[300];
		  parametro_g = new Parametro();
		senales();
		graficar_potencial();
		cargar_equipos();
		cargar_parametros();
		//tipos_vistas = 1;
    }
	public void padatosj() {
		padatosj1();
		agrega_valores(getPaamplitudj());
	}
	public void padatosj1() {
		setPafrecueciaj(getPafrecueciaj());
		setPatiempoj(getPatiempoj());
		setPaamplitudj(getPaamplitudj());
		setPanombrej1(getPanombrej1());
		setPanombrej(getPanombrej1());
	}
	@SuppressWarnings("deprecation")
	public void crea_modifa_parametros() {
		if(empaqueta_parametros()) {
			try {
				 if(idparametros>0) { // modifica expediente 
					 parametro_g.setIdparametro(idparametros);
					 consultaOnda.actulizar_parametro(parametro_g);
					 MensajeG.mostrar("Se Modico: "+ seleccion_parametro.getNombre() +" a: "+parametro_g.getNombre(), FacesMessage.SEVERITY_INFO);
				 }else { // crea expediente
					 consultaOnda.insertar_parametro(parametro_g);
					 MensajeG.mostrar("Se guardo: "+parametro_g.getNombre(), FacesMessage.SEVERITY_INFO);
				 } 
			}catch(Exception e) {
				 MensajeG.mostrar("Error: "+e.toString(), FacesMessage.SEVERITY_ERROR);
			}
		}
		RequestContext.getCurrentInstance().execute("PF('paParametros').hide();");
	}
	public boolean empaqueta_parametros() {
		boolean ok = false;
		 if(idequipopa>0) {
			 if(getIdTipoOnda()>0 || idTipoOndapase>0) {
				 try {
					 parametro_g.setAmplitud(String.valueOf(getPaamplitudj()));
					 parametro_g.setDescripcion(getPadesceipcionj());
					 parametro_g.setFrecuencia(String.valueOf(getPafrecueciaj()));
					 parametro_g.setIdequipo(idequipopa);
					 if(getIdTipoOnda()<=0) {
						 parametro_g.setIdonda(idTipoOndapase);
					 }else {
						 parametro_g.setIdonda(consultaOnda.entrega_onda(getIdTipoOnda())); 
					 }
					 parametro_g.setNombre(getPanombrej());
					 parametro_g.setTiempo(String.valueOf(getPatiempoj()));
				 }catch(Exception e) {
					 MensajeG.mostrar(" Error: "+e.toString(), FacesMessage.SEVERITY_ERROR); 
				 }
				 
				 ok = true;
			 }else {
				 MensajeG.mostrar("Seleccione un Potencial ", FacesMessage.SEVERITY_ERROR);
			 }
		 }else {
			 MensajeG.mostrar("Seleccione Equipo", FacesMessage.SEVERITY_ERROR);
		 }
		return ok;
	}
	@SuppressWarnings("deprecation")
	public void asignacion_equipo() {
		idequipopa = selecion_estimulador.getIdequipo();
			setNombre_equipo(convertirserie(selecion_estimulador.getNoserie())+"  "+convertirgeneracion(selecion_estimulador.getNoserie()));
			RequestContext.getCurrentInstance().execute("PF('patablaequipo').hide();");

	}
    @SuppressWarnings("deprecation")
    public void parametro_elegido_ajax() {
    	try {
    	idparametros = seleccion_parametro.getIdparametro();
    	Equipo equipo_se = estimuladorService.encuentra_por_id(seleccion_parametro.getIdequipo());
    	setPaamplitudj(Double.parseDouble(seleccion_parametro.getAmplitud()));
    	
    	setPafrecueciaj(Double.parseDouble(seleccion_parametro.getFrecuencia()));
    	idequipopa = seleccion_parametro.getIdequipo();
    	idTipoOndapase = seleccion_parametro.getIdonda();
    	setPanombrej(seleccion_parametro.getNombre());
    	setPatiempoj(Double.parseDouble(seleccion_parametro.getTiempo()));
    	setNombre_equipo(convertirserie(equipo_se.getNoserie())+"  "+convertirgeneracion(equipo_se.getNoserie()));
    	 idTipoOnda = consultaOnda.entrega_num_onda(idTipoOndapase);
    	setPadesceipcionj(seleccion_parametro.getDescripcion());
    	setPanombrej1(seleccion_parametro.getNombre());
    	carga_valores1(idTipoOndapase);
   	 	agrega_valores(getPaamplitudj());

    	}catch(Exception e) {
			 MensajeG.mostrar("No se pudo cargar el parametro", FacesMessage.SEVERITY_WARN);
		 }
    	RequestContext.getCurrentInstance().execute("PF('paParametrosver').hide();");
    }
	public void buscar_parametros() {
		if(pabnombreparametrosv.trim().length()>0) {
			 try {
					parametros_list = new ArrayList<Parametro>();
					parametros_list.clear();
					parametros_list = consultaOnda.parametros_por_nombre(pabnombreparametrosv);
				 
			 }catch(Exception e) {
				 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			 }
		}else {
			 MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		 }
	}
	public void buscar_equipo() {
		if(pabnombreequipov.trim().length() > 0) {
			 try {
				 estimuladores = new ArrayList<Equipo>();
				 Equipo estimulador = new Equipo();
				 estimuladores.clear();
				 for(int jjf=1;jjf<=6;jjf++) // tipos de generaciones
				 {
					 estimulador =  estimuladorService.encuentra_serie(pabnombreequipov+";"+jjf);
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
	public void cargar_equipos() {
		estimuladores = new ArrayList<Equipo>();
		estimuladores.clear();
		try {
			estimuladores = estimuladorService.lista_equipos();		
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
	public String convertirserie(String serie){
		String[] partes_serie = serie.split(";");
		return partes_serie[0];
	}
	public String convertirgeneracion(String serie){
		String[] partes_serie = serie.split(";");
		return "G. "+partes_serie[1];
	}
	public void vista_senales(int tipo) {
		tipos_vistas = tipo;	
	}
     public void senales() {
    		String grupos; 
    		String tipos_onda; 
    	 try {
    		 general = new ArrayList<SelectItem>();
    		 grupos = consultaOnda.todos_los_grupos_de_ondas();
    	     String[] grupos_totales = grupos.split(":");
    	     for(int ii = 0; ii<= grupos_totales.length-1; ii++) {
    	    	 String[] partes_grupo = grupos_totales[ii].split("/");
            	 SelectItemGroup g1 = new SelectItemGroup(partes_grupo[1]);
            	 
            	 tipos_onda =consultaOnda.tipos_de_ondas(partes_grupo[0]);
            	 String[] numero_de_onda = tipos_onda.split(":");
           	     SelectItem[] a = new SelectItem[numero_de_onda.length];
           	    
            	 for(int jj = 0; jj<= numero_de_onda.length-1; jj++) {
            		 String[] partes_onda = numero_de_onda[jj].split("/");
            		 int id_tipo_onda =0;
            		  try {
            			  id_tipo_onda = Integer.parseInt(partes_onda[0]);
            		  }catch(Exception e) {}
                  	  SelectItem ondas = new SelectItem(id_tipo_onda,partes_onda[1]);
                   	  a[jj] = ondas;
            	 }
            	     
           	  g1.setSelectItems(a);
           	  general.add(g1);
    	     }

    	}catch(Exception e) {
    			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
    	}
    	 
     }
     private void carga_valores1(int idOnda) {
    	 double[] val = consultaOnda.valores_onda(idOnda);
    	 
    	 for(int ii =0; ii<= val.length-1; ii++) {
    		 valores[ii] = val[ii];
    	 }
     }
     private void carga_valores() {
    	 double[] val = consultaOnda.valores_de_la_onda(idTipoOnda);
    	 
    	 for(int ii =0; ii<= val.length-1; ii++) {
    		 valores[ii] = val[ii];
    	 }
     }
     private void  agrega_valores(double paamplitudj1) {
    	 valores_g.clear();
    	 setPaamplitudj(paamplitudj1);
     	 for(int ii =0; ii<= 260; ii++) {
     		 valores_g.add((paamplitudj1*(valores[ii]-130)/(29)/5));
     	 } 
     }
     public void graficar_potencial() {
    	 carga_valores();
    	 agrega_valores(getPaamplitudj());
     }
 	@SuppressWarnings("deprecation")
 	public void asignacion_parametros_onda() {
 		idequipoon = seleccion_parametro.getIdparametro();
 		setPabnombreparametrosv(seleccion_parametro.getNombre());
 		RequestContext.getCurrentInstance().execute("PF('ptablaequipo').hide();");
 	}
     public void cargar_parametros_onda() {
 		parametros_list = new ArrayList<Parametro>();
 		parametros_list.clear();
 		try {
 			parametros_list = consultaOnda.parametros_equipo(idequipoon);
 		}catch(Exception e) {

 		}
 	}
 	public void asignacion_equipoondas() {
 		idequipoon = selecion_estimulador.getIdequipo();
		cargar_parametros_onda();
		setPabnombreequipov(convertirserie(selecion_estimulador.getNoserie())+"  "+convertirgeneracion(selecion_estimulador.getNoserie()));
			

	}
	public List<SelectItem> getGeneral() {
		return general;
	}

	public void setGeneral(List<SelectItem> general) {
		this.general = general;
	}


	public ConsultaOnda getConsultaOnda() {
		return consultaOnda;
	}


	public void setConsultaOnda(ConsultaOnda consultaOnda) {
		this.consultaOnda = consultaOnda;
	}
	
	public int getIdTipoOnda() {
		return idTipoOnda;
	}
	public void setIdTipoOnda(int idTipoOnda) {
		this.idTipoOnda = idTipoOnda;
	}


	public List<Double> getValores_g() {
		return valores_g;
	}
	public void setValores_g(List<Double> valores_g) {
		this.valores_g = valores_g;
	}
	public int getTipos_vistas() {
		return tipos_vistas;
	}
	public void setTipos_vistas(int tipos_vistas) {
		this.tipos_vistas = tipos_vistas;
	}
	public double getPafrecueciaj() {
		return pafrecueciaj;
	}
	public void setPafrecueciaj(double pafrecueciaj) {
		this.pafrecueciaj = pafrecueciaj;
	}
	public double getPaamplitudj() {
		return paamplitudj;
	}
	public void setPaamplitudj(double paamplitudj) {
		this.paamplitudj = paamplitudj;
	}
	public double getPatiempoj() {
		return patiempoj;
	}
	public void setPatiempoj(double patiempoj) {
		this.patiempoj = patiempoj;
	}
	public String getNombre_equipo() {
		return nombre_equipo;
	}
	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}
	public String getPadesceipcionj() {
		return padesceipcionj;
	}
	public void setPadesceipcionj(String padesceipcionj) {
		this.padesceipcionj = padesceipcionj;
	}
	public String getPanombrej() {
		return panombrej;
	}
	public void setPanombrej(String panombrej) {
		this.panombrej = panombrej;
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
	public String getPabnombreequipov() {
		return pabnombreequipov;
	}
	public void setPabnombreequipov(String pabnombreequipov) {
		this.pabnombreequipov = pabnombreequipov;
	}
	public String getPanombrej1() {
		return panombrej1;
	}
	public void setPanombrej1(String panombrej1) {
		this.panombrej1 = panombrej1;
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
	public String getPabnombreparametrosv() {
		return pabnombreparametrosv;
	}
	public void setPabnombreparametrosv(String pabnombreparametrosv) {
		this.pabnombreparametrosv = pabnombreparametrosv;
	}
	public int getIdequipopa() {
		return idequipopa;
	}
	public void setIdequipopa(int idequipopa) {
		this.idequipopa = idequipopa;
	}
	public int getIdequipoon() {
		return idequipoon;
	}
	public void setIdequipoon(int idequipoon) {
		this.idequipoon = idequipoon;
	}
	public int getIdparametros() {
		return idparametros;
	}
	public void setIdparametros(int idparametros) {
		this.idparametros = idparametros;
	}
	public Parametro getParametro_g() {
		return parametro_g;
	}
	public void setParametro_g(Parametro parametro_g) {
		this.parametro_g = parametro_g;
	}
	public int getIdTipoOndapase() {
		return idTipoOndapase;
	}
	public void setIdTipoOndapase(int idTipoOndapase) {
		this.idTipoOndapase = idTipoOndapase;
	}

	
}
