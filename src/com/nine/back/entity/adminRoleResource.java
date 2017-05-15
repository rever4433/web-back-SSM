package com.nine.back.entity;

public class adminRoleResource {
    private Integer id;

    private String rolecode;

    private Integer resourceid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }
}