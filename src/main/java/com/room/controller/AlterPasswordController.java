package com.room.controller;

import com.room.dao.*;

import com.room.model.*;

import com.room.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi/alterPassword")
public class AlterPasswordController {
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
            进入修改密码页面接口
    */
    @RequestMapping("")
    public Object alterPassword(ModelMap modelMap, HttpServletRequest request,
        HttpServletResponse response) {
        LoginModel user = (LoginModel) request.getSession()
                                              .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", user);

        if (user == null) {
            return "redirect:/commonapi/login";
        }

        return "alter_password";
    }

    /**
            提交修改密码请求接口
    */
    @RequestMapping("submit")
    @ResponseBody
    public Object submit(ModelMap modelMap, String password1, String password2,
        String password3, HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel user = (LoginModel) request.getSession()
                                              .getAttribute(CommonVal.sessionName);

        if ((password1 == null) || (password2 == null) || (password3 == null)) {
            rs.put("rs", 0);
            rs.put("msg",
                "系统异常");

            return rs;
        }

        if (password2.equals(password3) == false) {
            rs.put("rs", 0);
            rs.put("msg",
                "两次密码输入不一致");

            return rs;
        }

        if (user.getLoginType() == 1) { //管理员角色修改密码

            AdminInfo l = adminInfoMapper.selectByPrimaryKey(user.getId());

            if (l.getPassword().equals(password1) == false) { //检查该账号原有密码   
                rs.put("code", 0);
                rs.put("msg",
                    "旧密码输入错误");

                return rs;
            }

            if (l.getPassword().equals(password2)) { //新密码不能和原密码一样  
                rs.put("code", 0);
                rs.put("msg",
                    "新密码不能和原密码一致");

                return rs;
            }

            l.setPassword(password2); //设置为新密码 
            adminInfoMapper.updateByPrimaryKeySelective(l);
        }

        if (user.getLoginType() == 2) { //用户角色修改密码

            UserInfo l = userInfoMapper.selectByPrimaryKey(user.getId());

            if (l.getPassword().equals(password1) == false) { //检查该账号原有密码   
                rs.put("code", 0);
                rs.put("msg",
                    "旧密码输入错误");

                return rs;
            }

            if (l.getPassword().equals(password2)) { //新密码不能和原密码一样  
                rs.put("code", 0);
                rs.put("msg",
                    "新密码不能和原密码一致");

                return rs;
            }

            l.setPassword(password2); //设置为新密码 
            userInfoMapper.updateByPrimaryKeySelective(l);
        }

        rs.put("rs", 1);
        rs.put("msg",
            "密码修改成功,会在下次登录生效");

        return rs;
    }
}

