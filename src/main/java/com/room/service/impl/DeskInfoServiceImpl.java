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
public class DeskInfoServiceImpl implements DeskInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    DeskInfoMapper deskInfoMapper;

    /**
      新增
    */
    @Override
    public String add(DeskInfo model, LoginModel login) {
        if ((model.getDeskNo() == null) || model.getDeskNo().equals("")) {
            return "桌号为必填属性";
        }

        model.setDeskStatus(1); //默认空闲,
        deskInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(DeskInfo model, LoginModel login) {
        DeskInfo preModel = deskInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getDeskNo() == null) || model.getDeskNo().equals("")) {
            return "桌号为必填属性";
        }

        preModel.setDeskNo(model.getDeskNo());
        deskInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询桌子列表数据
    */
    @Override
    public Map<String, Object> getDataList(DeskInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        DeskInfoExample se = new DeskInfoExample();
        DeskInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getDeskNo() != null) &&
                (queryModel.getDeskNo().equals("") == false)) {
            sc.andDeskNoLike("%" + queryModel.getDeskNo() + "%"); //模糊查询
        }

        if (queryModel.getDeskStatus() != null) {
            sc.andDeskStatusEqualTo(queryModel.getDeskStatus()); //查询当前状态等于指定值
        }

        int count = (int) deskInfoMapper.countByExample(se);
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

        List<DeskInfo> list = deskInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (DeskInfo model : list) {
            list2.add(getDeskInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装桌子为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getDeskInfoModel(DeskInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deskInfo", model);
        map.put("deskStatusStr",
            DataListUtils.getDeskStatusNameById(model.getDeskStatus() + "")); //解释当前状态字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        deskInfoMapper.deleteByPrimaryKey(id);
    }
}

