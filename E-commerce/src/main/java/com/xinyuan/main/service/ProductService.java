package com.xinyuan.main.service;

import com.xinyuan.main.domain.Product;
import com.xinyuan.main.domain.vo.Product01;
import com.xinyuan.main.domain.vo.ReturnVO;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 11:13
 * @Description:
 */
public interface ProductService {

    /**
     *
     * 功能描述: 新增商品
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:14
     */
    int insertSelective(Product product);

    /**
     *
     * 功能描述: 更新
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:15
     */
    int updateByPrimaryKeySelective(Product product);

    /**
     *
     * 功能描述: 通过id
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:22
     */
    Product01 selectByPrimaryKey(int id);

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:37
     */
    int deleteByPrimaryKey(int id);

    /**
     *
     * 功能描述: 查询全部商品（分页、排序、按照价格区间）
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 15:15
     */
    ReturnVO selectAllByCondition(int page, int size, int sort, String key, int priceGt, int priceLte);

    /**
     *
     * 功能描述: 模糊查询相似物品
     *
     * @param: 返回商品名称列表
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 16:59
     */
    List<String> selectAllByConditionName(String key);
}
