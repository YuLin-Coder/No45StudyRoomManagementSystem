package com.room.service;

import com.room.controller.LoginModel;

import com.room.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface DepositLogService {
    /**
      分页查询充值记录数据列表
    */
    public Map<String, Object> getDataList(DepositLog queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装充值记录为前台展示的数据形式
    */
    public Map<String, Object> getDepositLogModel(DepositLog model,
        LoginModel login);

    /**
      充值
    */
    public String deposit(DepositLog model, LoginModel login);
}

