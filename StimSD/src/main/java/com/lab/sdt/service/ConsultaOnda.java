package com.lab.sdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.NumOndaMapper;
import com.lab.sdt.dao.OndaMapper;
import com.lab.sdt.dao.OndaValorMapper;
import com.lab.sdt.dao.TipondaMapper;
import com.lab.sdt.dao.ValorMapper;
import com.lab.sdt.model.Tiponda;
import com.lab.sdt.model.TipondaExample;

@Service
@Transactional
public class ConsultaOnda {

	private OndaMapper ondaMapper;
	
	@Autowired
	private OndaValorMapper ondaValorMapper;
	
	@Autowired
	private ValorMapper valorMapper;
	
	@Autowired
	private TipondaMapper tipondaMapper;
	
	@Autowired
	private NumOndaMapper numOndaMapper;
	
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
}
