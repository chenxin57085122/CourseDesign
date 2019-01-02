package com.xinyuan.main.controller;

import com.xinyuan.main.domain.User;
import com.xinyuan.main.service.UserService;
import com.xinyuan.main.utils.ServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @Auther: chenxin
 * @Date: 2019/1/2 15:29
 * @Description: 提供与用户相关的API
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService = null;

    @PostMapping("/login")
    public ServiceVO login(@RequestBody Map<String,String> user){
        logger.info(user.toString());
        if(userService.login(user.get("username"),user.get("password")))
            return new ServiceVO<>();

        return new ServiceVO.ServiceVOBuilder().
                code(2).
                message("username or password error!").
                builder();
    }

    @PostMapping("/register")
    public ServiceVO reister(@RequestBody User user){
        userService.reister(user);
        return new ServiceVO();
    }

}
