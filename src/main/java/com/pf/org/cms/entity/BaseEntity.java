package com.pf.org.cms.entity;

import com.pf.org.cms.annotation.Column;

import java.util.Date;

public class BaseEntity {
    // 创建时间
    private Date createDate;
    // 创建人
    private String createBy;
    // 修改时间
    private Date modifiedDate;
    // 修改人
    private String modifiedBy;
    // 数据状态
    private int state;
    // 排序
    private int sortNo;

    @Column(value = "CREATE_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(value = "CREATE_BY")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Column(value = "MODIFIED_DATE")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(value = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(value = "STATE")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Column(value = "SORTNO")
    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    @Override
    public String toString() {
        return ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", state=" + state +
                ", sortNo=" + sortNo;
    }
}
