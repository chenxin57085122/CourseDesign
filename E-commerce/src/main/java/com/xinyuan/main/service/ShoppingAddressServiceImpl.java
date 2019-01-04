package com.xinyuan.main.service;

import com.xinyuan.main.dao.ShoppingAddressMapper;
import com.xinyuan.main.domain.ShoppingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 22:29
 * @Description:
 */
@Service("shoppingAddressService")
public class ShoppingAddressServiceImpl implements ShoppingAddressService {

    @Autowired
    private ShoppingAddressMapper shoppingAddressMapper = null;
    @Override
    public int insertSelective(ShoppingAddress shoppingAddress) {

        return shoppingAddressMapper.insertSelective(shoppingAddress);
    }
}
