package com.xinyuan.main.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 23:33
 * @Description: 实现当前时间+1天
 */
public class DateUtil {

    public static Date addTime(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, +3);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(addTime());
    }
}
