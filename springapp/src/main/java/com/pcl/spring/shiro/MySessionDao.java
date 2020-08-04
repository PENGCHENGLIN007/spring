package com.pcl.spring.shiro;

import com.pcl.spring.mapper.SessionMapper;
import com.pcl.spring.tool.SerializeUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pengchenglin
 * @create 2020-07-22 10:38
 */
@Slf4j
public class MySessionDao extends AbstractSessionDAO {



    @Autowired
    private SessionMapper sessionMapper;



    @SneakyThrows
    @Override
    protected Serializable doCreate(Session session) {

        log.info("create seesion:"+session.getId());
        Serializable sessionId = generateSessionId(session);
        this.assignSessionId(session, sessionId);
            sessionMapper.create(sessionId.toString(), SerializeUtils.serialize(session));
        return sessionId;
    }

    @lombok.SneakyThrows
    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.info("read seesion:"+sessionId);

        String sessionStr = sessionMapper.get(sessionId.toString());
        if(StringUtils.isBlank(sessionStr)){
            return null;
        }
        Session session = SerializeUtils.deserialize(sessionStr);
        return session;
    }

    @SneakyThrows
    @Override
    public void update(Session session) throws UnknownSessionException {
        log.info("update seesion:"+session.getId());


        sessionMapper.set(session.getId().toString(), SerializeUtils.serialize(session));


    }

    @Override
    public void delete(Session session) {
        log.info("delete seesion:"+session.getId());

        if (session == null || session.getId() == null) {
            return;
        }
        sessionMapper.delete(session.getId().toString());

    }

    @SneakyThrows
    @Override
    public Collection<Session> getActiveSessions() {
        log.debug("get active sessions");

        Set<Session> sessions = new HashSet<>();
        List<com.pcl.spring.bean.Session> userSessions = sessionMapper.selectAll();
        for (com.pcl.spring.bean.Session userSession : userSessions) {

            String sessionStr = userSession.getSession();
            if(StringUtils.isBlank(sessionStr)){
                return null;
            }
            Session session =SerializeUtils.deserialize(sessionStr);
            sessions.add(session);
        }
        return sessions;

    }
}
