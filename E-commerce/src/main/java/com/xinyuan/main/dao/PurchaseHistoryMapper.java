package com.xinyuan.main.dao;

import com.xinyuan.main.domain.PurchaseHistory;
import org.springframework.stereotype.Component;

@Component
public interface PurchaseHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseHistory record);

    int insertSelective(PurchaseHistory record);

    PurchaseHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseHistory record);

    int updateByPrimaryKey(PurchaseHistory record);
}