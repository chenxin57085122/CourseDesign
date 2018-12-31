package com.xinyuan.main.dao;

import com.xinyuan.main.domain.SmallSort;

public interface SmallSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmallSort record);

    int insertSelective(SmallSort record);

    SmallSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallSort record);

    int updateByPrimaryKey(SmallSort record);
}