package com.room.dao;

import com.room.model.OrderInfo;
import com.room.model.OrderInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderInfoMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    OrderInfo record, @Param("example")
    OrderInfoExample example);

    int updateByExample(@Param("record")
    OrderInfo record, @Param("example")
    OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}

