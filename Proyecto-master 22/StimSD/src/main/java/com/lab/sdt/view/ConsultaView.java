package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteConsulta;

import com.lab.sdt.model.Presionintraocular;
import com.lab.sdt.service.ConsultaService;
import com.lab.sdt.util.MensajeG;

@ManagedBean
@ViewScoped
public class ConsultaView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{consultaService}")
	public ConsultaService consultaService;
	
	
	public int idExpediente;
	private int idExpeConsul;
	public String peso;
	public String p_mayor;
	public String p_menor;
	public String temperatura;
	public String altura;
	public String masa_corp;
	public String grasa_corp;
	public String descripcion;
	public String presionI;
	public String presionD;
	public Date fechapresion;
	
	public Date fechaConsulta;
	private String expe_m;
	
	private List<Expediente> exp_id;
	private Expediente seleccion_expediente;

	private int idexp=0;
	private int idexpedienteC;
	private ExpedienteConsulta exp_Consul;
	
	public void setIdexpedienteC(int idexpedienteC) {
		this.idexpedienteC = idexpedienteC;
	}
	 //asignacion de expediente
		@SuppressWarnings("deprecation")
		public void asignacion_expediente() {
			idexp = seleccion_expediente.getIdexpediente();
			setIdexpedienteC((seleccion_expediente.getIdexpediente()));
			
				RequestContext.getCurrentInstance().execute("PF('patablaexpediente').hide();");

		}
		
		/*insertar en la base y modificar*/
		@SuppressWarnings("deprecation")
		public void crea_modi_consulta() {
			if(empaqueta_consulta()) {
				try {
					 if(idExpeConsul>0) { // modifica expediente 
						 exp_Consul.setIdexpeconsul(idExpeConsul);
						 consultaService.actulizar_consulta(exp_Consul);
						 MensajeG.mostrar("Se Modico: "+ seleccion_expediente.getIdexpediente() +" a: "+exp_Consul.getIdexpediente(), FacesMessage.SEVERITY_INFO);
					 }else { // crea expediente
						 consultaService.insertarConsulta(exp_Consul);
						 MensajeG.mostrar("Se guardo: "+exp_Consul.getIdexpediente(), FacesMessage.SEVERITY_INFO);
					 } 
				}catch(Exception e) {
					 MensajeG.mostrar("Error: "+e.toString(), FacesMessage.SEVERITY_ERROR);
				}
			}
			RequestContext.getCurrentInstance().execute("PF('paParametros').hide();");
		}
		public boolean empaqueta_consulta() {
			boolean ok = false;
			 if(idexp>0) {
				
					 try {
						
						 exp_Consul.setFechaconsulta(fechaConsulta);
						 exp_Consul.setDescripcion(String.valueOf(getDescripcion()));
						 exp_Consul.setPeso(peso);
						 exp_Consul.setpMayor(p_mayor);
						 exp_Consul.setpMenor(p_menor);
						 exp_Consul.setTemperatura(temperatura);
						 exp_Consul.setAltura(altura);
						 exp_Consul.setMasaCorp(masa_corp);
						 exp_Consul.setGrasaCorp(grasa_corp);
						 exp_Consul.setIdexpediente(idexp);
						
						 
					 }catch(Exception e) {
						 MensajeG.mostrar(" Error: "+e.toString(), FacesMessage.SEVERITY_ERROR); 
					 }
					 
					 ok = true;
				 
			 }else {
				 MensajeG.mostrar("Seleccione Equipo", FacesMessage.SEVERITY_ERROR);
			 }
			return ok;
		}	        
	 
//ZURI FIN
	
//insertar datos de hospital
	
  public void registroConsulta() {
        
        ExpedienteConsulta pruebac = new ExpedienteConsulta();
        pruebac.setPeso(peso);
        pruebac.setpMayor(p_mayor);
        pruebac.setpMenor(p_menor);
        pruebac.setTemperatura(temperatura);
        pruebac.setAltura(altura);
        pruebac.setMasaCorp(masa_corp);
        pruebac.setGrasaCorp(grasa_corp);
        pruebac.setDescripcion(descripcion);
        pruebac.setFechaconsulta(new Date());
        try {
    		if(consultaService.registro_consulta(getFechaConsulta()) == null){
    			MensajeG.mostrar("Registro exitoso", FacesMessage.SEVERITY_INFO);
    			consultaService.registroConsulta(pruebac);
    		
    			

    		}else {
    			 MensajeG.mostrar("ya existe un usuario con esta cuenta: "+consultaService.registro_consulta(getFechaConsulta()), FacesMessage.SEVERITY_WARN);
    		}
    		
    		
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
    	}
  
   	  
        
    }
  public void registroPresionO() {
      
      Presionintraocular pres = new Presionintraocular();
      
      
      pres.setpIzq(presionI);
      pres.setpDer(presionD);
      pres.setFecha(new Date());
      
      try {
  		if(consultaService.registro_presion(getFechapresion()) == null){
  			MensajeG.mostrar("Registro exitoso", FacesMessage.SEVERITY_INFO);
  			consultaService.registroPresion(pres);
  		
  			

  		}else {
  			 MensajeG.mostrar("ya existe el registro: "+consultaService.registro_presion(getFechapresion()), FacesMessage.SEVERITY_WARN);
  		}
  		
  		
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_ERROR);
  	}

 	  
      
  }
	
  public void guarda_actualiza_datos() {
 setPeso(getPeso());
 setP_mayor(getP_mayor());
 setP_menor(getP_menor());
 setTemperatura(getTemperatura());
 setAltura(getAltura());
 setMasa_corp(getMasa_corp());
 setGrasa_corp(getGrasa_corp());
 setDescripcion(getDescripcion());
 setFechaConsulta(new Date());
  }
  
  public void guarda_presion() {
 
 setPresionI(getPresionI());
 setPresionD(getPresionD());
 setFechapresion(getFechapresion());
  }
  public void cargar_expedientes() {
	exp_id = consultaService.lista_exp();
		expe_m = "";
	}  
//buscador del expediente
  public void buscar_expediente() {
		if(expe_m.trim().length()>0) {
			try {
				exp_id.clear();
				exp_id = consultaService.encuentra_expediente(expe_m);
			}catch(Exception e) {
				MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
			}
		}else {
			MensajeG.mostrar("Sin resultados", FacesMessage.SEVERITY_INFO);
		}
	}
public ConsultaService getConsultaService() {
	return consultaService;
}
public void setConsultaService(ConsultaService consultaService) {
	this.consultaService = consultaService;
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
public Expediente getSeleccion_expediente() {
	return seleccion_expediente;
}
public void setSeleccion_expediente(Expediente seleccion_expediente) {
	this.seleccion_expediente = seleccion_expediente;
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
  



}
