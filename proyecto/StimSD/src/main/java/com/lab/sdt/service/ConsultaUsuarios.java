package com.lab.sdt.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.sdt.dao.EspecialidadMapper;
import com.lab.sdt.dao.TipousuarioMapper;
import com.lab.sdt.dao.UsuarioMapper;
import com.lab.sdt.model.Especialidad;

import com.lab.sdt.model.Tipousuario;
import com.lab.sdt.model.TipousuarioExample;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.model.UsuarioExample;
import com.lab.sdt.model.ExpedienteConsultaExample.Criteria;



@Service
@Transactional
public class ConsultaUsuarios {

	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private EspecialidadMapper especialidadMapper;
	
	@Autowired
	private TipousuarioMapper tipousuarioMapper;
	
	public void registroUsuario(Usuario U) throws Exception{
		
		insertarUsuario(U);
	}
	
	public void insertarEspecialidad(Especialidad esp) {
		especialidadMapper.insert(esp);
	}
	
	public void actualizaEspecialidad(Especialidad esp) {
		especialidadMapper.updateByPrimaryKey(esp);
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
	
	public int insertarUsuario(Usuario usuario)throws Exception{
		usuarioMapper.insert(usuario);
		usuarioMapper.updateByPrimaryKey(usuario);
		List<Usuario> list_user = new ArrayList<Usuario>();
		UsuarioExample user_ex = new  UsuarioExample();
		list_user = usuarioMapper.selectByExample(user_ex);
		return list_user.get(list_user.size()-1).getIdusuario();
	}
	public int actualizaUsuario(Usuario usuario)throws Exception{
		usuarioMapper.updateByPrimaryKey(usuario);

		return usuario.getIdusuario();
	}
	public List<Especialidad> obtenerEspeciladadUser(int user){
		return especialidadMapper.selectByUsuario(user);
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
	public List<Usuario> lista_tipo_cuenta(int  idTipo){
		  List<Usuario> list_cu = new ArrayList<Usuario>();
		  //list_cu =  usuarioMapper.selectByTipoUser(idTipo);
		  List<Usuario> datos_d = usuarioMapper.selectByTipoUser(idTipo);
          for(int i = 0;i<=datos_d.size()-1;i++) {
        		if(datos_d.get(i).getCuenta().length()>0) {
        			list_cu.add(datos_d.get(i));
        		}
          }
		 return list_cu;
	}
	public List<Usuario> lista_cuentas(int solicita) {
		
        List<Usuario> list_cu = new ArrayList<Usuario>();
        UsuarioExample UsuarioEx = new UsuarioExample();
        if(solicita == 1) // administrador 
        {
        	list_cu = usuarioMapper.selectByExample(UsuarioEx);
        }else if(solicita == 5){// operador
        	com.lab.sdt.model.UsuarioExample.Criteria critexp = UsuarioEx.createCriteria();
        	critexp.andIdtipoNotEqualTo(5);
        	critexp.andIdtipoNotBetween(1,3);
            List<Usuario> datos_d = usuarioMapper.selectByExample(UsuarioEx);
            for(int i = 0;i<=datos_d.size()-1;i++) {
            	if(datos_d.get(i).getCuenta().length()>0) {
            		list_cu.add(datos_d.get(i));
            	}
            }
        	//list_cu = usuarioMapper.selectByExample(UsuarioEx);
        }
        
        return list_cu;
    }
	public Usuario encuentra_cuenta(String cuenta, int solicita) {
		Usuario usera = new Usuario();
		if(solicita == 1) {
			usera = usuarioMapper.selectByCuenta(cuenta).get(0);
		}else if(solicita == 5){
			Usuario usera1 = usuarioMapper.selectByCuenta(cuenta).get(0);
			if(usera1.getIdtipo() == 4 || usera1.getIdtipo() == 6) {
				usera = usera1;
			}
		}
	
		return usera;
	}

	public List<SelectItem> lista_tipousuarios() {
		List<SelectItem> lista_tipousuario = new ArrayList<SelectItem>();
		TipousuarioExample exTUs = new TipousuarioExample();
		
		for(int ii = 1; ii<= tipousuarioMapper.countByExample(exTUs); ii++) {
			//estadoMapper.selectByPrimaryKey(2).getEstado()
		//listaestados.add(""+0);
			SelectItem estados = new SelectItem(ii,tipousuarioMapper.selectByPrimaryKey(ii).getTipousuario());
			lista_tipousuario.add(estados);
			//listaestados.add(estadoMapper.selectByPrimaryKey(ii).getEstado());
		}
		return lista_tipousuario;
}
	public List<SelectItem> lista_tipousuarios_operador() {
		List<SelectItem> lista_tipousuario = new ArrayList<SelectItem>();
		TipousuarioExample exTUs = new TipousuarioExample();
		
		for(int ii = 1; ii<= tipousuarioMapper.countByExample(exTUs); ii++) {
			//estadoMapper.selectByPrimaryKey(2).getEstado()
		//listaestados.add(""+0);
			Tipousuario tipo_user = new Tipousuario();
			tipo_user = tipousuarioMapper.selectByPrimaryKey(ii);
			if(tipo_user.getIdtipo() == 6 ||tipo_user.getIdtipo() == 4) {
			SelectItem estados = new SelectItem(ii,tipo_user.getTipousuario());
			lista_tipousuario.add(estados);
			}
			//listaestados.add(estadoMapper.selectByPrimaryKey(ii).getEstado());
		}
		return lista_tipousuario;
}
	public List<Usuario> lista_usuaio_nombre(String  nombre){
		 return usuarioMapper.selectByNombre(nombre);
	}
	public Usuario encontra_porid(int iduserkey) {
		return usuarioMapper.selectByPrimaryKey(iduserkey);
	}
}