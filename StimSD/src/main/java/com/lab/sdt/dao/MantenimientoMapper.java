package com.lab.sdt.dao;

import com.lab.sdt.model.Mantenimiento;
import com.lab.sdt.model.MantenimientoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MantenimientoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    long countByExample(MantenimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int deleteByExample(MantenimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int deleteByPrimaryKey(Integer idmantenimiento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int insert(Mantenimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int insertSelective(Mantenimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    List<Mantenimiento> selectByExample(MantenimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    Mantenimiento selectByPrimaryKey(Integer idmantenimiento);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int updateByExampleSelective(@Param("record") Mantenimiento record, @Param("example") MantenimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int updateByExample(@Param("record") Mantenimiento record, @Param("example") MantenimientoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int updateByPrimaryKeySelective(Mantenimiento record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    int updateByPrimaryKey(Mantenimiento record);
}