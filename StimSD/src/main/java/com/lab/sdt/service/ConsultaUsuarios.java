package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.TipousuarioMapper;
import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.model.Tipousuario;
import com.lab.sdt.model.Usuario;


@Service
@Transactional
public class ConsultaUsuarios {

	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private TipousuarioMapper tipousuarioMapper;
	
	public void registroUsuario(Usuario U) throws Exception{
		
		insertarUsuario(U);
		
		
	}
	
	public String insertarUsuario(String username) throws Exception{
		Usuario user_1 = new Usuario();
		user_1.setNombre("erwin");
		user_1.setApellido1("davila");
		user_1.setApellido2("iniesta");
		user_1.setCalle("flor");
		user_1.setNum("11");
		user_1.setColonia("coyoacan");
		user_1.setCodigopostal("57820");
		user_1.setIdestado(2);
		user_1.setTelefono("584686695");
		user_1.setEmail("erwin@gmail.com");
		user_1.setIdtipo(1);
		user_1.setCuenta("erwin");
		user_1.setContrasenia("9876");
		user_1.setEstatus("");
		
		insertarUsuario(user_1);
		return "ok";
	}
	//METODO PARA PONER NOMBRE Y CONTRASEÑA Y TE DICE QUE TIPO DE USUARIO ES
	public String login(String nombre, String contrasenia) {
		String resultado= "" ;
		Tipousuario tipo_usuario = new Tipousuario();
		List<Usuario> contenedor_usuario = usuarioMapper.selectByNombre(nombre);
		if(contenedor_usuario.size() >=0) {
			if(contenedor_usuario.get(0).getContrasenia().equals(contrasenia)) {
				
				tipo_usuario = tipousuarioMapper.selectByPrimaryKey(contenedor_usuario.get(0).getIdtipo());
				resultado = tipo_usuario.getTipousuario();
			}else {
				resultado = "error";
			} 
		}else {
			resultado = null;
		}
		
		return resultado;
	}
	
	//METODO PARA INSERTAR EN BASE DE DATOS
	
	public void insertarUsuario(Usuario usuario)throws Exception{
		usuarioMapper.insert(usuario);
	}
	
	//METODO PARA EL COMBOBOX DE ESTADOS
	
}