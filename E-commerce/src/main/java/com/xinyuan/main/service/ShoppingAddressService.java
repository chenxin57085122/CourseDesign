package com.xinyuan.main.service;

import com.xinyuan.main.domain.ShoppingAddress;

import java.util.List;

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

    /**
     *
     * 功能描述: 查询用户收获地址
     *
     * @param: userId
     * @return: 收货地址
     * @auther: chenxin
     * @date: 2019/1/5 11:34
     */
    List<ShoppingAddress> selectByUserId(int id);

    /**
     *
     * 功能描述: 删除收货地址
     *
     * @param: id
     * @return: delete column count
     * @auther: chenxin
     * @date: 2019/1/5 16:31
     */
    int deletet(int id);

    /**
     *
     * 功能描述: 删除收货地址
     *
     * @param: list
     * @return: delete colum count
     * @auther: chenxin
     * @date: 2019/1/5 16:31
     */
    int deleteList(List<Integer> list);

    /**
     *
     * 功能描述: 修改默认收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 16:33
     */
    int reviseDefaultAddress(ShoppingAddress defaultAddr);
}
