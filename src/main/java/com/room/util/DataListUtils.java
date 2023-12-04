package com.room.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 固定下拉列表解释器
 * @author Administrator
 *
 */
public class DataListUtils {
    public static void main(String[] args) {
    }

    /**
    **获取登录角色列表
    */
    public static List<Map<String, Object>> getLoginTypeList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "admin"));
        list.add(getMap("2", "user"));

        return list;
    }

    /**
    **获取desk_status数据列表
    */
    public static List<Map<String, Object>> getDeskStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "空闲"));
        list.add(getMap("2",
                "已被占用"));

        return list;
    }

    public static String getDeskStatusNameById(String id) { //根据desk_status的key值获取名称

        List<Map<String, Object>> list = getDeskStatusList();

        return getNameById(id, list);
    }

    /**
    **获取order_status数据列表
    */
    public static List<Map<String, Object>> getOrderStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "已预约"));
        list.add(getMap("2", "已退订"));
        list.add(getMap("3", "使用中"));
        list.add(getMap("4", "已使用"));

        return list;
    }

    public static String getOrderStatusNameById(String id) { //根据order_status的key值获取名称

        List<Map<String, Object>> list = getOrderStatusList();

        return getNameById(id, list);
    }

    public static String getNameById(String id, List<Map<String, Object>> list) {
        if (id == null) {
            return null;
        }

        if (id.endsWith(",")) {
            id = id.substring(0, id.length() - 1);
        }

        String[] idsplit = id.split(",");
        String rs = "";

        for (String tmp : idsplit) {
            for (Map<String, Object> map : list) {
                if (map.get("id").toString().equals(tmp)) {
                    rs += (map.get("name").toString() + ",");
                }
            }
        }

        if (rs.endsWith(",")) {
            rs = rs.substring(0, rs.length() - 1);
        }

        return rs;
    }

    private static Map<String, Object> getMap(String id, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);

        return map;
    }
}

