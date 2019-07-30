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
	
	public Usuario validarusuario(String cuenta, String contrasenia) throws Exception{
		Usuario user = new Usuario();
		
		if(cuenta_registro(cuenta) == null) {
			throw new Exception("contraseña o usuario no valido");
		}else {
			user = obterusuarioporcuenta(cuenta);
		}
		
		if(user.getEstatus().equals("D") || user.getEstatus().equals("") ) {
			throw new Exception("Su cuenta esta deshabilitada. Por favor consulte a su proveedor");
		} if(!user.getContrasenia().contentEquals(contrasenia)){
			throw new Exception("contraseña o usuario no valido");
		}
		return user;
	}
	
	//METODO PARA PONER NOMBRE Y CONTRASEÑA Y TE DICE QUE TIPO DE USUARIO ES
	public String login(String nombre, String contrasenia) {
		String resultado=null ;
		Tipousuario tipo_usuario = new Tipousuario();
		try {
			   if(obterusuarioporcuenta(nombre).getContrasenia().equals(contrasenia)) {
			   tipo_usuario = tipousuarioMapper.selectByPrimaryKey(obterusuarioporcuenta(nombre).getIdtipo());
			   resultado = tipo_usuario.getTipousuario();
			}else {
				resultado = "contraseña o usuario no valido ";
			} 
		}catch(Exception e) {
			resultado = "contraseña o usuario no valido ";
		}
		
		return resultado;
	}
	
	//METODO PARA INSERTAR EN BASE DE DATOS
	
	public void insertarUsuario(Usuario usuario)throws Exception{
		usuarioMapper.insert(usuario);
	}
	
	public Usuario obterusuarioporcuenta(String cuenta1) {
		List<Usuario> contenedor_usuario = usuarioMapper.selectByCuenta(cuenta1);
		return contenedor_usuario.get(0);
	}
	
	public String cuenta_registro(String cuenta2) {
		String res= null;
		try {
			res = obterusuarioporcuenta(cuenta2).getCuenta();
		}catch(Exception e) {
			res=null;
		}
		return res;
	}
}