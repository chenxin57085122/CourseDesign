package com.xinyuan.main.dao;

import com.xinyuan.main.domain.ShoppingAddress;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShoppingAddressMapper {

    List<ShoppingAddress> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ShoppingAddress record);

    ShoppingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingAddress record);

    /**
     *
     * 功能描述: 查询用户收货地址
     *
     * @param: 用户id
     * @return: 收货地址
     * @auther: chenxin
     * @date: 2019/1/5 11:33
     */
    List<ShoppingAddress> selectByUserId(int id);


    /**
     *
     * 功能描述: 查询默认收货地址
     *
     * @param: userId
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 16:52
     */
    ShoppingAddress selectDefaultAddress(int userId);

}