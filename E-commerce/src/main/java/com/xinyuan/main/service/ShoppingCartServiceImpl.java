package com.xinyuan.main.service;

import com.xinyuan.main.dao.ProductMapper;
import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.Product;
import com.xinyuan.main.domain.vo.ShoppingCart;
import com.xinyuan.main.utils.POJOAndJsonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:15
 * @Description:
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private RedisTemplate redisTemplate = null;

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
        redisTemplate.delete(cartMap.getAccount());
        List<String> temp = new ArrayList<>();
        boolean flag = false;
        //不为空
        if (lists != null && lists.size() != 0){
            //循环查找被修改的商品
            for (int i = lists.size() - 1; i > -1; i--){
                //修改数量
                if (cartMap.getProductId() == lists.get(i).getProductId()){

                    lists.get(i).setProductNum(cartMap.getProductNum());
                    flag = true;
                }
                temp.add(POJOAndJsonUtil.POJOToJson(lists.get(i)));
            }

        }
        if (flag){
            listOperations.leftPushAll(cartMap.getAccount(),temp);
            return 1;
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
//            lists.add(shoppingCart);
            temp.add(POJOAndJsonUtil.POJOToJson(shoppingCart));
            listOperations.leftPushAll(cartMap.getAccount(),temp);
        }
        return 0;
    }

    /**
     * 功能描述:删除单条商品,
     *          查询出该用户中购物车中的商品
     *          清除缓存
     *          删除商品
     * @param cartMap
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 19:42
     */
    @Override
    public int deleteProduct(CartMap cartMap) {
        List<ShoppingCart> lists = selectShoppingCartByUserId(cartMap.getAccount());
        redisTemplate.delete(cartMap.getAccount());
        List<String> temp = new ArrayList<>();
        if (lists != null && lists.size() != 0) {
            for (int i = lists.size() - 1; i > -1; i--) {
                if (lists.get(i).getProductId() != cartMap.getProductId()) {
                    temp.add(POJOAndJsonUtil.POJOToJson(lists.get(i)));
                }
            }
            if (temp.size() != 0)
                listOperations.leftPushAll(cartMap.getAccount(),temp);

            return 1;
        }

        return 0;
    }

    /**
     * 功能描述: 删除选中的商品
     *          查询用户购物车商品
     *          清除缓存
     *          处理被选中的商品
     * @param account
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:15
     */
    @Override
    public int deleteChecked(String account) {
        /*查询购物车商品*/
        List<ShoppingCart> lists = selectShoppingCartByUserId(account);
        //清空缓存
        redisTemplate.delete(account);
        List<String> temp = new ArrayList<>();
        if (lists != null && lists.size() != 0){
            for (int i = lists.size() - 1; i > -1; i --){
                //只保留未选中的商品数据
                if (lists.get(i).getChecked() == "0"){
                    temp.add(POJOAndJsonUtil.POJOToJson(lists.get(i)));
                }
            }
            //若temp中没有商品数据
            if (temp.size() != 0)
                listOperations.leftPushAll(account,temp);

            return 1;
        }
        return 0;
    }

    /**
     * 功能描述: 全选商品、取消全部商品选定
     *
     * @param: map [ "account" : value, "checked" : value]
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:32
     */
    @Override
    public int productAllchecked(Map<String, String> map) {
        List<ShoppingCart> lists = selectShoppingCartByUserId(map.get("account"));
        redisTemplate.delete(map.get("account"));
        String checked = map.get("checked");
        List<String> temp = new ArrayList<>();
        if (lists != null && lists.size() != 0){
            for (int i = lists.size() - 1; i > -1; i --){
                lists.get(i).setChecked(checked);
                temp.add(POJOAndJsonUtil.POJOToJson(lists.get(i)));
            }
            listOperations.leftPushAll(map.get("account"), temp);
            return 1;
        }
        return 0;
    }
}
