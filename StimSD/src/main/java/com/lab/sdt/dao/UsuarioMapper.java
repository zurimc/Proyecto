package com.lab.sdt.dao;

import com.lab.sdt.model.Equipo;
import com.lab.sdt.model.Usuario;
import com.lab.sdt.model.UsuarioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    long countByExample(UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int deleteByExample(UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int deleteByPrimaryKey(Integer idusuario);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int insert(Usuario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int insertSelective(Usuario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    List<Usuario> selectByExample(UsuarioExample example);
    List<Usuario> selectByNombre(String nombre);
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    Usuario selectByPrimaryKey(Integer idusuario);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByExampleSelective(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByExample(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByPrimaryKeySelective(Usuario record);

    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usuario
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByPrimaryKey(Usuario record);

    List<Usuario>  selectByCuenta(String cuenta);
	List<Usuario> selectByEstatus(String estatus);


}