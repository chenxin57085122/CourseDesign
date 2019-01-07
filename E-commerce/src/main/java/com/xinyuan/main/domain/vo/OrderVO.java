package com.xinyuan.main.domain.vo;

import com.xinyuan.main.domain.PurchaseAddress;
import com.xinyuan.main.domain.PurchaseHistoryIndetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 21:42
 * @Description: 用于返回分页数据
 */
public class OrderVO {

    private Integer id;

    private Integer userId;

    private BigDecimal orderTotal;

    private Date purchaseTime;

    private String orderStatus;

    private Date createDate;

    private Date closeDate;

    private Date payDate;

    private Date finishDate;

    private PurchaseAddress purchaseAddress;

    List<PurchaseHistoryIndetail> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public PurchaseAddress getPurchaseAddress() {
        return purchaseAddress;
    }

    public void setPurchaseAddress(PurchaseAddress purchaseAddress) {
        this.purchaseAddress = purchaseAddress;
    }

    public List<PurchaseHistoryIndetail> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<PurchaseHistoryIndetail> goodsList) {
        this.goodsList = goodsList;
    }
}
