package com.lab.sdt.dao;

import com.lab.sdt.model.Parametro;
import com.lab.sdt.model.ParametroExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParametroMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	long countByExample(ParametroExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByExample(ParametroExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByPrimaryKey(Integer idparametro);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insert(Parametro record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insertSelective(Parametro record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	List<Parametro> selectByExample(ParametroExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	Parametro selectByPrimaryKey(Integer idparametro);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExampleSelective(@Param("record") Parametro record, @Param("example") ParametroExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExample(@Param("record") Parametro record, @Param("example") ParametroExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKeySelective(Parametro record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table parametro
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKey(Parametro record);
}