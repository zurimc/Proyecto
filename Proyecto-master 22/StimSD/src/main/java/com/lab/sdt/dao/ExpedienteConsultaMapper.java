package com.lab.sdt.dao;
import java.util.Date;
import com.lab.sdt.model.ExpedienteConsulta;
import com.lab.sdt.model.ExpedienteConsultaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpedienteConsultaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    long countByExample(ExpedienteConsultaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int deleteByExample(ExpedienteConsultaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int deleteByPrimaryKey(Integer idexpeconsul);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int insert(ExpedienteConsulta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int insertSelective(ExpedienteConsulta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    List<ExpedienteConsulta> selectByExample(ExpedienteConsultaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    ExpedienteConsulta selectByPrimaryKey(Integer idexpeconsul);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int updateByExampleSelective(@Param("record") ExpedienteConsulta record, @Param("example") ExpedienteConsultaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int updateByExample(@Param("record") ExpedienteConsulta record, @Param("example") ExpedienteConsultaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int updateByPrimaryKeySelective(ExpedienteConsulta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table expediente_consulta
     *
     * @mbg.generated Sun Sep 08 00:46:42 CDT 2019
     */
    int updateByPrimaryKey(ExpedienteConsulta record);
    List<ExpedienteConsulta> selectByFechaConsulta(Date fconsulta);
    List<ExpedienteConsulta> selectByList(ExpedienteConsultaExample example);
}