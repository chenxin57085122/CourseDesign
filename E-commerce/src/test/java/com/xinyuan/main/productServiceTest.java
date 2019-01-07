package com.xinyuan.main;

import com.xinyuan.main.domain.Product;
import com.xinyuan.main.domain.vo.ReturnVO;
import com.xinyuan.main.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 12:54
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class productServiceTest {

    @Autowired
    private ProductService productService = null;


    @Test
    public void productAdd(){
        Product product = new Product();
        product.setProductName("sdfadfsa");
        product.setWeight(100);
        product.setClickNumber(100);
        product.setDetail("http://adsf.adf.com");
        BigDecimal bigDecimal = new BigDecimal(100);
        product.setOrdinaryPrice(bigDecimal);
        product.setLimitNum(100);
        product.setSeller(333);
        product.setProductImageBig("http://123.123com");
        product.setSubTitle("差DHL反抗撒旦九零");
        product.setShelfTime(new Date());
        String s = "http://lll.as.com,http://dasf.dfsa.com";
        product.setProductImageSmall(s);
        product.setSalelPrice(bigDecimal);
        product.setSmallId(1);
        System.out.println(productService.insertSelective(product));
    }
    @Test
    public void selectById(){
        System.out.println(productService.selectByPrimaryKey(3));
    }
    @Test
    public void update(){
        Product product = new Product();
        product.setId(2);
        product.setProductName("啊大噶似的");
        product.setWeight(100);
        product.setClickNumber(100);
        product.setDetail("http://adsf.adf.com");
        BigDecimal bigDecimal = new BigDecimal(100);
        product.setOrdinaryPrice(bigDecimal);
        product.setLimitNum(100);
        product.setSeller(123);
        product.setProductImageBig("http://123.123com");
        product.setSubTitle("差jsadfkas;ldsf");
        product.setShelfTime(new Date());
        String s = "http://lll.as.com,http://dasf.dfsa.com";
        product.setProductImageSmall(s);
        product.setSalelPrice(bigDecimal);
        product.setSmallId(1);
        System.out.println(productService.updateByPrimaryKeySelective(product));
    }

    @Test
    public void deleteById(){
        System.out.println(productService.deleteByPrimaryKey(2));
    }

    @Test
    public void selectAllByCondition(){
        ReturnVO productVO = productService.selectAllByCondition(1,10,1,"撒旦",0,100);
        List<Product> products = (List<Product>) productVO.getData();
        for (Product product : products){
            System.out.println(product);
        }
        System.out.println("cccc" + productVO.getTotal());
    }

    @Test
    public void selectAllByConditionName(){
        for (String s : productService.selectAllByConditionName("撒旦")){
            System.out.println(s);
        }
    }
}
