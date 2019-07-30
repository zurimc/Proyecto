package com.lab.sdt.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.sdt.service.ConsultaOnda;
import com.lab.sdt.service.ConsultaSOAP;
import com.lab.sdt.service.ConsultaUsuarios;
import com.lab.sdt.util.MensajeG;




@ManagedBean
@ViewScoped
public class PotencialesAccion  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public List<SelectItem> general;
	String grupos; 
	
	 
	@ManagedProperty("#{consultaOnda}")
	private ConsultaOnda consultaOnda;



	@PostConstruct
    public void init() {
		try {

			grupos = consultaOnda.todos_los_grupos_de_ondas();
		}catch(Exception e) {
			MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
		}
		
		general = new ArrayList<SelectItem>();
    	
    	 SelectItemGroup g1 = new SelectItemGroup("German Cars");
    	  SelectItem estados = new SelectItem(1,grupos);
    	  SelectItem[] a = new SelectItem[3];
    	  a[0] = estados;
    	  a[1] = estados;
    	  a[2] = estados;
    	  g1.setSelectItems(a);
    	  general.add(g1);

    }


    public String getGrupos() {
		return grupos;
	}


	public void setGrupos(String grupos) {
		this.grupos = grupos;
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

}
