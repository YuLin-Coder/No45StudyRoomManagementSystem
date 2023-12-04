package com.room.controller.user;

import com.room.controller.LoginModel;

import com.room.dao.*;

import com.room.model.*;

import com.room.service.*;

import com.room.util.CommonVal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/index")
public class USIndexController {
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      用户角色进入管理首页接口
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        UserInfo user = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", user);

        modelMap.addAttribute("roleName", "用户");
        modelMap.addAttribute("login", login);

        return "user/index";
    }
}

