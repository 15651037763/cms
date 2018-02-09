package com.pf.org.cms.entity;

import com.pf.org.cms.annotation.Column;
import com.pf.org.cms.annotation.Id;
import com.pf.org.cms.annotation.Table;

@Table(value = "CMS_USER_INFO")
public class UserInfo extends BaseEntity {
    // 主键
    private long id;
    // 用户编号
    private String userCode;
    // 用户名称
    private String userName;
    // 用户密码
    private String userPwd;
    // 备注
    private String remark;

    @Id(value = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(value = "USER_CODE")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(value = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(value = "USER_PWD")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Column(value = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", remark='" + remark + '\'' +
                super.toString() +
                '}';
    }
}
