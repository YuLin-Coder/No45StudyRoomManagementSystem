package com.room.dao;

import com.room.model.SysSettingInfo;
import com.room.model.SysSettingInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysSettingInfoMapper {
    long countByExample(SysSettingInfoExample example);

    int deleteByExample(SysSettingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysSettingInfo record);

    int insertSelective(SysSettingInfo record);

    List<SysSettingInfo> selectByExample(SysSettingInfoExample example);

    SysSettingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    SysSettingInfo record, @Param("example")
    SysSettingInfoExample example);

    int updateByExample(@Param("record")
    SysSettingInfo record, @Param("example")
    SysSettingInfoExample example);

    int updateByPrimaryKeySelective(SysSettingInfo record);

    int updateByPrimaryKey(SysSettingInfo record);
}

