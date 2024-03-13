package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.SequenceDO;

public interface SequenceDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    int deleteByPrimaryKey(String sequenceName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    int insert(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    int insertSelective(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    SequenceDO selectByPrimaryKey(String sequenceName);

    SequenceDO getSequenceByName(String sequenceName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    int updateByPrimaryKeySelective(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Mon Mar 11 15:32:29 CST 2024
     */
    int updateByPrimaryKey(SequenceDO record);
}