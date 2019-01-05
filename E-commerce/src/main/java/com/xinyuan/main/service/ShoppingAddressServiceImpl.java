package com.xinyuan.main.service;

import com.xinyuan.main.dao.ShoppingAddressMapper;
import com.xinyuan.main.domain.ShoppingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 22:29
 * @Description:
 */
@Service("shoppingAddressService")
public class ShoppingAddressServiceImpl implements ShoppingAddressService {

    @Autowired
    private ShoppingAddressMapper shoppingAddressMapper = null;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    @Override
    public int insertSelective(ShoppingAddress shoppingAddress) {
        ShoppingAddress temp = shoppingAddressMapper.selectDefaultAddress(shoppingAddress.getUserId());
        if(temp != null && shoppingAddress.getIsDefault()){

            temp.setIsDefault(false);
            shoppingAddressMapper.updateByPrimaryKeySelective(temp);
        }
        return shoppingAddressMapper.insertSelective(shoppingAddress);
    }

    @Override
    public List<ShoppingAddress> selectByUserId(int id) {
        return shoppingAddressMapper.selectByUserId(id);
    }

    /**
     * 功能描述: 删除收货地址
     *
     * @param id
     * @param: id
     * @return: delete column count
     * @auther: chenxin
     * @date: 2019/1/5 16:31
     */
    @Override
    public int deletet(int id) {
        return shoppingAddressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 功能描述: 删除收货地址
     *
     * @param list
     * @param: list
     * @return: delete colum count
     * @auther: chenxin
     * @date: 2019/1/5 16:31
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    @Override
    public int deleteList(List<Integer> list) {
        for (int temp : list){
            shoppingAddressMapper.deleteByPrimaryKey(temp);
        }
        return 0;
    }

    /**
     * 功能描述: 修改默认收货地址
     *          通过收货地址id获取userId,
     *          通过userId 查询该用户当前的默认地址，
     *          存在：将当前默认地址改为false，update
     *          将id的收货地址设为默认收货地址
     * @param
     * @param: id
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 16:33
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public int reviseDefaultAddress(ShoppingAddress defaultAddr) {

        ShoppingAddress shoppingAddress = shoppingAddressMapper.selectByPrimaryKey(defaultAddr.getId());
        if (shoppingAddress != null){
            ShoppingAddress originAddr =  shoppingAddressMapper.selectDefaultAddress(shoppingAddress.getUserId());
            if (originAddr != null){
                originAddr.setIsDefault(false);
                shoppingAddressMapper.updateByPrimaryKeySelective(originAddr);
            }
            defaultAddr.setIsDefault(true);
            return shoppingAddressMapper.updateByPrimaryKeySelective(defaultAddr);

        }
        return 0;
    }

}
