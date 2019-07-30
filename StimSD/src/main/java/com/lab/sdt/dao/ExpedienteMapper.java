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
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    long countByExample(ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int deleteByExample(ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int deleteByPrimaryKey(Integer idexpediente);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int insert(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int insertSelective(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    List<Expediente> selectByExample(ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    Expediente selectByPrimaryKey(Integer idexpediente);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int updateByExampleSelective(@Param("record") Expediente record, @Param("example") ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int updateByExample(@Param("record") Expediente record, @Param("example") ExpedienteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int updateByPrimaryKeySelective(Expediente record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente
     *
     * @mbg.generated Fri Jul 26 19:26:22 CDT 2019
     */
    int updateByPrimaryKey(Expediente record);
}