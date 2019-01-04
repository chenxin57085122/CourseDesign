package com.xinyuan.main.service;

import com.xinyuan.main.annotation.LogAn;
import com.xinyuan.main.dao.UserMapper;
import com.xinyuan.main.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @Auther: chenxin
 * @Date: 2019/1/2 14:17
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper = null;

    /**
     * 用户通过（用户名/邮箱/账号）登录
     * @param account
     * @param password
     * @return
     */
    @LogAn(method = "login")
    @Override
    public User login(String account,String password) {

        //邮箱正则表达式
        boolean flag = Pattern.matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$",account);
        int count = 0;
        if (flag){
            return userMapper.loginByEmail(account, password);
        }else if(Pattern.matches("^1(3|4|5|7|8)\\d{9}$",account)){
            return userMapper.loginByPhone(account, password);
        }else{
            return userMapper.loginByAccount(account, password);
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public int reister(User user) {

        return userMapper.insertSelective(user);
    }

    /**
     * 用户信息更改
     * @param user
     * @return
     */
    @Override
    public int updateUserInfor(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }



}
