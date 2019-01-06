package com.xinyuan.algorithmStudy;

/**
 * @Auther: chenxin
 * @Date: 2019/1/6 12:16
 * @Description: 验证字符串是否能表示为数值
 */
public class Solution {
    private int index = 0;

    public  static boolean isNumeric(char[] str){
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }


    public  boolean isNumber(char[] str){
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;
    }

    private  boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index ++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start =index;
        while(index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index;
    }


}
