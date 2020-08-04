package com.pcl.spring.mapper;

import com.pcl.spring.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author pengchenglin
 * @create 2020-07-29 14:14
 */
@Repository
@Mapper
public interface UserMapper {

    int insert(User user);

    User selectByPrimaryKey(Integer id);

    User selectAllUserInfoByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer id);
}
