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
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
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
    
	private int idTipoOnda;
	 



	@ManagedProperty("#{consultaOnda}")
	private ConsultaOnda consultaOnda;

	private LineChartModel lineModel;

	@PostConstruct
    public void init() {
		crear_grafica();
		lista_menu();
    }
     public void lista_menu() {
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
	 public void crear_grafica() {
		 
		    lineModel = new LineChartModel();
		      LineChartSeries s = new LineChartSeries();
		      lineModel.setAnimate(true);
		      s.setLabel("Population");

		      s.set(1, 0);
		      s.set(2, 0);
		      s.set(3, 0);
		      s.set(4, 0);
		      s.set(5, 0);
		      s.set(6, 0);

		      lineModel.addSeries(s);
		      lineModel.setLegendPosition("e");
		      Axis y = lineModel.getAxis(AxisType.Y);
		      y.setMin(0.5);
		      y.setMax(700);
		      y.setLabel("Millions");

		      Axis x = lineModel.getAxis(AxisType.X);
		      x.setMin(0);
		      x.setMax(7);
		      x.setTickInterval("1");
		      x.setLabel("Number of Years");
	 }
	  public LineChartModel getLineModel() {
	      return lineModel;
	  }
	  
		public void muestra_1() {
			try {
				MensajeG.mostrar("gff", FacesMessage.SEVERITY_WARN);
				
				}catch(Exception e) {
					MensajeG.mostrar(e.toString(), FacesMessage.SEVERITY_WARN);
				}
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

	public void valores_a_graficas() {
		 
	    lineModel = new LineChartModel();
	      LineChartSeries s = new LineChartSeries();
	      s.setLabel("Population");
	      double[] valores = consultaOnda.valores_de_la_onda(getIdTipoOnda());
	      for(int ii =0; ii<= valores.length-1; ii++) {
	    	  s.set(ii,valores[ii]);
	      }
	      

	      lineModel.addSeries(s);
	      lineModel.setLegendPosition("e");
	      Axis y = lineModel.getAxis(AxisType.Y);
	      //y.setMin(0.5);
	      //y.setMax(700);
	      y.setLabel("Millions");

	      Axis x = lineModel.getAxis(AxisType.X);
	      //x.setMin(0);
	      //x.setMax(7);
	      x.setTickInterval("1");
	      x.setLabel("Number of Years");
	}
}
