package com.xinyuan.main;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chenxin
 * @Date: 2018/12/30 17:13
 * @Description:
 */
@RestController
public class RestTest {

    @PostMapping("/test")
    public String test(@RequestBody String abc){
        System.out.println(abc);
        return "success";
    }

}
