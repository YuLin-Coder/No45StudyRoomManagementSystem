package com.room.service;

import com.room.controller.LoginModel;

import com.room.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface DeskInfoService {
    /**
      分页查询桌子数据列表
    */
    public Map<String, Object> getDataList(DeskInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装桌子为前台展示的数据形式
    */
    public Map<String, Object> getDeskInfoModel(DeskInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(DeskInfo model, LoginModel login);

    /**
      修改
    */
    public String update(DeskInfo model, LoginModel login);
}

