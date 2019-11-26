package com.lab.sdt.dao;

import com.lab.sdt.model.Presionintraocular;
import com.lab.sdt.model.PresionintraocularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PresionintraocularMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	long countByExample(PresionintraocularExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByExample(PresionintraocularExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insert(Presionintraocular record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int insertSelective(Presionintraocular record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	List<Presionintraocular> selectByExample(PresionintraocularExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	Presionintraocular selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Presionintraocular record,
			@Param("example") PresionintraocularExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByExample(@Param("record") Presionintraocular record,
			@Param("example") PresionintraocularExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKeySelective(Presionintraocular record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table presionintraocular
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	int updateByPrimaryKey(Presionintraocular record);
}