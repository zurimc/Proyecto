package com.lab.sdt.dao;

import com.lab.sdt.model.EquipoManten;
import com.lab.sdt.model.EquipoMantenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipoMantenMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	long countByExample(EquipoMantenExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByExample(EquipoMantenExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByPrimaryKey(Integer idequipoManten);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insert(EquipoManten record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insertSelective(EquipoManten record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	List<EquipoManten> selectByExample(EquipoMantenExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	EquipoManten selectByPrimaryKey(Integer idequipoManten);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExampleSelective(@Param("record") EquipoManten record, @Param("example") EquipoMantenExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExample(@Param("record") EquipoManten record, @Param("example") EquipoMantenExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKeySelective(EquipoManten record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table equipo_manten
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKey(EquipoManten record);
}