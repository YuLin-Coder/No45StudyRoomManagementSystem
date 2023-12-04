package com.room.dao;

import com.room.model.DepositLog;
import com.room.model.DepositLogExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepositLogMapper {
    long countByExample(DepositLogExample example);

    int deleteByExample(DepositLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepositLog record);

    int insertSelective(DepositLog record);

    List<DepositLog> selectByExample(DepositLogExample example);

    DepositLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    DepositLog record, @Param("example")
    DepositLogExample example);

    int updateByExample(@Param("record")
    DepositLog record, @Param("example")
    DepositLogExample example);

    int updateByPrimaryKeySelective(DepositLog record);

    int updateByPrimaryKey(DepositLog record);
}

