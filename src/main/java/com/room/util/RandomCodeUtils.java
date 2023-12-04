package com.room.util;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
public class RandomCodeUtils {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String getRandomCode(){//获取6位随机码
        Random rand = new Random();
        String ranInt = rand.nextInt(1000000)+"";
        int len = ranInt.length();
        for(int i=len;i<6;i++){
            ranInt="0"+ranInt;
        }
        return ranInt;
    }
}
