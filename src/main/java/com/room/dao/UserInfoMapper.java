package com.room.dao;

import com.room.model.UserInfo;
import com.room.model.UserInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    UserInfo record, @Param("example")
    UserInfoExample example);

    int updateByExample(@Param("record")
    UserInfo record, @Param("example")
    UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}

