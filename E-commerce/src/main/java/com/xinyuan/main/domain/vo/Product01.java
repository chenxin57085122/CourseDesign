package com.xinyuan.main.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 11:59
 * @Description: 用于返回produc信息给前端（String productImageSmall ---> List<String> productImageSmall）
 */
public class Product01 {

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

    private List<String> productImageSmall;

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
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        this.subTitle = subTitle;
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
        this.productImageBig = productImageBig;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<String> getProductImageSmall() {
        return productImageSmall;
    }

    public void setProductImageSmall(List<String> productImageSmall) {
        this.productImageSmall = productImageSmall;
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
        sb.append(",\"productImageSmall\":")
                .append(productImageSmall);
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

    public static class Builder{
        private Product01 product01 = new Product01();

        public Builder id(int id){
            product01.id = id;
            return this;
        }

        public Builder productId(String productId){
            product01.productId = productId;
            return this;
        }

        public Builder productName(String productName){
            product01.productName = productName;
            return this;
        }

        public Builder smallId(int smallId){
            product01.smallId = smallId;
            return this;
        }

        public Builder subTitle(String subTitle){
            product01.subTitle = subTitle;
            return this;
        }

        public Builder limitNum(int limitNum){
            product01.limitNum = limitNum;
            return this;
        }

        public Builder salelPrice(BigDecimal salelPrice){
            product01.salelPrice = salelPrice;
            return this;
        }

        public Builder ordinaryPrice(BigDecimal ordinaryPrice){
            product01.ordinaryPrice = ordinaryPrice;
            return this;
        }

        public Builder productImageBig(String productImageBig){
            product01.productImageBig = productImageBig;
            return this;
        }

        public Builder detail(String detail){
            product01.detail = detail;
            return this;
        }

        public Builder productImageSmall(List<String> productImageSmall){
            product01.productImageSmall = productImageSmall;
            return this;
        }

        public Builder shelfTime(Date shelfTime){
            product01.shelfTime = shelfTime;
            return this;
        }

        public Builder clickNumber(int clickNumber){
            product01.clickNumber = clickNumber;
            return this;
        }

        public Builder weight(int weight){
            product01.weight = weight;
            return this;
        }

        public Builder seller(int seller){
            product01.seller = seller;
            return this;
        }

        public Product01 create(){
            return product01;
        }
    }
}
