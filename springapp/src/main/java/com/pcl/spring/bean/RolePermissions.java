package com.pcl.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengchenglin
 * @create 2020-07-29 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissions {

    private Integer id;
    private Integer roleId;
    private Integer permissionsId;


}
