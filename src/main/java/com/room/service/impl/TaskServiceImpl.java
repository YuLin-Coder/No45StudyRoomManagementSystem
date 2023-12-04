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
public class TaskServiceImpl implements TaskService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    DeskInfoMapper deskInfoMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
    
    @Override
    public void taskService() {
    	String now  = sdf1.format(new Date());
    	
    	OrderInfoExample oe = new OrderInfoExample();
		OrderInfoExample.Criteria oc = oe.createCriteria();
		oc.andOrderStatusNotEqualTo(2);
		List<OrderInfo> ol = orderInfoMapper.selectByExample(oe);
		for(OrderInfo o:ol){
			   String hour1="";
		        if(o.getStartTime()<10){
		        	hour1="0"+o.getStartTime();
		        }
		        String startTime = o.getOrderDate()+" "+hour1+":00:00";
		        
		        String hour2="";
		        if(o.getEndTime()<10){
		        	hour2="0"+o.getEndTime();
		        }
		        String endTime = o.getOrderDate()+" "+hour2+":00:00";
		     if(o.getOrderStatus()==1){
		    	 if(startTime.compareTo(now)<=0&&endTime.compareTo(now)>=0){
						o.setOrderStatus(3);
						orderInfoMapper.updateByPrimaryKeySelective(o);
					}
		     }
		     if(o.getOrderStatus()==3){
		    	 if(endTime.compareTo(now)<0){
						o.setOrderStatus(4);
						orderInfoMapper.updateByPrimaryKeySelective(o);
					}
		     }
			
			
		}
    	
    	DeskInfoExample de = new DeskInfoExample();
    	List<DeskInfo> dl = deskInfoMapper.selectByExample(de);
    	for(DeskInfo d:dl){//判断桌子当前有没有被使用
    		OrderInfoExample oe2 = new OrderInfoExample();
    		OrderInfoExample.Criteria oc2 = oe2.createCriteria();
    		oc2.andDeskIdEqualTo(d.getId());
    		oc2.andOrderStatusEqualTo(3);
    		int count  = (int) orderInfoMapper.countByExample(oe2);
    		if(count==0){
    			d.setDeskStatus(1);
    		}else{
    			d.setDeskStatus(2);
    		}
    		deskInfoMapper.updateByPrimaryKeySelective(d);
    	}
    }
}

