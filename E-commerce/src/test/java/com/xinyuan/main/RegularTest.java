package com.xinyuan.main;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: chenxin
 * @Date: 2019/1/2 19:00
 * @Description:
 */
public class RegularTest {

    @Test
    public void email(){
        Pattern pattern = Pattern.compile("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$");
        Matcher matcher = pattern.matcher("chenxin1234@163.com");
        System.out.println(matcher.matches());
    }

    @Test
    public void phone(){
        Pattern pattern = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        Matcher matcher = pattern.matcher("18336038878");
        System.out.println(matcher.matches());
    }
}
