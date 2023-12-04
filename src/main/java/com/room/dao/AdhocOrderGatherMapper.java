package com.room.dao;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdhocOrderGatherMapper {
    /**
      订单统计
    */
    public List<Map<String, Object>> orderGather(Map<String, Object> params); //订单统计
}

