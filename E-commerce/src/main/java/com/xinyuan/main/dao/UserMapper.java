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

    /**
     * 用户信息更改
     * @param record
     * @return 返回影响sql语句行数
     */
    int updateByPrimaryKeySelective(User record);


    /**
     * 用户账号验证:
     * 账号
     * 邮箱
     * 手机
     */
    User loginByAccount(@Param("account") String account,@Param("password") String password);
    User loginByEmail(@Param("account") String account,@Param("password") String password);
    User loginByPhone(@Param("account") String account,@Param("password") String password);
}