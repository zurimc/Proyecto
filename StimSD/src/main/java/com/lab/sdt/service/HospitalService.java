package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.HospitalMapper;
import com.lab.sdt.model.HospitalExample;

import com.lab.sdt.model.Hospital;


@Service
@Transactional
public class HospitalService {

	@Autowired
	private HospitalMapper hospitalMapper;
	
	public List<SelectItem> lista_hospital;
	public List<Hospital> hospitales1;
	
	
	
	
	
	
	public List<SelectItem> getLista_hospital() {
		
		this.lista_hospital= new ArrayList<SelectItem>();
		HospitalExample exh = new HospitalExample();
		
		for(int ii = 1; ii<= hospitalMapper.countByExample(exh); ii++) {
			
			SelectItem hospitales1 = new SelectItem(ii,hospitalMapper.selectByPrimaryKey(ii).getHospital());
			this.lista_hospital.add(hospitales1);
			
		}
		return lista_hospital;
	}
	public void setLista_hospital(List<SelectItem> lista_hospital) {
		this.lista_hospital = lista_hospital;
	}
	
	//buscar hospitales
		public Hospital encuentra_hospital(String hospital) {
			Hospital hospitala = new Hospital();
			
			hospitala = hospitalMapper.selectByHospital(hospital).get(0);
			return hospitala;
		}
		
		public void actualizar_registro(Hospital h) {
			hospitalMapper.updateByPrimaryKey(h);
		}
		public String actualizarh (String actualizarh) {
			String r= null;
			try {
				r= encuentra_hospital(actualizarh).getHospital();
			}catch(Exception e) {
				r= null;
			}
			return r;
		}
		public List<Hospital> lista_hospital() {
	        List<Hospital> list_hos = new ArrayList<Hospital>();
	        HospitalExample HospitalEx = new HospitalExample();
	        list_hos = hospitalMapper.selectByExample(HospitalEx);
	        return list_hos;
	    }
		
		//REGISTRAR UN HOSPITAL
		
		
			public void insertarHospital(Hospital hospital)throws Exception{
				hospitalMapper.insert(hospital);
			}
			
			public Hospital obtenerHospital(String hospital) {
				List<Hospital> contenedor_hospital = hospitalMapper.selectByHospital(hospital);
				return contenedor_hospital.get(0);
			}
			
		public String registro_hospital(String hospital) {
			String res= null;
			try {
				res = obtenerHospital(hospital).getHospital();
			}catch(Exception e) {
				res=null;
			}
			return res;
		}
	
}