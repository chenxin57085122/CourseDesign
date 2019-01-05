package com.xinyuan.main.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 22:03
 * @Description:
 */
public class ShoppingCart implements Serializable{

    private static final long serialVersionUID = 1L;

    private int productId;

    private BigDecimal salePrice;

    private int productNum;

    private int limitNum;

    private String checked;

    private String productName;

    private String productImg;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"productId\":")
                .append(productId);
        sb.append(",\"salePrice\":")
                .append(salePrice);
        sb.append(",\"productNum\":")
                .append(productNum);
        sb.append(",\"limitNum\":")
                .append(limitNum);
        sb.append(",\"checked\":\"")
                .append(checked).append('\"');
        sb.append(",\"productName\":\"")
                .append(productName).append('\"');
        sb.append(",\"productImg\":\"")
                .append(productImg).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
