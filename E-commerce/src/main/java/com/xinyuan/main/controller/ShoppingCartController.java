package com.xinyuan.main.controller;

import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.service.ShoppingCartService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:26
 * @Description:
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCatService = null;

    /**
     *
     * 功能描述: 查询购物车
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 0:38
     */
    @GetMapping("/info/{acount}")
    public ServiceVO selectShoppingCartByUserId(@PathVariable("acount") String acount){
        return new ServiceVO(shoppingCatService.selectShoppingCartByUserId(acount));
    }

    /**
     *
     * 功能描述: 购物车添加商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 0:38
     */
    @PostMapping("/addCart")
    public ServiceVO addCart(@RequestBody CartMap cartMap){

        ;
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.addProduct(cartMap)).builder();
    }
}
