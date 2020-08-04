package com.pcl.spring.service;

import com.pcl.spring.bean.User;

/**
 * @author pengchenglin
 * @create 2020-07-24 10:29
 */
public interface LoginService {

    User getUserByName(String name);
}
