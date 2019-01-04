package com.xinyuan.main.service;

import com.xinyuan.main.domain.User;

/**
 * @Auther: chenxin
 * @Date: 2019/1/2 14:16
 * @Description:
 */
public interface UserService {

    /**
     * 登录验证
     * @return
     */
    User login(String account,String password);

    /**
     * 注册账号
     * @param user
     * @return
     */
    int reister(User user);

    /**
     *
     * @param user
     * @return
     */
    int updateUserInfor(User user);


}
