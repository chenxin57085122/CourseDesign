package com.xinyuan.main.domain.vo;

import com.xinyuan.main.domain.PurchaseHistoryIndetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 22:52
 * @Description: 用于接收添加订单时前端传递的数据
 */
public class PurchaseInfo {

    private int userId;
    private String phone;
    private String shippingPeople;
    private String addressDetail;
    private List<PurchaseHistoryIndetail> goodsList;
    private String area;
    private String city;
    private String province;
    private BigDecimal orderTotal;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShippingPeople() {
        return shippingPeople;
    }

    public void setShippingPeople(String shippingPeople) {
        this.shippingPeople = shippingPeople;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public List<PurchaseHistoryIndetail> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<PurchaseHistoryIndetail> goodsList) {
        this.goodsList = goodsList;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }
}
