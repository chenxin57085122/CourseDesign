package com.xinyuan.main.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private String productId;

    private String productName;

    private Integer smallId;

    private String subTitle;

    private Integer limitNum;

    private BigDecimal ordinaryPrice;

    private BigDecimal salelPrice;

    private String productImageBig;

    private String detail;

    private String productImageSmall;

    private Date shelfTime;

    private Integer clickNumber;

    private Integer weight;

    private Integer seller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public BigDecimal getOrdinaryPrice() {
        return ordinaryPrice;
    }

    public void setOrdinaryPrice(BigDecimal ordinaryPrice) {
        this.ordinaryPrice = ordinaryPrice;
    }

    public BigDecimal getSalelPrice() {
        return salelPrice;
    }

    public void setSalelPrice(BigDecimal salelPrice) {
        this.salelPrice = salelPrice;
    }

    public String getProductImageBig() {
        return productImageBig;
    }

    public void setProductImageBig(String productImageBig) {
        this.productImageBig = productImageBig == null ? null : productImageBig.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getProductImageSmall() {
        return productImageSmall;
    }

    public void setProductImageSmall(String productImageSmall) {
        this.productImageSmall = productImageSmall == null ? null : productImageSmall.trim();
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Integer getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(Integer clickNumber) {
        this.clickNumber = clickNumber;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }
}