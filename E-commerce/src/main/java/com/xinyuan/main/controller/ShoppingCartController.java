package com.xinyuan.main.controller;

import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.CartMap02;
import com.xinyuan.main.service.ShoppingCartService;
import com.xinyuan.main.utils.ServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:26
 * @Description: return 中的code：1 成功
 *                                  0 失败
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private static Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

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
        logger.info(acount);
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

        ;logger.info(cartMap.toString());
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.addProduct(cartMap)).builder();
    }

    /**
     *
     * 功能描述: 删除单个商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 19:58
     */
    @PostMapping("/delete")
    public ServiceVO deleteProduct(@RequestBody CartMap cartMap){
        logger.info(cartMap.toString());
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.deleteProduct(cartMap)).builder();
    }

    /**
     *
     * 功能描述: 删除被选中的商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:29
     */
    @DeleteMapping("/delete/{account}")
    public ServiceVO deleteByChecked(@PathVariable("account") String account){
        logger.info(account);
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.deleteChecked(account)).builder();
    }


    /**
     *
     * 功能描述: 选中用户购物车中的所有商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:42
     */
    @PostMapping("/checkedProduct")
    public ServiceVO productAllchecked(@RequestBody Map<String, String> map){
        logger.info(map.toString());
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.productAllchecked(map)).builder();
    }


    @PostMapping("/updateProductInfo")
    public ServiceVO updateProduct(@RequestBody CartMap02 cartMap02){
        logger.info(cartMap02.toString());
        return new ServiceVO.ServiceVOBuilder().code(shoppingCatService.updateProduct(cartMap02)).builder();
    }
}
