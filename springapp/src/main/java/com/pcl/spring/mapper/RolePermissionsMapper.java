package com.pcl.spring.mapper;

import com.pcl.spring.bean.RolePermissions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author pengchenglin
 * @create 2020-07-29 15:48
 */
@Mapper
@Repository
public interface RolePermissionsMapper {

    int insert(RolePermissions rolePermissions);

    int insertAutoId(RolePermissions rolePermissions);

    int deleteById(Integer id);

    int deleteByRoleID(Integer roleID);

    RolePermissions selectById(Integer id);
}
