package com.xinyuan.main.service;

import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.vo.ShoppingCart;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:08
 * @Description:
 */
public interface ShoppingCartService {
    /**
     *
     * 功能描述: 查询购物车
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 22:11
     */
    List<ShoppingCart> selectShoppingCartByUserId(String account);

    int addProduct(CartMap cartMap);


}
