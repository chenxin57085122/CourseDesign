package com.xinyuan.main.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 11:45
 * @Description:
 */
public class StringUtil {

    /**
     *
     * 功能描述: 生产8位不重复字符串
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:48
     */
    public static String getId(){
        return RandomStringUtils.random(8,"abcdefghijklmnopqrstuvwxyz1234567890");
    }

    /**
     *
     * 功能描述: 将字符串以'，'分割成list
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 12:34
     */
    public static List<String> strToList(String target){
        String[] str = target.split(",");
        List<String> list = new ArrayList<>();
        for (String temp : str) {
            list.add(temp);
        }
        return list;
    }
}
