package com.xinyuan.main.dao;

import com.xinyuan.main.domain.Bill;
import org.springframework.stereotype.Component;

@Component
public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}