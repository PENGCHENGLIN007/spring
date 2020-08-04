package com.pcl.spring.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * @author pengchenglin
 * @create 2020-07-23 17:32
 */
@Slf4j
public class MySessionListener extends SessionListenerAdapter {

    @Override
    public void onStart(Session session) {
        log.info("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        log.info("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        log.info("会话过期：" + session.getId());
    }

}
