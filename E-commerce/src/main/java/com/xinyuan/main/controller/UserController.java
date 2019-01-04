package com.xinyuan.main.controller;

import com.xinyuan.main.domain.User;
import com.xinyuan.main.service.UserService;
import com.xinyuan.main.utils.ServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Auther: chenxin
 * @Date: 2019/1/2 15:29
 * @Description: 提供与用户相关的API
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService = null;

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public ServiceVO login(@RequestBody Map<String,String> user){
        logger.info(user.toString());
        User res = userService.login(user.get("username"),user.get("password"));
        if (res != null){
            return new ServiceVO(res);
        }
        return new ServiceVO.ServiceVOBuilder().message("username or password is error!").code(500).builder();
    }

    @PostMapping("/register")
    public ServiceVO reister(@RequestBody User user){
        userService.reister(user);
        return new ServiceVO();
    }

    @PostMapping("/update/userInfo")
    public ServiceVO updateUserInfo(@RequestBody User user){

        userService.reister(user);

        return new ServiceVO();
    }
}
