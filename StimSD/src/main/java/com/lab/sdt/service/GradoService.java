package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EspecialidadMapper;
import com.lab.sdt.dao.GradoMapper;
import com.lab.sdt.model.Especialidad;
import com.lab.sdt.model.EspecialidadExample;
import com.lab.sdt.model.EstadoExample;
import com.lab.sdt.model.Grado;
import com.lab.sdt.model.GradoExample;
import com.lab.sdt.model.Tipousuario;

@Service
@Transactional
public class GradoService {

	
	@Autowired
	private GradoMapper gradoMapper;
	
	@Autowired
	private EspecialidadMapper especialidadMapper;
	
	public List<SelectItem> lista_grado;
	public List<Grado> grados1;
	
	public List<SelectItem> lista_especialidad;
	public List<Especialidad> especialidad1;
	
	
	public List<SelectItem> getLista_grado() {
		this.lista_grado= new ArrayList<SelectItem>();
		GradoExample exg = new GradoExample();
		
		for(int ii = 1; ii<= gradoMapper.countByExample(exg); ii++) {
			
			SelectItem grados1 = new SelectItem(ii,gradoMapper.selectByPrimaryKey(ii).getGrado());
			this.lista_grado.add(grados1);
			
		}
	return lista_grado;
	}
	public void setLista_grado(List<SelectItem> lista_grado) {
		this.lista_grado = lista_grado;
	}
	
	
	
	public List<SelectItem> getLista_especialidad() {
		
		this.lista_especialidad= new ArrayList<SelectItem>();
		EspecialidadExample exE = new EspecialidadExample();
		
		for(int ii = 1; ii<= especialidadMapper.countByExample(exE); ii++) {
			
			SelectItem especialidad1 = new SelectItem(ii,especialidadMapper.selectByPrimaryKey(ii).getEspecialidad());
			this.lista_especialidad.add(especialidad1);
			
		}
		return lista_especialidad;
	}
	public void setLista_especialidad(List<SelectItem> lista_especialidad) {
		this.lista_especialidad = lista_especialidad;
	}
	
	
	
	
}
