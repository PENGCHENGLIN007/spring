package com.pcl.spring.mapper;

import com.pcl.spring.bean.Session;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pengchenglin
 * @create 2020-07-22 10:42
 */
@Repository
@Mapper
public interface SessionMapper {

    int create(String sessionid,String session);

    int set(String sessionid,String session);

    int delete(String sessionid);

    String get(String sessionid);

    List<Session> selectAll();

}
