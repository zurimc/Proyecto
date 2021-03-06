package com.lab.sdt.dao;

import com.lab.sdt.model.Enfermedad;
import com.lab.sdt.model.EnfermedadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnfermedadMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	long countByExample(EnfermedadExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByExample(EnfermedadExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByPrimaryKey(Integer idenfermedad);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insert(Enfermedad record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insertSelective(Enfermedad record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	List<Enfermedad> selectByExample(EnfermedadExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	Enfermedad selectByPrimaryKey(Integer idenfermedad);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Enfermedad record, @Param("example") EnfermedadExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExample(@Param("record") Enfermedad record, @Param("example") EnfermedadExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKeySelective(Enfermedad record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table enfermedad
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKey(Enfermedad record);
}