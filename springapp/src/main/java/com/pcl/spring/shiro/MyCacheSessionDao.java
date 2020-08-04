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
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.*;

/**
 * @author pengchenglin
 * @create 2020-07-22 10:38
 */
@Slf4j
public class MyCacheSessionDao extends EnterpriseCacheSessionDAO {



    @Autowired
    private SessionMapper sessionMapper;

    private final String cacheName = "USERSESSIONS";
    private Cache<String, Session> cache = new MapCache<>(cacheName,new HashMap<>());

    @SneakyThrows
    @Override
    protected Serializable doCreate(Session session) {

        log.info("create seesion:{}",session.getId());
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        log.info("write to cache:{}",sessionId.toString());
        cache.put(sessionId.toString(),session);
        log.info("write to db:{}",sessionId.toString());
        sessionMapper.create(sessionId.toString(), SerializeUtils.serialize(session));
        return sessionId;
    }

    @SneakyThrows
    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.info("read seesion:{}",sessionId.toString());
        Session cacheSession = cache.get(sessionId.toString());
        if(cacheSession!=null){
            log.info("read from cache:{}",sessionId.toString());
            return cacheSession;
        }

        log.info("read from db:{}",sessionId.toString());
        String sessionStr = sessionMapper.get(sessionId.toString());
        if(StringUtils.isBlank(sessionStr)){
            return null;
        }
        Session session = SerializeUtils.deserialize(sessionStr);
        log.info("write to cache:{}",sessionId.toString());
        cache.put(sessionId.toString(),session);
        return session;
    }

    @SneakyThrows
    @Override
    public void update(Session session) throws UnknownSessionException {
        log.info("update seesion:{}",session.getId());

        log.info("update cache:{}",session.getId());
        cache.put(session.getId().toString(),session);
        log.info("update db:{}",session.getId());
        sessionMapper.set(session.getId().toString(), SerializeUtils.serialize(session));


    }

    @Override
    public void delete(Session session) {
        log.info("delete seesion:"+session.getId());

        if (session == null || session.getId() == null) {
            return;
        }
        log.info("delete from cache:{}",session.getId());
        cache.remove(session.getId().toString());
        log.info("delete from db:{}",session.getId());
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
