package com.xinyuan.main.controller;

import com.xinyuan.main.domain.Product;
import com.xinyuan.main.service.ProductService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Auther: chenxin
 * @Date: 2019/1/7 13:29
 * @Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService = null;

    @GetMapping("/select/{id}")
    public ServiceVO selectByPrimaryKey(@PathVariable("id") int id){
        return new ServiceVO(productService.selectByPrimaryKey(id));
    }

    @PostMapping("/insert")
    public ServiceVO insertSelective(@RequestBody Product product){
        return new  ServiceVO.ServiceVOBuilder().code(productService.insertSelective(product)).builder();
    }

    @PostMapping("/update")
    public ServiceVO updateByPrimaryKeySelective(@RequestBody Product product){
        return new ServiceVO.ServiceVOBuilder().code(productService.updateByPrimaryKeySelective(product)).builder();
    }

    @DeleteMapping("/delete/{id}")
    public ServiceVO deleteByPrimaryKey(@PathVariable("id") int id){
        return new ServiceVO.ServiceVOBuilder().code(productService.deleteByPrimaryKey(id)).builder();
    }

    /**
     *
     * 功能描述: 分页、排序、价格区间、模糊
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 15:42
     */
    @GetMapping("/selectByCondition/{page}/{size}/{sort}/{priceGt}/{priceLte}")
    public ServiceVO selectByCondition(@PathVariable("page") int page, @PathVariable("size") int size,
                                       @PathVariable("sort") int sort, @PathVariable("key") String key,
                                       @PathVariable("priceGt") int priceGt, @PathVariable("priceLte") int priceLte){
        return new ServiceVO(productService.selectAllByCondition(page, size, sort, key, priceGt, priceLte));
    }

    /**
     *
     * 功能描述: 模糊查询相似物品
     *
     * @param: 名称
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 17:00
     */
    @GetMapping("/selectName/{key}")
    public ServiceVO selectAllByConditionName(@PathVariable("key") String key){
        return new ServiceVO(productService.selectAllByConditionName(key));
    }
}
