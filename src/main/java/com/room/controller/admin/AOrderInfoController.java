package com.room.controller.admin;

import com.room.controller.LoginModel;
import com.room.dao.*;
import com.room.model.*;
import com.room.service.*;
import com.room.service.impl.*;
import com.room.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin/order_info")
public class AOrderInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    DeskInfoMapper deskInfoMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台
        modelMap.addAttribute("orderStatusList",
            DataListUtils.getOrderStatusList()); //返回order_status数据列表
    }

    /**
     * 返回订单列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/order_info/list";
    }

    /**
     * 根据查询条件分页查询订单数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(OrderInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return orderInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    @RequestMapping(value = "td2")
    @ResponseBody
    public Object td2(Integer id, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        OrderInfo model = orderInfoMapper.selectByPrimaryKey(id);

        if (model == null) {
            rs.put("code", 0);
            rs.put("msg",
                "该数据已不存在");

            return rs;
        }

        String now = sdf1.format(new Date());
        String hour="";
        if(model.getStartTime()<10){
        	hour="0"+model.getStartTime();
        }else{
        	hour=model.getStartTime()+"";
        }
        String startTime = model.getOrderDate()+" "+hour+":00:00";
        int hours = CommonUtils.getHours(now, startTime);
        if(hours<10){
        	 rs.put("code", 0);
             rs.put("msg",
                 "距离开始时间小于10小时，不允许退订");
             return rs;
        }
        
        model.setOrderStatus(2);
        orderInfoMapper.updateByPrimaryKey(model);
        
        UserInfo user = userInfoMapper.selectByPrimaryKey(model.getUserId());
        user.setUserAccount(user.getUserAccount()+model.getTotalAmount());
        userInfoMapper.updateByPrimaryKeySelective(user);//退订时间加回来
        
        rs.put("code", 1);
        rs.put("msg",
            "退订成功");

        return rs;
    }
}

