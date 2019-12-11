package com.lab.sdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.FotosMapper;
import com.lab.sdt.model.Fotos;
import com.lab.sdt.model.FotosExample;

@Service
@Transactional
public class ImagenService {
	
	@Autowired
	private FotosMapper fotosMapper;

//INGRESAR INFORMACION EN LA BASE DE DATOS DE FOTO
public void insertarFoto (Fotos fotos) throws Exception{
	fotosMapper.insert(fotos);
}
public Fotos obtenerFoto (String fotos) {
	List<Fotos> contenedor_foto = fotosMapper.selectByNfotos(fotos);
	return contenedor_foto.get(0);
}

public String registroFoto(String fotos){
	String respuesta = null;
	try {
		respuesta= obtenerFoto(fotos).getNombreFoto() ;
	}catch(Exception e) {
		respuesta = null;
	}
	return respuesta;
	
}
public Fotos encuenta_por_id (int idFoto){
	return fotosMapper.selectByPrimaryKey(idFoto);
}
}