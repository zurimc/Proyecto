package com.lab.sdt.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajeG {
	public static void mostrar(String mensaje, FacesMessage.Severity tipo){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(tipo, mensaje, ""));
	}
}
