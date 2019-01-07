package com.xinyuan.main.service;

import com.xinyuan.main.dao.ProductMapper;
import com.xinyuan.main.domain.Product;
import com.xinyuan.main.domain.vo.Product01;
import com.xinyuan.main.domain.vo.ReturnVO;
import com.xinyuan.main.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 11:41
 * @Description:
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper = null;

    /**
     * 功能描述: 新增商品
     *
     * @param product
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:14
     */
    @Override
    public int insertSelective(Product product) {
        product.setProductId(StringUtil.getId());
        String detail = product.getDetail();
        detail = "<img src=\""+detail+"\" style=\"width:1220px;height:3665px;\" alt=\"\" />";
        product.setDetail(detail);
        return productMapper.insertSelective(product);
    }

    /**
     * 功能描述: 更新
     *
     * @param product
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:15
     */
    @Override
    public int updateByPrimaryKeySelective(Product product) {

        return productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * 功能描述: 通过id
     *
     * @param id
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:22
     */
    @Override
    public Product01 selectByPrimaryKey(int id) {
        Product product = productMapper.selectByPrimaryKey(id);

        return ProductToProduct01(product);
    }

    /**
     * 功能描述:
     *
     * @param id
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 11:37
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    /**
     * 功能描述: 查询全部商品（分页、排序、按照价格区间）
     *
     * @param page
     * @param size
     * @param sort
     * @param priceGt
     * @param priceLte
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 15:15
     */
    @Override
    public ReturnVO selectAllByCondition(int page, int size, int sort, String key, int priceGt, int priceLte) {
        int start = (page - 1) * size;
        int end = page * size;
        if (("null").equals(key)){
            key = null;
        }
        if (priceGt == -1 && priceLte == -1){
            priceGt = 0;
            priceLte = Integer.MAX_VALUE;
        }
        ReturnVO productVO = new ReturnVO();
        productVO.setData(productMapper.selectAllByCondition(start, end, sort, key, priceGt, priceLte));
        productVO.setTotal(productMapper.selectAllByConditionCount(key, priceGt, priceLte));
        return productVO;
    }

    /**
     * 功能描述: 模糊查询相似物品
     *
     * @param key
     * @param: 返回商品名称列表
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 16:59
     */
    @Override
    public List<String> selectAllByConditionName(String key) {

        return productMapper.selectAllByConditionName(key);
    }

    /**
     *
     * 功能描述: 将Product 转化为Product01
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 12:38
     */
    private Product01 ProductToProduct01(Product product){

        if (product == null) {
            return new Product01();
        }

        return new Product01.Builder().productId(product.getProductId())
                        .id(product.getId())
                        .productName(product.getProductName())
                        .productImageBig(product.getProductImageBig())
                        .detail(product.getDetail())
                        .salelPrice(product.getSalelPrice())
                        .clickNumber(product.getClickNumber())
                        .ordinaryPrice(product.getOrdinaryPrice())
                        .smallId(product.getSmallId())
                        .seller(product.getSeller())
                        .shelfTime(product.getShelfTime())
                        .subTitle(product.getSubTitle())
                        .productImageSmall(StringUtil.strToList(product.getProductImageSmall()))
                        .clickNumber(product.getClickNumber())
                        .limitNum(product.getLimitNum())
                        .create();
    }


}
