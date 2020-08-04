package com.pcl.spring.mapper;

import com.pcl.spring.bean.UserSession;

/**
 * @author pengchenglin
 * @create 2020-07-30 9:48
 */
public interface UserSessionMapper {

    int insert(UserSession userSession);

    int deleteById(Integer id);

    int deleteByUserId(Integer userId);

    int deleteBySessionId(Integer sessionId);

    int updateByUserId(Integer userId,Integer sessionId);

    int selectAll();

    int selectById(Integer id);

    int selectByUserId(Integer userId);

    int selectBySessionId(Integer sessionId);



}
