package com.xinyuan.main.service;

import com.xinyuan.main.dao.PurchaseAddressMapper;
import com.xinyuan.main.dao.PurchaseHistoryIndetailMapper;
import com.xinyuan.main.dao.PurchaseHistoryMapper;
import com.xinyuan.main.domain.PurchaseAddress;
import com.xinyuan.main.domain.PurchaseHistory;
import com.xinyuan.main.domain.PurchaseHistoryIndetail;
import com.xinyuan.main.domain.vo.OrderVO;
import com.xinyuan.main.domain.vo.PurchaseInfo;
import com.xinyuan.main.domain.vo.ReturnVO;
import com.xinyuan.main.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 22:29
 * @Description:
 */
@Service("purchaseHistoryService")
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService{

    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper = null;

    @Autowired
    private PurchaseAddressMapper purchaseAddressMapper = null;

    @Autowired
    private PurchaseHistoryIndetailMapper purchaseHistoryIndetailMapper = null;
    /**
     * 功能描述: 查询用户的订单(分页)
     *
     * @param userId
     * @param size
     * @param page
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:28
     */
    @Override
    public ReturnVO selectAllByUserId(int userId, int size, int page) {
        int start = (page - 1) * size;
        int end = page * size;
        return new ReturnVO(purchaseHistoryMapper.selectAllByUserId(userId, start, end),purchaseHistoryMapper.selectAllByUserIdCount(userId));
    }

    /**
     * 功能描述: 新增订单
     *          需要添加三个表的信息 ;purchaseHistoryMapper、purchaseAddressMapper、purchaseHistoryIndetailMapper
     *
     *
     * @param purchaseInfo
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:55
     */
    @Override
    public int insertInfo(PurchaseInfo purchaseInfo) {

        PurchaseHistory purchaseHistory = new PurchaseHistory();
        List<PurchaseHistoryIndetail> purchaseHistoryIndetail = new ArrayList<>();
        PurchaseAddress purchaseAddress = new PurchaseAddress();
        //构建PurchaseHistory
        purchaseHistory.setUserId(purchaseInfo.getUserId());
        purchaseHistory.setOrderTotal(purchaseInfo.getOrderTotal());
        purchaseHistory.setOrderStatus("0");
        purchaseHistory.setCreateDate(new Date());
        purchaseHistory.setCloseDate(DateUtil.addTime());
        purchaseHistoryMapper.insertSelective(purchaseHistory);
        int id = purchaseHistory.getId();
        //构建PurchaseHistoryIndetail 列表
        purchaseHistoryIndetail = purchaseInfo.getGoodsList();
        for (PurchaseHistoryIndetail temp : purchaseHistoryIndetail){
            temp.setPurchaseHistoryId(id);
            purchaseHistoryIndetailMapper.insertSelective(temp);
        }
        //构建PurchaseAddress
        purchaseAddress.setPurchaseHistoryId(id);
        purchaseAddress.setArea(purchaseInfo.getArea());
        purchaseAddress.setProvince(purchaseInfo.getProvince());
        purchaseAddress.setCity(purchaseInfo.getCity());
        purchaseAddress.setStreetName(purchaseInfo.getAddressDetail());
        purchaseAddress.setTel(purchaseInfo.getPhone());
        purchaseAddress.setIsDefault("1");
        purchaseAddress.setUserName(purchaseInfo.getShippingPeople());
        String s = purchaseInfo.getUserId() + "";
        purchaseAddress.setUserId(s);
        purchaseAddressMapper.insertSelective(purchaseAddress);
        return id;
    }

    /**
     * 功能描述: 放弃订单
     *
     * @param id
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 23:55
     */
    @Override
    public int cancelOrder(int id) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setId(id);
        purchaseHistory.setOrderStatus("5");
        return purchaseHistoryMapper.updateByPrimaryKeySelective(purchaseHistory);
    }

    /**
     * 功能描述: 查询订单详情
     *
     * @param id
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 0:01
     */
    @Override
    public OrderVO read(int id) {
        return purchaseHistoryMapper.readAll(id);
    }

    /**
     * 功能描述: 删除订单详情
     *
     * @param id
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 20:29
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return purchaseHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 功能描述: 更新订单信息
     *
     * @param purchaseHistory
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 22:02
     */
    @Override
    public int updateInfo(PurchaseHistory purchaseHistory) {

        return purchaseHistoryMapper.updateByPrimaryKeySelective(purchaseHistory);
    }


}
