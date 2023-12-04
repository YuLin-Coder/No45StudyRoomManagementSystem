package com.room.service;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface OrderGatherService {
    /**
      订单统计
    page:当前页数
    login:当前登录账号
    orcreateTime1:预订时间(最小值)
    orcreateTime2:预订时间(最大值)
    */
    public Map<String, Object> orderGather(Integer page, LoginModel login,
        String orcreateTime1, String orcreateTime2);
}

