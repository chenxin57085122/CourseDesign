package com.xinyuan.main;

import com.xinyuan.main.dao.ShoppingAddressMapper;
import com.xinyuan.main.domain.ShoppingAddress;
import com.xinyuan.main.service.ShoppingAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 14:43
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class ShoppingAddressServiceTest {

    @Autowired
    private ShoppingAddressService shoppingAddressService = null;

    @Autowired
    private ShoppingAddressMapper shoppingAddressMapper = null;




    /**
     *
     * 功能描述: 测试查询收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 14:44
     */
    @Test
    public void selectAddressByUserId(){
        List<ShoppingAddress> list = shoppingAddressService.selectByUserId(1);
        System.out.println(list);

        ShoppingAddress shoppingAddress = shoppingAddressMapper.selectByPrimaryKey(1);
        System.out.println(shoppingAddress);

    }

    /**
     *
     * 功能描述: 测试修改默认收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:20
     */
    @Test
    public void updateDefaultTest(){
        ShoppingAddress shoppingAddress = new ShoppingAddress();
        shoppingAddress.setId(3);
        shoppingAddressService.reviseDefaultAddress(shoppingAddress);
    }
}
