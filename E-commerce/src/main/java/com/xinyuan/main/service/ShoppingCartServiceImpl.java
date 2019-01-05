package com.xinyuan.main.service;

import com.xinyuan.main.dao.ProductMapper;
import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.Product;
import com.xinyuan.main.domain.vo.ShoppingCart;
import com.xinyuan.main.utils.POJOAndJsonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:15
 * @Description:
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private ListOperations listOperations = null;

    @Autowired
    private ProductMapper productMapper = null;
    /**
     * 功能描述: 查询购物车
     *
     * @param account
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 22:11
     */
    @Override
    public List<ShoppingCart>selectShoppingCartByUserId(String account) {

        List<ShoppingCart> rs = new ArrayList<>();
        List<String> lists = (List<String>) listOperations.range(account,0,-1);
        for (String list : lists){
            rs.add((ShoppingCart)POJOAndJsonUtil.JsonToPOJO(JSONObject.fromObject(list),ShoppingCart.class));
        }
        return rs;
    }

    /**
     *
     * 功能描述: 在购物车中添加商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 0:29
     */
    @Override
    public int addProduct(CartMap cartMap) {
        /**
         * 更新购物车中的物品数量
         */
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ShoppingCart> lists = selectShoppingCartByUserId(cartMap.getAccount());
        for (ShoppingCart list : lists){
            if (cartMap.getProductId() == list.getProductId()){
                 shoppingCart = list;
                 shoppingCart.setProductNum(cartMap.getProductNum());
                 listOperations.leftPushAll(cartMap.getAccount(),lists);
                 return 1;
            }
        }
        /**
         * 在购物车中添加新的物品
         */
        Product product = productMapper.selectByPrimaryKey(cartMap.getProductId());
        if (product != null){
            shoppingCart.setProductImg(product.getProductImageBig());
            shoppingCart.setProductName(product.getProductName());
            shoppingCart.setChecked("1");
            shoppingCart.setLimitNum(100);
            shoppingCart.setSalePrice(product.getSalelPrice());
            shoppingCart.setProductId(cartMap.getProductId());
            shoppingCart.setProductNum(cartMap.getProductNum());
            lists.add(shoppingCart);
            listOperations.leftPushAll(cartMap.getAccount(),lists);
        }
        return 0;
    }
}
