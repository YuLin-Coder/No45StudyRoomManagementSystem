package com.room.dao;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdhocStudyGatherMapper {
    /**
      学习时间统计
    */
    public List<Map<String, Object>> studyGather(Map<String, Object> params); //学习时间统计
}

