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
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class OrderGatherServiceImpl implements OrderGatherService {
    @Autowired
    AdhocOrderGatherMapper adhocOrderGatherMapper;
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
      订单统计
    page:当前页数
    login:当前登录账号
    orcreateTime1:预订时间(最小值)
    orcreateTime2:预订时间(最大值)
    */
    @Override
    public Map<String, Object> orderGather(Integer page, LoginModel login,
        String orcreateTime1, String orcreateTime2) {
        Map<String, Object> rs = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("createTime1", orcreateTime1);
        params.put("createTime2", orcreateTime2);
        params.put("orderStatus", 2);

        List<Map<String, Object>> list = adhocOrderGatherMapper.orderGather(params); //订单统计

        for (Map<String, Object> adhocMap : list) {
        }

        List<String> createTimeXList = DateCommonUtils.getEchartTimeList(orcreateTime1,
                orcreateTime2, "yyyy-MM-dd", "yyyy-MM-dd", 3);
        rs.put("createTimeXList", createTimeXList);

        List<Map<String, Object>> rsList1 = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            rsList1.add(map);
        }

        rs.put("rsList1", rsList1);

        return rs;
    }
}

