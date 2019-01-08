package com.xinyuan.main.dao;

import com.xinyuan.main.domain.PurchaseAddress;
import org.springframework.stereotype.Component;

@Component
public interface PurchaseAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseAddress record);

    int insertSelective(PurchaseAddress record);

    PurchaseAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseAddress record);

    int updateByPrimaryKey(PurchaseAddress record);

    PurchaseAddress selectByPurchaseHistoryId(int id);
}