package com.lab.sdt.dao;

import com.lab.sdt.model.Tiponda;
import com.lab.sdt.model.TipondaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TipondaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	long countByExample(TipondaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByExample(TipondaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByPrimaryKey(Integer idtiponda);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insert(Tiponda record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insertSelective(Tiponda record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	List<Tiponda> selectByExample(TipondaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	Tiponda selectByPrimaryKey(Integer idtiponda);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Tiponda record, @Param("example") TipondaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExample(@Param("record") Tiponda record, @Param("example") TipondaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKeySelective(Tiponda record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tiponda
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKey(Tiponda record);
}