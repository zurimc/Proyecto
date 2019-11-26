package com.lab.sdt.dao;

import com.lab.sdt.model.Correlacion;
import com.lab.sdt.model.CorrelacionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorrelacionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	long countByExample(CorrelacionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByExample(CorrelacionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByPrimaryKey(Integer idcorrelacion);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insert(Correlacion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insertSelective(Correlacion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	List<Correlacion> selectByExample(CorrelacionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	Correlacion selectByPrimaryKey(Integer idcorrelacion);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Correlacion record, @Param("example") CorrelacionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExample(@Param("record") Correlacion record, @Param("example") CorrelacionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKeySelective(Correlacion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKey(Correlacion record);
}