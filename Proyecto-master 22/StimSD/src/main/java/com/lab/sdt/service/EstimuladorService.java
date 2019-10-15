package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EquipoMantenMapper;
import com.lab.sdt.dao.EquipoMapper;
import com.lab.sdt.dao.MantenimientoMapper;
import com.lab.sdt.dao.MantenimientoMaterialMapper;
import com.lab.sdt.dao.MaterialMapper;
import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.EquipoExample;
import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.MantenimientoExample;
import com.lab.sdt.model.MantenimientoMaterial;
import com.lab.sdt.model.Material;
import com.lab.sdt.model.MaterialExample;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.model.MantenimientoExample.Criteria;


@Service
@Transactional

public class EstimuladorService {
	
	@Autowired
	private EquipoMapper equipoMapper;
	
	@Autowired
	private MantenimientoMapper mantenimientoMapper;

	@Autowired
	private EquipoMantenMapper equipoMantenMapper;
	
	@Autowired
	private MaterialMapper materialMapper;
	
	@Autowired
	private MantenimientoMaterialMapper mantenimientoMaterialMapper;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public void insertamantenimetomaterial(MantenimientoMaterial manmate) {
		mantenimientoMaterialMapper.insert(manmate);
	}
	public void insertaMaterial(Material mat) {
		materialMapper.insert(mat);
	}
	/*zuri inicio*/
	private final int FECHA_INICIO = 1;
	private final int FECHA_FIN = 2;
	
	
	public List<Mantenimiento> por_fecha(int idequipo, Date fecha_I, Date fecha_F){
		List<Mantenimiento> res = new ArrayList<Mantenimiento>();
		List<EquipoManten> lista_man = lista_mante_equi(idequipo);
		for(int i = 0;i<=lista_man.size()-1;i++) {
			try {
			MantenimientoExample exMan = new MantenimientoExample();
			Criteria criteria = exMan.createCriteria();
			criteria.andFechamantenimientoBetween(generarFecha(fecha_I, FECHA_INICIO), generarFecha(fecha_F, FECHA_FIN));
			criteria.andIdmantenimientoEqualTo(lista_man.get(i).getIdmantenimiento());
			List<Mantenimiento> man = new ArrayList<Mantenimiento>();
			man = mantenimientoMapper.selectByExample(exMan);
			res.add(man.get(man.size() -1));
			}catch(Exception e) {
				
			}
	
		}
		
		return res;
	}
	/*zuri fin */
	public List<Mantenimiento> ver_historico(int idequipo){
		List<Mantenimiento> res = new ArrayList<Mantenimiento>();
		List<EquipoManten> lista_man = lista_mante_equi(idequipo);
		for(int i = 0;i<=lista_man.size()-1;i++) {
			res.add(mantenimientoMapper.selectByPrimaryKey(lista_man.get(i).getIdmantenimiento()));
		}
		//res.add(mantenimientoMapper.selectByPrimaryKey(1));
		return res;
	}
	public List<EquipoManten> lista_mante_equi(int idequipo){
		
		return equipoMantenMapper.selectByEquipo(idequipo);
	}
	public int insertarequipoManten(EquipoManten manequ) {
		 List<Mantenimiento> list_man = new ArrayList<Mantenimiento>();
		 MantenimientoExample man_ex = new  MantenimientoExample();
		 list_man = mantenimientoMapper.selectByExample(man_ex);
		 manequ.setIdmantenimiento(list_man.get(list_man.size()-1).getIdmantenimiento());
		equipoMantenMapper.insert(manequ);
		return list_man.get(list_man.size()-1).getIdmantenimiento();
	}
	
	public void insertarmantenimiento(Mantenimiento mans) {
		mantenimientoMapper.insert(mans);
	}
	public void insertarequipo(Equipo equipo_est)throws Exception{
		equipoMapper.insert(equipo_est);
	}
	public List<Material> encuntra_material (String material) {
		List<Material> mater= new ArrayList<Material>();
		mater= materialMapper.selectByMaterial(material);
		return mater;
	}
	public List<Material> encuntra_material_man (int id_mante) {
		List<Material> mater= new ArrayList<Material>();
		List<MantenimientoMaterial> MMM = new ArrayList<MantenimientoMaterial>();
		MMM = mantenimientoMaterialMapper.selectByIdmantenimiento(id_mante);
		for(int i = 0;i<=MMM.size()-1;i++) {
			Material m_h = new Material();
			m_h = materialMapper.selectByPrimaryKey(MMM.get(i).getIdmaterial());
			m_h.setCantidad(MMM.get(i).getCantTipo());
			mater.add(m_h);
		}

		return mater;
	}
	public Material encutra_noserie(String n_serie) {
		return materialMapper.selectByNoSerie(n_serie);
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
	public void actualizarmaterial(Material material) throws Exception{
		materialMapper.updateByPrimaryKeySelective(material);
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
	public List<Material> lista_material(){
		
		List<Material> list_mat =  new ArrayList<Material>();
		MaterialExample materialEx =  new MaterialExample();
		list_mat = materialMapper.selectByExample(materialEx);
		return list_mat;
	}
	public Material datosMaterial(int m) {
		return materialMapper.selectByPrimaryKey(m);
	}
	public void actualizarMaterial(Material m) {
		materialMapper.updateByPrimaryKey(m);
	}
	
	public Usuario encuentraIdUsuatio(int iduser) {
		return usuarioMapper.selectByPrimaryKey(iduser);
	}
	public Equipo encuentra_por_id(int idkey) {
		return equipoMapper.selectByPrimaryKey(idkey);
	}
	/*zuri*/
	private Date generarFecha(Date fecha, int tipoFecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		if(tipoFecha == FECHA_INICIO){
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 1);
		}else if(tipoFecha == FECHA_FIN){
			cal.set(Calendar.HOUR, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
		}
		return cal.getTime();
	}

	
	
}
