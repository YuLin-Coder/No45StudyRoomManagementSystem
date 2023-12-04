package com.room.controller;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.room.util.CommonVal;
import com.room.util.ImgRandomCodeUtils;
/**
 * 
图片验证码生成接口，该接口用来生成一张带有4位随机码的图片
 *
 */
@Controller
public class CodeController {
	@RequestMapping("/commonapi/code") 
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		ImgRandomCodeUtils rdnu = ImgRandomCodeUtils.Instance();//图片验证码生成器
		HttpSession session = req.getSession(); 
		// 取得随机字符串放入Session中
		session.setAttribute(CommonVal.code, rdnu.getString());//将该验证码存入session中
		// 禁止图像缓存。  
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos);//返回给前台
        sos.close(); 
    }
}
