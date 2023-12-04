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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    DeskInfoMapper deskInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    SysSettingInfoMapper sysSettingInfoMapper;

    /**
      新增
    */
    @Override
    public String orderDesk(OrderInfo model, LoginModel login) {
        if ((model.getOrderDate() == null) || model.getOrderDate().equals("")) {
            return "预约日期为必填属性";
        }

        if (model.getStartTime() == null) {
            return "开始时间为必填属性";
        }

        if (model.getEndTime() == null) {
            return "结束时间为必填属性";
        }
        if(model.getEndTime()<=model.getStartTime()){
        	return "结束时间必须大于开始时间";
        }
        
        if(model.getOrderDate().compareTo(sdf2.format(new Date()))<0){
        	return "预约日期必须大于等于当天";
        }
        UserInfo user = userInfoMapper.selectByPrimaryKey(login.getId());
      
        SysSettingInfoExample se = new SysSettingInfoExample();
        List<SysSettingInfo> sl = sysSettingInfoMapper.selectByExample(se);
        model.setOrderNo(sdf3.format(new Date()) +
            RandomCodeUtils.getRandomCode()); //随机码(当前时间+6位随机码)
        model.setUserId(login.getId()); //登录id
        model.setOrderStatus(1); //默认已预约,
        model.setTotalHours(model.getEndTime()-model.getStartTime());
        model.setPrice(sl.get(0).getPrice());
        model.setTotalAmount(model.getPrice()*model.getTotalHours());
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        
        if(user.getUserAccount()<model.getTotalAmount()){
        	return "余额不足，不能预订";
        }
        
        user.setUserAccount(user.getUserAccount()-model.getTotalAmount());
        userInfoMapper.updateByPrimaryKeySelective(user);
        
        orderInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
    *根据参数查询订单列表数据
    */
    @Override
    public Map<String, Object> getDataList(OrderInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        OrderInfoExample se = new OrderInfoExample();
        OrderInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getDeskId() != null) {
            sc.andDeskIdEqualTo(queryModel.getDeskId());
        }

        if ((queryModel.getOrderNo() != null) &&
                (queryModel.getOrderNo().equals("") == false)) {
            sc.andOrderNoLike("%" + queryModel.getOrderNo() + "%"); //模糊查询
        }

        if (queryModel.getOrderStatus() != null) {
            sc.andOrderStatusEqualTo(queryModel.getOrderStatus()); //查询预约状态等于指定值
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        int count = (int) orderInfoMapper.countByExample(se);
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

        List<OrderInfo> list = orderInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (OrderInfo model : list) {
            list2.add(getOrderInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装订单为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getOrderInfoModel(OrderInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderInfo", model);

        if (model.getDeskId() != null) {
            DeskInfo deskInfo = deskInfoMapper.selectByPrimaryKey(model.getDeskId()); //预约桌号为外接字段,需要关联桌子来解释该字段

            if (deskInfo != null) {
                map.put("deskIdStr", deskInfo.getDeskNo());
            }
        }

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //预订用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr",
                    userInfo.getRealName() + "+" + userInfo.getCelPhone());
            }
        }

        map.put("orderStatusStr",
            DataListUtils.getOrderStatusNameById(model.getOrderStatus() + "")); //解释预约状态字段

        return map;
    }
}

