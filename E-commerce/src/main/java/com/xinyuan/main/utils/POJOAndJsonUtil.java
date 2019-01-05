package com.xinyuan.main.utils;

import net.sf.json.JSONObject;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:18
 * @Description:
 */
public class POJOAndJsonUtil{

    /**
     *
     * 功能描述: 将Java 对象转换为json
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 22:22
     */
    public static String POJOToJson(Object obj){
        return JSONObject.fromObject(obj).toString();
    }

    /**
     *
     * 功能描述: 将json 转换为Java
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 22:23
     */
    public static Object JsonToPOJO(JSONObject jsonObject,Class clazz){
        return JSONObject.toBean(jsonObject,clazz);
    }
}
