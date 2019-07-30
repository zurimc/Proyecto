package com.lab.sdt.dao;

import com.lab.sdt.model.MantenimientoMaterial;
import com.lab.sdt.model.MantenimientoMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MantenimientoMaterialMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	long countByExample(MantenimientoMaterialExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByExample(MantenimientoMaterialExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int deleteByPrimaryKey(Integer idmantemat);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insert(MantenimientoMaterial record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int insertSelective(MantenimientoMaterial record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	List<MantenimientoMaterial> selectByExample(MantenimientoMaterialExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	MantenimientoMaterial selectByPrimaryKey(Integer idmantemat);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExampleSelective(@Param("record") MantenimientoMaterial record,
			@Param("example") MantenimientoMaterialExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByExample(@Param("record") MantenimientoMaterial record,
			@Param("example") MantenimientoMaterialExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKeySelective(MantenimientoMaterial record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mantenimiento_material
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	int updateByPrimaryKey(MantenimientoMaterial record);
}