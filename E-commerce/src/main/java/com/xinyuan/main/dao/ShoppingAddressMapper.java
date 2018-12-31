package com.xinyuan.main.dao;

import com.xinyuan.main.domain.ShoppingAddress;

public interface ShoppingAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingAddress record);

    int insertSelective(ShoppingAddress record);

    ShoppingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingAddress record);

    int updateByPrimaryKey(ShoppingAddress record);
}