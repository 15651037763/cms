package com.pf.org.cms.entity;

import java.io.Serializable;

public class UserRoleInfo extends BaseEntity implements Serializable {
    // 主键
    private long id;
    // 用户编号
    private String userCode;
    // 角色编号
    private String roleCode;
    // 角色名称
    private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRoleInfo{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                super.toString() +
                '}';
    }
}
