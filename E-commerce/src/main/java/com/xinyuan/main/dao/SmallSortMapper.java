package com.xinyuan.main.dao;

import com.xinyuan.main.domain.SmallSort;
import org.springframework.stereotype.Component;

@Component
public interface SmallSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SmallSort record);

    SmallSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallSort record);
}