package com.xinyuan.main.dao;

import com.xinyuan.main.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    /**
     *
     * 功能描述: 按条件查询（分页，排序、价格区间）
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 15:09
     */
    List<Product> selectAllByCondition(@Param("start") int start,@Param("end") int end,@Param("sort") int sort,@Param("key") String key,@Param("priceGt") int priceGt,@Param("priceLte") int priceLte);

    /**
     *
     * 功能描述: 按条件查询其数量
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 16:44
     */
    int selectAllByConditionCount(@Param("key") String key,@Param("priceGt") int priceGt,@Param("priceLte") int priceLte);

    /**
     *
     * 功能描述: 模糊查询相似物品
     *
     * @param: 名称
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 17:00
     */
    List<String> selectAllByConditionName(String key);
}