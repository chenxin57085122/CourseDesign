package com.xinyuan.main.dao;

import com.xinyuan.main.domain.MiddleSort;
import org.springframework.stereotype.Component;

@Component
public interface MiddleSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MiddleSort record);

    MiddleSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MiddleSort record);
}