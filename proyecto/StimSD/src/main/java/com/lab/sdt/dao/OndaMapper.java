package com.lab.sdt.dao;

import com.lab.sdt.model.Onda;
import com.lab.sdt.model.OndaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OndaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    long countByExample(OndaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int deleteByExample(OndaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int deleteByPrimaryKey(Integer idonda);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int insert(Onda record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int insertSelective(Onda record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    List<Onda> selectByExample(OndaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    Onda selectByPrimaryKey(Integer idonda);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByExampleSelective(@Param("record") Onda record, @Param("example") OndaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByExample(@Param("record") Onda record, @Param("example") OndaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByPrimaryKeySelective(Onda record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table onda
     *
     * @mbg.generated Mon May 20 14:45:29 CDT 2019
     */
    int updateByPrimaryKey(Onda record);
}