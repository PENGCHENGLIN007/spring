package com.pcl.spring.bean;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {

    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(Integer id, String name, Set<Permissions> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    private Integer id;

    private String name;

    private Set<Permissions> permissions;

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
        this.name = name == null ? null : name.trim();
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}