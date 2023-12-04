package com.room.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class DateCommonUtils {
    public static void main(String[] args) {
        getEchartTimeList(null,null,"yyyy-MM-dd HH:mm:ss","yyyy年MM月dd日 HH:mm:ss",5);
    }
    public static List<String> getEchartTimeList(String startTime,String endTime,String format1,String format2,Integer type){
        SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
        Integer diff = 0;
        if(type==1){//年份相减
            diff=7;//默认七年内
            }else if(type==2){//月份相减
                diff=30;//默认30天内
                }else if(type==3){//日期相减
                    diff=7;//默认7天内
                    }else if(type==4){//小时
                        diff=24;//默认24小时内
                        }else if(type==5){//分钟
                            diff=60;//默认60分钟内
                        }
                        if(startTime==null||startTime.equals("")){
                            startTime = sdf1.format(getDiffTime( sdf1.format(new Date()), -diff, format1, type));
                        }
                        if(endTime==null||endTime.equals("")){
                            endTime = sdf1.format(getDiffTime(startTime, diff, format1, type));
                        }
                        List<String> rs = new ArrayList<String>();
                        String tmp = startTime;
                        rs.add(castTimeSdf(sdf1,sdf2,tmp));
                        while(true){
                            if(tmp.compareTo(endTime)<0){
                                String tmp2 = castTimeSdf(sdf1,sdf2,tmp);
                                if(checkIsIn(rs,tmp2)==false){
                                    rs.add(tmp2);
                                }
                                tmp =  sdf1.format(getDiffTime( tmp, 1, format1, type));
                                }else{
                                    break;
                                }
                            }
                            if(checkIsIn(rs,endTime)==false){
                                rs.add(castTimeSdf(sdf1,sdf2,endTime));
                            }
                            return rs;
                        }
                        /**
                        * 转换时间格式
                        * @param sdf1
                        * @param sdf2
                        * @param date
                        * @return
                        */
                        public static String castTimeSdf(SimpleDateFormat sdf1 ,SimpleDateFormat sdf2,String date){
                            Date d = null;
                            try {
                                d=sdf1.parse(date);
                                } catch (ParseException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                if(d==null){
                                    return "";
                                }
                                return sdf2.format(d);
                            }
                            private static boolean checkIsIn(List<String> list,String str){
                                boolean flag=false;
                                for(String s:list){
                                    if(s.equals(str)){
                                        flag=true;
                                        break;
                                    }
                                }
                                return flag;
                            }
                            /**
                            获取某个日期加上多少单位时间后的日期
                            */
                            public static Date getDiffTime(String date,Integer diff,String format1,Integer type){
                                SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
                                Date d = null;
                                try {
                                    d = sdf1.parse(date);
                                    } catch (ParseException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                    if(d==null){
                                        return null;
                                    }
                                    Calendar date2 = Calendar.getInstance();
                                    date2.setTime(d);
                                    if(type==1){//年份加减
                                        date2.add(Calendar.YEAR, diff);
                                        }else if(type==2){//月份加减
                                            date2.add(Calendar.MONTH, diff);
                                            }else if(type==3){//日期加减
                                                date2.add(Calendar.DATE, diff);
                                                }else if(type==4){//小时加减
                                                    date2.add(Calendar.HOUR_OF_DAY, diff);
                                                    }else if(type==5){//分钟加减
                                                        date2.add(Calendar.MINUTE, diff);
                                                    }
                                                    return date2.getTime();
                                                }
                                            }
