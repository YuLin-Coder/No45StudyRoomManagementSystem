package com.room.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
/**
* 生成随机数字验证码
*
* @author zh
*
*/
public class ImgRandomCodeUtils {
    private ByteArrayInputStream byteImg;	// byte图像1
    private BufferedImage buffImg;			// buff图像2
    private String str;						// 验证码
    private int codeCount = 4;				// 定义图片上显示验证码的个数
    private int xx = 28; 					// 验证码水平位置偏移
    private int codeY = 30; 				// 验证码垂直位置偏移
    private int fontHeight = 30; 			// 字体大小
    private int runLin = 60;				// 干扰线数
    private int red = 255, green = 100, blue = 50; // 字体数值范围内的随机颜色
    private int bgfc = 150, bgbc = 200;		// 背景颜色
    private int linfc = 200, linbc = 250;	// 干扰线颜色
    private int width = 158, height =40;	// 图像的宽，高
    //不包含字母 i l o I，数字 0 1
    char[] codeSequence = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '2', '3', '4', '5', '6', '7', '8', '9',
    };
    private int ruNumber = codeSequence.length-1; //0~ruNumber之间的随着自然数 获得验证码
    private ImgRandomCodeUtils() {
        init();// 初始化属性
    }
    /**
    * 取得RandomNumUtil实例
    */
    public static ImgRandomCodeUtils Instance() {
        return new ImgRandomCodeUtils();
    }
    /**
    * 取得验证码图片byteImg
    */
    public ByteArrayInputStream GetByteImg() {
        return this.byteImg;
    }
    /**
    * 取得验证码图片buffImg
    */
    public BufferedImage getBuffImg() {
        return this.buffImg;
    }
    /**
    * 取得图片的验证码字符串
    */
    public String getString() {
        return this.str;
    }
    /**
    * 初始化属性
    */
    private void init() {
        // 在内存中创建图象
        BufferedImage buffImg = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = buffImg.getGraphics();
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(getRandColor(bgfc, bgbc));
        g.fillRect(0, 0, width, height);
        // 设定字体
        g.setFont(new Font("Times New Roman", Font.BOLD, fontHeight));
        // 随机产生runLin条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(linfc, linbc));
        for (int i = 0; i < runLin ; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        //随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(ruNumber)]); //0~ruNumber之间的随着自然数
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            // 用随机产生的颜色将验证码绘制到图像中。
            g.setColor(new Color(random.nextInt(red), random.nextInt(green), random.nextInt(blue)));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(code, (i + 1) * xx, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        // 赋值验证码
        this.str = randomCode.toString();
        // 图象生效
        g.dispose();
        /************赋值byte图像1 输出图片流**************/
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO
            .createImageOutputStream(output);
            ImageIO.write(buffImg, "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
            } catch (Exception e) {
                System.out.println("验证码图片产生出现错误：" + e.toString());
            }
            this.byteImg = input;	// 赋值byte图像1
            /************赋值buff图像2 输出图像**************/
            this.buffImg = buffImg; // 赋值buff图像2
        }
        /**
        * 给定范围获得随机颜色
        */
        private Color getRandColor(int fc, int bc) {
            Random random = new Random();
            if (fc > 255)
            fc = 255;
            if (bc > 255)
            bc = 255;
            int r = fc + random.nextInt(bc - fc);
            int g = fc + random.nextInt(bc - fc);
            int b = fc + random.nextInt(bc - fc);
            return new Color(r, g, b);
        }
    }
