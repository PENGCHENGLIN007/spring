package com.pcl.spring.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author pengchenglin
 * @create 2020-07-24 10:03
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private Set<Role> roles;

    public User(){}

    public User(String name, String password ){
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}
