package com.xinyuan.main.controller;

import com.xinyuan.main.domain.User;
import com.xinyuan.main.service.UserService;
import com.xinyuan.main.utils.ServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     *
     * 功能描述: 用户登录
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:48
     */
    @PostMapping("/login")
    public ServiceVO<User> login(@RequestBody Map<String,String> user){
        logger.info(user.toString());
        User res = userService.login(user.get("username"),user.get("password"));
        if (res != null){
            return new ServiceVO(res);
        }
        return new ServiceVO.ServiceVOBuilder().message("username or password is error!").code(500).builder();
    }

    /**
     *
     * 功能描述: 用户注册
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:48
     */
    @PostMapping("/register")
    public ServiceVO<Integer> register(@RequestBody User user){

        return new ServiceVO(userService.reister(user));
    }

    /**
     *
     * 功能描述: 修改用户信息
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:48
     */
    @PostMapping("/update/userInfo")
    public ServiceVO<Integer> updateUserInfo(@RequestBody User user){

        return new ServiceVO(userService.updateUserInfor(user));
    }

    /**
     *
     * 功能描述: 读取用户信息
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:48
     */
    @GetMapping("/read/user/{id}")
    public ServiceVO readUserInfoById(@PathVariable("id") int id){
        if (id < 1) return new ServiceVO.ServiceVOBuilder().message("登出").code(2).builder();

        return new ServiceVO(userService.selectByPrimaryKey(id));
    }

}
