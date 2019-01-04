package com.xinyuan.main.service;

import com.xinyuan.main.domain.ShoppingAddress;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 22:28
 * @Description:
 */
public interface ShoppingAddressService {

    /**
     *
     * 功能描述: 添加收货人地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/4 22:29
     */
    int insertSelective(ShoppingAddress shoppingAddress);
}
