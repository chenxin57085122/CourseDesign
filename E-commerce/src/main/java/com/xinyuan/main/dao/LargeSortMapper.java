package com.xinyuan.main.dao;

import com.xinyuan.main.domain.LargeSort;
import org.springframework.stereotype.Component;

@Component
public interface LargeSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LargeSort record);

    int insertSelective(LargeSort record);

    LargeSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LargeSort record);

    int updateByPrimaryKey(LargeSort record);
}