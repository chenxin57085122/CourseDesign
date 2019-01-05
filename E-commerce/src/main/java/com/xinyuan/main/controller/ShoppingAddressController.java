package com.xinyuan.main.controller;

import com.xinyuan.main.domain.ShoppingAddress;
import com.xinyuan.main.service.ShoppingAddressService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /**
     *
     * 功能描述:添加收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:10
     */

    @PostMapping("/insert")
    public ServiceVO insert(@RequestBody ShoppingAddress shoppingAddress){
        return new ServiceVO(shoppingAddressService.insertSelective(shoppingAddress));
    }

    /**
     *
     * 功能描述: 查询用户的收货地址
     *
     * @param: userId
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:11
     */
    @GetMapping("/selectByUserId/{userId}")
    public ServiceVO selectByUserId(@PathVariable("userId") Integer userId){
        return new ServiceVO(shoppingAddressService.selectByUserId(userId));
    }

    /**
     *
     * 功能描述: 单个删除收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:08
     */
    @DeleteMapping("/delete/{id}")
    public ServiceVO deleteById(@PathVariable("id") int id){

        return new ServiceVO(shoppingAddressService.deletet(id));
    }

    /**
     *
     * 功能描述: 批量删除收货地址
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 17:12
     */
    @DeleteMapping("/deleteList/{list}")
    public ServiceVO deleteListById(@PathVariable("list")List<Integer> list){
        return new ServiceVO(shoppingAddressService.deleteList(list));
    }

    @PutMapping("/reviseDefaultAddress")
    public ServiceVO reviseDefaultAddress(@RequestBody ShoppingAddress shoppingAddress){
        return new ServiceVO(shoppingAddressService.reviseDefaultAddress(shoppingAddress));
    }
}
