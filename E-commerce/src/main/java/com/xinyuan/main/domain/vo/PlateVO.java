package com.xinyuan.main.domain.vo;

import com.xinyuan.main.domain.PlateContent;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/4 19:31
 * @Description:
 */
//@Setter
//@Getter
public class PlateVO {

    private Integer id;

    private String name;

    private Integer type;

    private Integer sortOrder;

    private Integer position;

    private Integer limitNum;

    private String remark;

    private Date created;

    private Date updated;

    private Integer status;

    private List<PlateContent> panelContents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PlateContent> getPanelContents() {
        return panelContents;
    }

    public void setPanelContents(List<PlateContent> panelContents) {
        this.panelContents = panelContents;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"type\":")
                .append(type);
        sb.append(",\"sortOrder\":")
                .append(sortOrder);
        sb.append(",\"position\":")
                .append(position);
        sb.append(",\"limitNum\":")
                .append(limitNum);
        sb.append(",\"remark\":\"")
                .append(remark).append('\"');
        sb.append(",\"created\":\"")
                .append(created).append('\"');
        sb.append(",\"updated\":\"")
                .append(updated).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"panelContents\":")
                .append(panelContents);
        sb.append('}');
        return sb.toString();
    }
}
