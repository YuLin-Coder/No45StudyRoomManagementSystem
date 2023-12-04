package com.room.task;
import java.util.Map;
import java.util.HashMap;
import com.room.controller.LoginModel;
import com.room.model.*;
import com.room.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.room.service.*;
import  java.io.InputStream;
import   java.text.SimpleDateFormat;
import  com.room.util.*;
import   org.springframework.ui.ModelMap;
import   java.util.regex.Pattern;
import  java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
@Component 
public class TaskServiceExcute {
@Autowired
TaskService taskService;
//定时更新桌子状态，定时更新订单状态,定时规则：每分钟执行一次
 @Scheduled(cron="0 0/1 * * * ?")  
public void taskService(){
	taskService.taskService();
}
}
