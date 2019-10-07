package com.lab.sdt.view;




import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import net.bootsfaces.component.canvas.Drawing;





@ManagedBean
@ViewScoped

public class GFuncionesView extends Drawing {
	
	public boolean offset;
	public boolean coordenadas;
	public boolean recta;
	public boolean seno;
	public boolean senoinverso;
	private UploadedFile cargaImagen;

	
	public void dibujar () {
		
		//g.setColor(Color.red);
		//g.fillRect(25, 25, 100, 30);
		
	}
	    
	   
	 
	  
	public boolean isOffset() {
		return offset;
	}
	public void setOffset(boolean offset) {
		this.offset = offset;
	}
	public boolean isCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(boolean coordenadas) {
		this.coordenadas = coordenadas;
	}
	public boolean isRecta() {
		return recta;
	}
	public void setRecta(boolean recta) {
		this.recta = recta;
	}
	public boolean isSeno() {
		return seno;
	}
	public void setSeno(boolean seno) {
		this.seno = seno;
	}
	public boolean isSenoinverso() {
		return senoinverso;
	}
	public void setSenoinverso(boolean senoinverso) {
		this.senoinverso = senoinverso;
	}
	  
	  
}
/*public class GFuncionesView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public boolean offset;
	public boolean coordenadas;
	public boolean recta;
	public boolean seno;
	public boolean senoinverso;
	private UploadedFile cargaImagen;


 public  class micanvas extends Canvas{
private double radio = 0.0;
private double diametro;
public  void dibujarCirculo() {
	setSize(470,570);
	setVisible(true);
	
}
public void paint (Graphics g) {
	Graphics2D circulo = (Graphics2D)g;
	circulo = setStroke(new BasicStroke(10.f));
}
 public void main(String[] args) {
	new dibujarCirculo();
 }
	
 }

	@PostConstruct
    public void init() {
	//dibujar();
	}
	
	public void opciones() {
		
	}

	public void upload() {
        if(cargaImagen != null) {
            FacesMessage message = new FacesMessage("Se subio correctamente", cargaImagen.getFileName() + " :)");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Exitoso", event.getFile().getFileName() + " :)");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	public boolean isOffset() {
		return offset;
	}

	public void setOffset(boolean offset) {
		this.offset = offset;
	}

	public boolean isCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(boolean coordenadas) {
		this.coordenadas = coordenadas;
	}

	public boolean isRecta() {
		return recta;
	}

	public void setRecta(boolean recta) {
		this.recta = recta;
	}

	public boolean isSeno() {
		return seno;
	}

	public void setSeno(boolean seno) {
		this.seno = seno;
	}

	public boolean isSenoinverso() {
		return senoinverso;
	}

	public void setSenoinverso(boolean senoinverso) {
		this.senoinverso = senoinverso;
	}

	public UploadedFile getCargaImagen() {
		return cargaImagen;
	}

	public void setCargaImagen(UploadedFile cargaImagen) {
		this.cargaImagen = cargaImagen;
	}

	
	

}*/
