package com.xinyuan.main.service;

import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.vo.ShoppingCart;

import java.util.List;
import java.util.Map;

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

    /**
     *
     * 功能描述: 购物车添加商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 19:41
     */
    int addProduct(CartMap cartMap);

    /**
     *
     * 功能描述:删除商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 19:42
     */
    int deleteProduct(CartMap cartMap);

    /**
     *
     * 功能描述: 删除选中的商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:15
     */
    int deleteChecked(String account);

    /**
     *
     * 功能描述: 全选商品、取消全部商品选定
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:32
     */
    int productAllchecked(Map<String, String> map);
}
