package org.bitbucket.slawekhaa.realtimenotifer.repository;

import org.bitbucket.slawekhaa.realtimenotifer.domain.UserSession;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class DBRepository implements UserSessionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<UserSession> getAllUsersSessions() {

        return  em.createQuery("from UserSession", UserSession.class).getResultList();
    }

    @Override
    public UserSession getUserSessionById(Integer id) {
        return em.find(UserSession.class, id);
    }


}
