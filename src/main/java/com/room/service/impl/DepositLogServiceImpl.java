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
public class DepositLogServiceImpl implements DepositLogService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    DepositLogMapper depositLogMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      充值
    */
    @Override
    public String deposit(DepositLog model, LoginModel login) {
        if (model.getAmount() == null) {
            return "充值金额为必填属性";
        }

        model.setDepositNo(sdf3.format(new Date()) +
            RandomCodeUtils.getRandomCode()); //随机码(当前时间+6位随机码)
        model.setUserId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        depositLogMapper.insertSelective(model); //插入数据
        UserInfo user = userInfoMapper.selectByPrimaryKey(login.getId());
        user.setUserAccount(user.getUserAccount()+model.getAmount());
        userInfoMapper.updateByPrimaryKeySelective(user);
        return "";
    }

    /**
    *根据参数查询充值记录列表数据
    */
    @Override
    public Map<String, Object> getDataList(DepositLog queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        DepositLogExample se = new DepositLogExample();
        DepositLogExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getDepositNo() != null) &&
                (queryModel.getDepositNo().equals("") == false)) {
            sc.andDepositNoLike("%" + queryModel.getDepositNo() + "%"); //模糊查询
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        int count = (int) depositLogMapper.countByExample(se);
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

        List<DepositLog> list = depositLogMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (DepositLog model : list) {
            list2.add(getDepositLogModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装充值记录为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getDepositLogModel(DepositLog model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("depositLog", model);

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //充值用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr", userInfo.getLoginName());
            }
        }

        return map;
    }
}

