package com.xinyuan.main.service;

import com.xinyuan.main.domain.PurchaseHistory;
import com.xinyuan.main.domain.vo.OrderVO;
import com.xinyuan.main.domain.vo.PurchaseInfo;
import com.xinyuan.main.domain.vo.ReturnVO;

import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 22:26
 * @Description:
 */
public interface PurchaseHistoryService {

    /**
     *
     * 功能描述: 查询用户的订单(分页)
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:28
     */
    ReturnVO selectAllByUserId(int userId, int size, int page);

    /**
     *
     * 功能描述: 新增订单
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:55
     */
    int insertInfo(PurchaseInfo purchaseInfo);

    /**
     *
     * 功能描述: 放弃订单
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 23:55
     */
    int cancelOrder(int id);

    /**
     *
     * 功能描述: 查询订单详情
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 0:01
     */
    OrderVO read(int id);

    /**
     *
     * 功能描述: 删除订单详情
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 20:29
     */
    int deleteByPrimaryKey(int id);

    /**
     *
     * 功能描述: 更新订单信息
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 22:02
     */
    int updateInfo(PurchaseHistory purchaseHistory);
}
