package com.nine.back.entity;

public class adminRole {
    private Integer id;

    private String RoleCode;

    private String RoleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String RoleCode) {
        this.RoleCode = RoleCode;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
}