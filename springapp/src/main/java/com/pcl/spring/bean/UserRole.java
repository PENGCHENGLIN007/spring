package com.pcl.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer userId;



}