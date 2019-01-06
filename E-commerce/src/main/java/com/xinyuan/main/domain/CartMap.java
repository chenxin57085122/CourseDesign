package com.xinyuan.main.domain;

import java.io.Serializable;

/**
 * @Auther: chenxin
 * @Date: 2019/1/6 00:06
 * @Description: 用于接收前端传来的添加购物车商品的信息
 */
public class CartMap implements Serializable{

    private static final long serialVersionUID = 1L;

    private String account;

    private int productId;

    private int productNum;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"account\":\"")
                .append(account).append('\"');
        sb.append(",\"productId\":")
                .append(productId);
        sb.append(",\"productNum\":")
                .append(productNum);
        sb.append('}');
        return sb.toString();
    }
}
