package com.xinyuan.main.dao;

import com.xinyuan.main.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);


    /**
     * 用户账号验证:
     * 账号
     * 邮箱
     * 手机
     */
    Integer loginByAccount(@Param("account") String account,@Param("password") String password);
    Integer loginByEmail(@Param("account") String account,@Param("password") String password);
    Integer loginByPhone(@Param("account") String account,@Param("password") String password);
}