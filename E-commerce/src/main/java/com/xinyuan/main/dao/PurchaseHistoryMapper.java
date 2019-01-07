package com.xinyuan.main.dao;

import com.xinyuan.main.domain.PurchaseHistory;
import com.xinyuan.main.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PurchaseHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseHistory record);

    int insertSelective(PurchaseHistory record);

    PurchaseHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseHistory record);

    int updateByPrimaryKey(PurchaseHistory record);

    /**
     *
     * 功能描述: 查询用户所有订单
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:09
     */
    List<OrderVO> selectAllByUserId(@Param("userId") int userId,@Param("start") int start,@Param("end") int end);

    /**
     *
     * 功能描述: 查询用户所有订单数量（为了分页）
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:43
     */
    int selectAllByUserIdCount(int userId);

    /**
     *
     * 功能描述: 通过id查询详情
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 0:02
     */
    OrderVO readAll(int id);

    /**
     *
     * 功能描述: 查询所有未支付的订单
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 0:21
     */
    List<PurchaseHistory> selectAll();
}