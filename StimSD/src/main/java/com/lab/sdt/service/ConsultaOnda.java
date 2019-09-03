package com.lab.sdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.NumOndaMapper;
import com.lab.sdt.dao.OndaValorMapper;
import com.lab.sdt.dao.ParametroMapper;
import com.lab.sdt.dao.TipondaMapper;
import com.lab.sdt.dao.ValorMapper;
import com.lab.sdt.model.NumOnda;
import com.lab.sdt.model.NumOndaExample;
import com.lab.sdt.model.OndaValor;
import com.lab.sdt.model.Parametro;
import com.lab.sdt.model.ParametroExample;
import com.lab.sdt.model.Tiponda;
import com.lab.sdt.model.TipondaExample;

@Service
@Transactional
public class ConsultaOnda {


	@Autowired
	private OndaValorMapper ondaValorMapper;
	
	@Autowired
	private ValorMapper valorMapper;
	
	@Autowired
	private TipondaMapper tipondaMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
	@Autowired
	private ParametroMapper parametroMapper;
	
	public String todos_los_grupos_de_ondas() {
		String res = "";
		TipondaExample onEx = new TipondaExample();
		Tiponda tipond = new Tiponda();
		for(int ii = 1; ii<= tipondaMapper.countByExample(onEx); ii++) {
			tipond = tipondaMapper.selectByPrimaryKey(ii);
		res =res + tipond.getIdtiponda() +"/"+tipond.getNombre()+":";
		}
		return res;
	}
	
	public String tipos_de_ondas(String idTipOnda1) {
		String res = "";
		NumOndaExample onumEx = new NumOndaExample();
		 List<NumOnda> todas_las_ondas = numOndaMapper.selectByExample(onumEx);
		 int idtiponda2 = 0;
	 try {
		 idtiponda2 = Integer.parseInt(idTipOnda1);
	 }catch(Exception e) {}
		for(int ii = 0; ii<= todas_las_ondas.size()-1; ii++) {
			if(todas_las_ondas.get(ii).getIdtiponda() == idtiponda2) {
				res =res + todas_las_ondas.get(ii).getIdnumOnda()+"/"+todas_las_ondas.get(ii).getNombre()+":";
			}
	//		numond = numOndaMapper.selectByPrimaryKey(1);
	//		res =res + numond.getIdnumOnda()+"/"+numond.getNombre()+":";
		}
	
		return res;
	}
	public double[] valores_de_la_onda(int idNum_Ondaa) {
		double[] resint = new double[270];
		String res = "";
		//String[] valores = new String[300];
		int idondaa = 0;
		try {
			//idNum_Ondaan = Integer.parseInt(idNum_Ondaa);
			idondaa = numOndaMapper.selectByPrimaryKey(idNum_Ondaa).getIdonda();
			List<OndaValor> ondvalor =ondaValorMapper.selectByidOnda(idondaa);
			for(int ii =0; ii<= ondvalor.size()-1; ii++) {
				res = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				resint[ii] = Double.parseDouble(res);
				//valores[ii] = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				//res = res + valores[ii]+":";
			}
		}catch(Exception e) {}
		return resint;
	}
	public double[] valores_onda(int idOnda) {
		double[] resint = new double[270];
		String res = "";
		try {
			List<OndaValor> ondvalor =ondaValorMapper.selectByidOnda(idOnda);
			for(int ii =0; ii<= ondvalor.size()-1; ii++) {
				res = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				resint[ii] = Double.parseDouble(res);
				//valores[ii] = valorMapper.selectByPrimaryKey(ondvalor.get(ii).getIdvalor()).getValor();
				//res = res + valores[ii]+":";
			}
		}catch(Exception e) {}
		return resint;
	}
	public int entrega_onda(int idNum_Ondaa) {
		return numOndaMapper.selectByPrimaryKey(idNum_Ondaa).getIdonda();
	}
	public int entrega_num_onda(int idonda) {
		return numOndaMapper.selectByidOnda(idonda).get(0).getIdnumOnda();
	}
	public void actulizar_parametro(Parametro p) {
		parametroMapper.updateByPrimaryKey(p);
	}
	public void insertar_parametro(Parametro p) {
		parametroMapper.insert(p);
	}
	public List<Parametro> todos_parametros(){
		ParametroExample paraEx = new ParametroExample();
		return parametroMapper.selectByExample(paraEx);
	}
	public List<Parametro> parametros_equipo(int idequipo){
		return parametroMapper.selectByequipo(idequipo);
	}
	public List<Parametro> parametros_por_nombre(String nombre){
		return parametroMapper.selectBynombre(nombre);
	}
	public Parametro parametroporkey(int idparametro) {
		return parametroMapper.selectByPrimaryKey(idparametro);
	}
}
