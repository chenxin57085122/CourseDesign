package com.xinyuan.main.domain.vo;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 16:25
 * @Description:
 */
public class ProductVO {
    private Object data;
    private int total;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ProductVO(Object data, int total) {
        this.data = data;
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\":")
                .append(data);
        sb.append(",\"total\":")
                .append(total);
        sb.append('}');
        return sb.toString();
    }

    public ProductVO() {
    }
}
