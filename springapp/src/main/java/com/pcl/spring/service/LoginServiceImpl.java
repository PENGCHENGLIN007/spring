package com.pcl.spring.service;

import com.pcl.spring.bean.User;
import com.pcl.spring.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author pengchenglin
 * @create 2020-07-24 10:29
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByName(String name) {
        return userMapper.selectAllUserInfoByName(name);
    }

}
