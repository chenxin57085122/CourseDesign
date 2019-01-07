package com.xinyuan.main.dao;

import com.xinyuan.main.domain.PurchaseHistoryIndetail;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PurchaseHistoryIndetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseHistoryIndetail record);

    int insertSelective(PurchaseHistoryIndetail record);

    PurchaseHistoryIndetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseHistoryIndetail record);

    int updateByPrimaryKey(PurchaseHistoryIndetail record);

    List<PurchaseHistoryIndetail> selectByPurchaseHistoryId(int purchaseHistoryId);
}