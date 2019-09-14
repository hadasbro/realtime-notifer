package org.bitbucket.slawekhaa.realtimenotifer.repository;

import org.bitbucket.slawekhaa.realtimenotifer.domain.UserSession;

import java.util.Collection;

@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public interface UserSessionRepository {

    Collection<UserSession> getAllUsersSessions();

    UserSession getUserSessionById(Integer id);

    default void updateUserSession(int id, UserSession usess) {
    }
}
