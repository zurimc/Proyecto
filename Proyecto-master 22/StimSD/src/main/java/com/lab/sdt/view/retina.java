package com.lab.sdt.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.Usuario;

@ManagedBean
@ViewScoped
public class retina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int AIzq;
	public int ADer;
	public int BIzq;
	public int BDer;
	public Date FechaElecto;
	public String pacienteE;
	public String padecimientoE;
	public String medicoE;
	public String equipoE;
	public String potencialE;
	public String TEstudio;
	public int IdExpedienteE;
	private double amplitudE = 5;
	protected List<Double> valores_Electo;
	private List<Usuario> pacientesE;
	private Usuario seleccion_pacienteE;
	private Expediente seleccion_expedienteE;
	
	@PostConstruct
    public void init() {}
	
	
	
	public int getAIzq() {
		return AIzq;
	}
	public void setAIzq(int aIzq) {
		AIzq = aIzq;
	}
	public int getADer() {
		return ADer;
	}
	public void setADer(int aDer) {
		ADer = aDer;
	}
	public int getBIzq() {
		return BIzq;
	}
	public void setBIzq(int bIzq) {
		BIzq = bIzq;
	}
	public int getBDer() {
		return BDer;
	}
	public void setBDer(int bDer) {
		BDer = bDer;
	}
	public Date getFechaElecto() {
		return FechaElecto;
	}
	public void setFechaElecto(Date fechaElecto) {
		FechaElecto = fechaElecto;
	}
	public String getPacienteE() {
		return pacienteE;
	}
	public void setPacienteE(String pacienteE) {
		this.pacienteE = pacienteE;
	}
	public String getPadecimientoE() {
		return padecimientoE;
	}
	public void setPadecimientoE(String padecimientoE) {
		this.padecimientoE = padecimientoE;
	}
	public String getMedicoE() {
		return medicoE;
	}
	public void setMedicoE(String medicoE) {
		this.medicoE = medicoE;
	}
	public String getEquipoE() {
		return equipoE;
	}
	public void setEquipoE(String equipoE) {
		this.equipoE = equipoE;
	}
	public String getPotencialE() {
		return potencialE;
	}
	public void setPotencialE(String potencialE) {
		this.potencialE = potencialE;
	}
	
	public String getTEstudio() {
		return TEstudio;
	}
	public void setTEstudio(String tEstudio) {
		TEstudio = tEstudio;
	}
	public int getIdExpedienteE() {
		return IdExpedienteE;
	}
	public void setIdExpedienteE(int idExpedienteE) {
		IdExpedienteE = idExpedienteE;
	}
	public List<Double> getValores_Electo() {
		return valores_Electo;
	}
	public void setValores_Electo(List<Double> valores_Electo) {
		this.valores_Electo = valores_Electo;
	}

	public double getAmplitudE() {
		return amplitudE;
	}

	public void setAmplitudE(double amplitudE) {
		this.amplitudE = amplitudE;
	}

	public List<Usuario> getPacientesE() {
		return pacientesE;
	}

	public void setPacientesE(List<Usuario> pacientesE) {
		this.pacientesE = pacientesE;
	}

	public Usuario getSeleccion_pacienteE() {
		return seleccion_pacienteE;
	}

	public void setSeleccion_pacienteE(Usuario seleccion_pacienteE) {
		this.seleccion_pacienteE = seleccion_pacienteE;
	}

	public Expediente getSeleccion_expedienteE() {
		return seleccion_expedienteE;
	}

	public void setSeleccion_expedienteE(Expediente seleccion_expedienteE) {
		this.seleccion_expedienteE = seleccion_expedienteE;
	}
	
	
	
}
