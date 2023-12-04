package com.room.service.impl;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import com.room.service.*;

import com.room.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class SysSettingInfoServiceImpl implements SysSettingInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    SysSettingInfoMapper sysSettingInfoMapper;

    /**
      修改
    */
    @Override
    public String update(SysSettingInfo model, LoginModel login) {
        SysSettingInfo preModel = sysSettingInfoMapper.selectByPrimaryKey(model.getId());

        if (model.getStartTime() == null) {
            return "开始时间为必填属性";
        }

        if (model.getEndTime() == null) {
            return "结束时间为必填属性";
        }

        if (model.getPrice() == null) {
            return "价格为必填属性";
        }

        if ((model.getShopName() == null) || model.getShopName().equals("")) {
            return "店铺名为必填属性";
        }

        if ((model.getShopIntro() == null) || model.getShopIntro().equals("")) {
            return "简介为必填属性";
        }

        if ((model.getAddress() == null) || model.getAddress().equals("")) {
            return "地址为必填属性";
        }

        preModel.setStartTime(model.getStartTime());
        preModel.setEndTime(model.getEndTime());
        preModel.setPrice(model.getPrice());
        preModel.setShopName(model.getShopName());
        preModel.setShopIntro(model.getShopIntro());
        preModel.setAddress(model.getAddress());
        sysSettingInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询系统设置列表数据
    */
    @Override
    public Map<String, Object> getDataList(SysSettingInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        SysSettingInfoExample se = new SysSettingInfoExample();
        SysSettingInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        int count = (int) sysSettingInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<SysSettingInfo> list = sysSettingInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (SysSettingInfo model : list) {
            list2.add(getSysSettingInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装系统设置为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getSysSettingInfoModel(SysSettingInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sysSettingInfo", model);

        return map;
    }
}

