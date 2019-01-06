package com.xinyuan.main.domain;

import java.io.Serializable;

/**
 * @Auther: chenxin
 * @Date: 2019/1/6 21:32
 * @Description:
 */
public class CartMap02 implements Serializable{

    private static final long serialVersionUID = 1L;

    private String account;

    private int productId;

    private int productNum;

    private String checked;

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

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
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
        sb.append(",\"checked\":\"")
                .append(checked).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
