package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.TipousuarioMapper;
import com.lab.sdt.dao.UsuarioMapper;

import com.lab.sdt.model.Tipousuario;
import com.lab.sdt.model.TipousuarioExample;
import com.lab.sdt.model.UsuarioExample;
import com.lab.sdt.model.Usuario;



@Service
@Transactional
public class ConsultaUsuarios {

	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private TipousuarioMapper tipousuarioMapper;
	
	public List<SelectItem> lista_tipousuario;
	public List<Tipousuario> tusuarios1;
	

	
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
	public List<SelectItem> getLista_tipousuarios() {
		this.lista_tipousuario = new ArrayList<SelectItem>();
		TipousuarioExample exTUs = new TipousuarioExample();
		
		for(int ii = 1; ii<= tipousuarioMapper.countByExample(exTUs); ii++) {
			//estadoMapper.selectByPrimaryKey(2).getEstado()
		//listaestados.add(""+0);
			SelectItem estados = new SelectItem(ii,tipousuarioMapper.selectByPrimaryKey(ii).getTipousuario());
			this.lista_tipousuario.add(estados);
			//listaestados.add(estadoMapper.selectByPrimaryKey(ii).getEstado());
		}
		return lista_tipousuario;
}

	public void setLista_tipousuario(List<SelectItem> lista_tipousuario) {
		this.lista_tipousuario = lista_tipousuario;
	}
	
	//buscar la cuenta y el estatus
	public Usuario encuentra_cuenta(String cuenta) {
		Usuario cuentas1 = new cuentas1();
		cuentas1 = usuarioMapper.selectBycuenta(cuenta);
		return cuentas1;
	}
	
	public List<Usuario> lista_cuentas() {
        List<Usuario> list_cu = new ArrayList<Usuario>();
        UsuarioExample UsuarioEx = new UsuarioExample();
        list_cu = usuarioMapper.selectByExample(UsuarioEx);
        return list_cu;
    }
	
	
}