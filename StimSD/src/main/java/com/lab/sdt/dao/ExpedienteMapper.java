package com.lab.sdt.dao;

import com.lab.sdt.model.Expediente;
import com.lab.sdt.model.ExpedienteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpedienteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    long countByExample(ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int deleteByExample(ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int deleteByPrimaryKey(Integer idexpediente);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int insert(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int insertSelective(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    /*zuri inicio*/
    List<Expediente> selectByExample(ExpedienteExample example);
    List<Expediente> selectByNoSerie(String serie);
    
    /*zuri Fin*/
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    /*zuri inicio*/
    Expediente selectByPrimaryKey(Integer idexpediente);
    List<Expediente> selectByidUsuario(Integer idusuario);
    List<Expediente> selectByExpediente(Integer idexpediente);
    List<Expediente> selectByidDoctor(int idmedico);
    /*zuri fin*/
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int updateByExampleSelective(@Param("record") Expediente record, @Param("example") ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int updateByExample(@Param("record") Expediente record, @Param("example") ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int updateByPrimaryKeySelective(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Mon Aug 26 21:55:40 CDT 2019
     */
    int updateByPrimaryKey(Expediente record);
}