package com.room.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class CommonUtils {

	/**
		根据传入date计算该事件加上多少天/分/时/月/年的时间
	*/
	public static String getDiffDate(String date,int time,SimpleDateFormat df,Integer timeType){
		Date d =null;
		try {
			d=df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar calendar=Calendar.getInstance();   
		calendar.setTime(d); 
		if(timeType==1){//分
			calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+time);//分
		}else if(timeType==2){//时
			calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)+time);//让日期加上天数	
		}else if(timeType==3){//天
			calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+time);//让日期加上天数	
		}else if(timeType==4){//月份
			calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+time);//让日期加上天数	
		}else if(timeType==5){//年
			calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+time);//让日期加上天数	
		}
		   return df.format(calendar.getTime());
	}
	
	
	// 打乱顺序
    public static <T> void shuffle(List<T> list) {
        int size = list.size();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            // 获取随机位置
            int randomPos = random.nextInt(size);
            // 当前元素与随机元素交换
            Collections.swap(list, i, randomPos);
        }
    }
    
    public static int getDays(Date date1,Date date2){
		long daysBetween=(date2.getTime()-date1.getTime()+1000000)/(60*60*24*1000);
		return (int)daysBetween;
	}
    
    public static int getHours(String  d1,String d2){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date1 = null;
    	Date date2 = null;
    	
    	try {
    		date1=sdf1.parse(d1);
    		date2=sdf1.parse(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
 		long hoursBetween=(date2.getTime()-date1.getTime()+1000000)/(60*60*1000);
 		return (int)hoursBetween;
 	}
    /**
    	检查是否数据项相同
    **/
    private boolean  checkIsEqual(String str,String str2){
		if(str==null||str2==null){
			return false;
		}
		String [] split1 = str.split(",");
		String [] split2 = str2.split(",");
		boolean isCompete=true;
		for(String tmp:split2){
			if(str.contains(tmp+",")==false&&str.contains(","+tmp)==false&&str.equals(""+tmp)==false){
				isCompete=false;
				break;
			}
		}
		boolean isCompete2=true;
		for(String tmp:split1){
			if(str2.contains(tmp+",")==false&&str2.contains(","+tmp)==false&&str2.equals(""+tmp)==false){
				isCompete2=false;
				break;
			}
		}	
		return isCompete&&isCompete2;
	}
	  /**
    	检查str是否包含str2所有数据项
    **/
	private boolean  checkIsContain(String str,String str2){
		if(str==null||str2==null){
			return false;
		}
		String [] split = str2.split(",");
		boolean isCompete=true;
		for(String tmp:split){
			if(str.contains(tmp+",")==false&&str.contains(","+tmp)==false&&str.equals(""+tmp)==false){
				isCompete=false;
				break;
			}
		}
		return isCompete;
	}
	
		/**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value=null;
			try {
				value = field.get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            map.put(fieldName, value);
        }
        return map;
    }
    
    
    public static String coverToShowTime(String timeStr, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date updateTime = null;
		try {
			updateTime = sf.parse(timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time = (System.currentTimeMillis() - updateTime.getTime()) / 1000;
		// 小于60 秒显示刚刚
		String result = sf.format(updateTime);
		long temp = 0;
		if (time < 60) {
			result = "刚刚";
			// 小于60分钟直接显示几分钟前
		} else if ((temp = time / 60) < 60) {
			result = temp + "分钟前";
			// 小于24小时直接显示几小时前
		} else if ((temp = time / (60 * 60)) < 24) {
			result = temp + "小时前";
			// 小于7天显示几天前
		} else if ((temp = time / (86400)) < 7) {
			result = temp + "天前";
			// //大于7天小于14天显示1周前
		} else if ((temp = time / (86400 * 7)) < 2) {
			result = temp + "周前";
		} else {
			result = timeStr;
		}
		return result;
	}
	
	
	public static String hideStr(String str,Integer preStrNum,Integer laterStrNum,String replaceStr){
		replaceStr = replaceStr+replaceStr+replaceStr+replaceStr+replaceStr+replaceStr;
		return str.replaceAll("([\\s\\S]{"+preStrNum+"})[\\s\\S]+([\\s\\S]{"+laterStrNum+"})","$1"+replaceStr+"$2");
	}
	
	
		private static char [] numlist = new char[]{'0','1','2','3','4','5','6','7','8','9','一','二','三','四','五','六','七',
		'八','九','零','壹','贰','叁','肆','伍','陆','柒','捌','玖','拾'};//可以表达数字的字符
	private static char [] specialWord=new char []{' ',',','.','-','_','+',':','~','/','，','	','(',')',';','：','；','[','【',']','】','、'};
	/**
	 * 检查字符中是否有联系方式
	 * @param str
	 * @return
	 */
	public static boolean checkHasConnectMsg(String str){
		char[] chars = str.toCharArray();
		int num=0;
		for(int i=0;i<chars.length;i++){
			boolean isCompete=false;
			for(char str2:numlist){
				if(str2==chars[i]){
					num++;
					isCompete=true;
					break;
				}
			}
			boolean isSpecial=false;
			for(char str2:specialWord){
				if(str2==chars[i]){
					isSpecial=true;
					break;
				}
			}
			if(isCompete==false&&isSpecial==false){
				num=0;
			}
			if(num>5){//大于5个连续数字
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据返回列表进行分页
	 * @param list
	 * @param maxNum
	 * @param perNum
	 * @return
	 */
	public static List<List> splitList(List list,int maxNum,int perNum){
		List<List> list2 = new ArrayList<List>();
		List<Object> list3 = PageUtils.getCurrentPageList(list, 1, maxNum);
		int totalPage =0;
		if(list.size()>0){
			if(list.size()%perNum==0){
				totalPage = list3.size()/perNum;	
			}else{
				totalPage = list3.size()/perNum+1;
			}
		}
		//1页  0~3
		//2  4-7
		//3 8-11
		for(int i=1;i<=totalPage;i++){
			if(list3.size()<((i)*perNum)){
				List<Object> tmp = new ArrayList<Object>();
				tmp.addAll(list3.subList((i-1)*perNum, list3.size()));
				list2.add(tmp);
			}else{
				List<Object> tmp = new ArrayList<Object>();
				tmp.addAll(list3.subList((i-1)*perNum, (i-1)*perNum+(perNum)));
				list2.add(tmp);
			}
		}
		return list2;
	}
}
