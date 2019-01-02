package com.xinyuan.main.annotation;

import java.lang.annotation.*;

/**
 * @Auther: chenxin
 * @Date: 2019/1/2 19:25
 * @Description:日志
 */
@Documented
@Inherited
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface LogAn {
    public String method();

}
