package com.xinyuan.main;

import com.xinyuan.main.domain.User;
import com.xinyuan.main.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 17:28
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService = null;

    /**
     *
     * 功能描述: 测试用户更新信息功能
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/3 17:31
     */
    @Test
    public void updateUserInfo(){
        User user = new User();
        user.setId(2);
        user.setEmail("3406985294@qq.com");
        System.out.println(userService.updateUserInfor(user));
    }
}
