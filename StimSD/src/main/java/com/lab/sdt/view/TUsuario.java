package com.lab.sdt.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
public class TUsuario {
	private String tipoUsuario;  
    private List<SelectItem> tipoUsuarios;


@PostConstruct
public void init() {
	//cars
    SelectItemGroup g1 = new SelectItemGroup("Tipo Usuarios");
    g1.setSelectItems(new SelectItem[] {new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});
     
    
     
    tipoUsuarios = new ArrayList<SelectItem>();
    tipoUsuarios.add(g1);
    
}
}