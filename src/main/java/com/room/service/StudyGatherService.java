package com.room.service;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface StudyGatherService {
    /**
      学习时间统计
    page:当前页数
    login:当前登录账号
    ororderDate1:预约日期(最小值)
    ororderDate2:预约日期(最大值)
    */
    public Map<String, Object> studyGather(Integer page, LoginModel login,
        String ororderDate1, String ororderDate2);
}

