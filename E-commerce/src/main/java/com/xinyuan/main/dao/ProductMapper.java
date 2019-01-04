package com.xinyuan.main.dao;

import com.xinyuan.main.domain.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

}