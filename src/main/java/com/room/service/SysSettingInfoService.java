package com.room.service;

import com.room.controller.LoginModel;

import com.room.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SysSettingInfoService {
    /**
      分页查询系统设置数据列表
    */
    public Map<String, Object> getDataList(SysSettingInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装系统设置为前台展示的数据形式
    */
    public Map<String, Object> getSysSettingInfoModel(SysSettingInfo model,
        LoginModel login);

    /**
      修改
    */
    public String update(SysSettingInfo model, LoginModel login);
}

