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


    /**
     *
     * 功能描述: 查询用户信息
     *
     * @param: id
     * @return: User
     * @auther: chenxin
     * @date: 2019/1/5 10:20
     */
    User selectByPrimaryKey(int id);
}
