package com.xinyuan.main.dao;

import com.xinyuan.main.domain.ShoppingAddress;
import org.springframework.stereotype.Component;

@Component
public interface ShoppingAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingAddress record);

    int insertSelective(ShoppingAddress record);

    ShoppingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingAddress record);

    int updateByPrimaryKey(ShoppingAddress record);
}