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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"productId\":\"")
                .append(productId).append('\"');
        sb.append(",\"productName\":\"")
                .append(productName).append('\"');
        sb.append(",\"smallId\":")
                .append(smallId);
        sb.append(",\"subTitle\":\"")
                .append(subTitle).append('\"');
        sb.append(",\"limitNum\":")
                .append(limitNum);
        sb.append(",\"ordinaryPrice\":")
                .append(ordinaryPrice);
        sb.append(",\"salelPrice\":")
                .append(salelPrice);
        sb.append(",\"productImageBig\":\"")
                .append(productImageBig).append('\"');
        sb.append(",\"detail\":\"")
                .append(detail).append('\"');
        sb.append(",\"productImageSmall\":\"")
                .append(productImageSmall).append('\"');
        sb.append(",\"shelfTime\":\"")
                .append(shelfTime).append('\"');
        sb.append(",\"clickNumber\":")
                .append(clickNumber);
        sb.append(",\"weight\":")
                .append(weight);
        sb.append(",\"seller\":")
                .append(seller);
        sb.append('}');
        return sb.toString();
    }
}