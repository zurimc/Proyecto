package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EquipoMantenMapper;
import com.lab.sdt.dao.EquipoMapper;
import com.lab.sdt.dao.MantenimientoMapper;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.EquipoExample;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.MantenimientoExample;



@Service
@Transactional

public class EstimuladorService {
	@Autowired
	private EquipoMapper equipoMapper;
	
	@Autowired
	private MantenimientoMapper mantenimientoMapper;

	@Autowired
	private EquipoMantenMapper equipoMantenMapper;
	
	public void insertarequipoManten(EquipoManten manequ) {
		 List<Mantenimiento> list_man = new ArrayList<Mantenimiento>();
		 MantenimientoExample man_ex = new  MantenimientoExample();
		 list_man = mantenimientoMapper.selectByExample(man_ex);
		 manequ.setIdmantenimiento(list_man.get(list_man.size()-1).getIdmantenimiento());
		equipoMantenMapper.insert(manequ);
	}
	
	public void insertarmantenimiento(Mantenimiento mans) {
		mantenimientoMapper.insert(mans);
	}
	public void insertarequipo(Equipo equipo_est)throws Exception{
		equipoMapper.insert(equipo_est);
	}
	public Equipo encuentra_serie(String noserie) {
		Equipo estimulador = new Equipo();
		estimulador = equipoMapper.selectBySerie(noserie);
		return estimulador;
	}
	public String serie_est (String noserie) {
		try {
			return equipoMapper.selectBySerie(noserie).getNoserie();
		}catch(Exception e) {
			return "";
		}
	}
	public void actualizarequipo(Equipo equipo_est)throws Exception{
		equipoMapper.updateByPrimaryKeySelective(equipo_est);
	}
	
	public List<Equipo> lista_equipos() {
        List<Equipo> list_est = new ArrayList<Equipo>();
        EquipoExample equipoEx = new EquipoExample();
        list_est = equipoMapper.selectByExample(equipoEx);
        return list_est;
    }
	
}
