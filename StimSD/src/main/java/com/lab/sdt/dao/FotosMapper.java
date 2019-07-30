package com.lab.sdt.dao;

import com.lab.sdt.model.Fotos;
import com.lab.sdt.model.FotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FotosMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	long countByExample(FotosExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByExample(FotosExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByPrimaryKey(Integer idfoto);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insert(Fotos record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insertSelective(Fotos record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	List<Fotos> selectByExample(FotosExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	Fotos selectByPrimaryKey(Integer idfoto);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExampleSelective(@Param("record") Fotos record, @Param("example") FotosExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExample(@Param("record") Fotos record, @Param("example") FotosExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKeySelective(Fotos record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fotos
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKey(Fotos record);
}