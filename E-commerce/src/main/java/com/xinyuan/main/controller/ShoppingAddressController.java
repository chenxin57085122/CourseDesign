package com.xinyuan.main.controller;

import com.xinyuan.main.domain.ShoppingAddress;
import com.xinyuan.main.service.ShoppingAddressService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 22:31
 * @Description:
 */
@RestController
@RequestMapping("/shoppingAddress")
public class ShoppingAddressController {

    @Autowired
    private ShoppingAddressService shoppingAddressService = null;

    @PostMapping("/insert")
    public ServiceVO insert(@RequestBody ShoppingAddress shoppingAddress){
        return new ServiceVO(shoppingAddressService.insertSelective(shoppingAddress));
    }
}
