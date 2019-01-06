package com.xinyuan.main;

import com.xinyuan.main.domain.CartMap;
import com.xinyuan.main.domain.User;
import com.xinyuan.main.domain.vo.ShoppingCart;
import com.xinyuan.main.service.RedisService;
import com.xinyuan.main.service.ShoppingCartService;
import com.xinyuan.main.utils.POJOAndJsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 20:44
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class RedisServiceTest {

    @Autowired
    private RedisService redisService = null;

    @Autowired
    private HashOperations hashOperations = null;

    @Autowired
    private ValueOperations valueOperations = null;

    @Autowired
    private ListOperations listOperations = null;

    @Autowired
    private ShoppingCartService shoppingCartService = null;

    /**
     *
     * 功能描述: 测试redisTemplate获取Map<Key,Value></>
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 20:46
     */
    @Test
    public void redisTemplate(){
        valueOperations.set("ab","aaa");
        System.out.println(valueOperations.get("ab"));
    }


    /**
     * 测试存储购物车功能
     */
    @Test
    public void redisObjectTest(){
        User user = new User();
        user.setId(1);
        user.setAccount("chenxin123456");
        user.setEmail("1004498612@qq.com");
        String key = user.getAccount();
        JSONObject  jsonObject = JSONObject.fromObject(user);
        valueOperations.set(key,jsonObject.toString());
        User user1 = new User();
        Object  object = new Object();
        JSONObject json = JSONObject.fromObject(valueOperations.get(key));
        Class clazz = user1.getClass();
        user1 = (User)JSONObject.toBean(json,clazz);
        System.out.println(user1);
    }


    /**
     *
     * 功能描述:测试添加数据
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/5 22:48
     */
    @Test
    public void ShoppingCartTest(){
        List<String> list = new ArrayList<>();
        ShoppingCart shoppingCart1 = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();
        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart1.setProductId(1);
        shoppingCart2.setProductId(2);
        shoppingCart3.setProductId(3);
        BigDecimal salePrice = new BigDecimal(199);
        shoppingCart1.setSalePrice(salePrice);
        shoppingCart1.setProductNum(8);
        shoppingCart1.setLimitNum(100);
        shoppingCart1.setChecked("0");
        shoppingCart1.setProductName("Smartisan 帆布鞋");
        shoppingCart1.setProductImg("https://resource.smartisan.com/resource/2f9a0f5f3dedf0ed813622003f1b287b.jpg");
        salePrice = new BigDecimal(49);
        shoppingCart2.setSalePrice(salePrice);
        shoppingCart2.setProductNum(8);
        shoppingCart2.setLimitNum(100);
        shoppingCart2.setChecked("1");
        shoppingCart2.setProductName("坚果 3 前屏钢化玻璃保护膜");
        shoppingCart2.setProductImg("https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg");
        salePrice = new BigDecimal(49);
        shoppingCart3.setSalePrice(salePrice);
        shoppingCart3.setProductNum(12);
        shoppingCart3.setLimitNum(100);
        shoppingCart3.setChecked("0");
        shoppingCart3.setProductName("坚果 3 TPU 软胶保护套");
        shoppingCart3.setProductImg("https://resource.smartisan.com/resource/b899d9b82c4bc2710492a26af021d484.jpg");
        list.add(POJOAndJsonUtil.POJOToJson(shoppingCart1));
        list.add(POJOAndJsonUtil.POJOToJson(shoppingCart2));
        list.add(POJOAndJsonUtil.POJOToJson(shoppingCart3));
        listOperations.leftPushAll("123456",list);

        System.out.println("添加成功");
    }

    @Test
    public void deleteTest(){
        redisService.deleteKey("123456");
    }

    @Test
    public void addCartProduct(){
        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart3.setProductId(3);
        BigDecimal salePrice = new BigDecimal(49);
        shoppingCart3.setSalePrice(salePrice);
        shoppingCart3.setProductNum(12);
        shoppingCart3.setLimitNum(100);
        shoppingCart3.setChecked("0");
        shoppingCart3.setProductName("坚果 3 TPU 软胶保护套");
        shoppingCart3.setProductImg("https://resource.smartisan.com/resource/b899d9b82c4bc2710492a26af021d484.jpg");
        CartMap cartMap = new CartMap();
        cartMap.setAccount("123456");
        cartMap.setProductId(1);
        cartMap.setProductNum(22);
        shoppingCartService.addProduct(cartMap);
    }


    /**
     *
     * 功能描述: 选中所有的商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:46
     */
    @Test
    public void productAllchecked(){
        Map<String, String> map = new HashMap<>();
        map.put("account","123456");
        map.put("checked","1");
        System.out.println(shoppingCartService.productAllchecked(map));

    }

    /**
     *
     * 功能描述: 测试删除被选中的商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/6 20:46
     */
    @Test
    public void deleteChecked(){
        System.out.println(shoppingCartService.deleteChecked("123456"));
    }
}
