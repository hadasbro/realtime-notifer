package org.bitbucket.slawekhaa.realtimenotifer.model;

import org.bitbucket.slawekhaa.realtimenotifer.domain.UserSession;
import org.bitbucket.slawekhaa.realtimenotifer.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class UserSessionService {

    @Autowired
    UserSessionRepository usessRepository;

    public List<UserSession> getAllUsess() {

        return new ArrayList<>(usessRepository.getAllUsersSessions());
    }

    public UserSession getUserSession(Integer id) {
        return usessRepository.getUserSessionById(id);
    }
}
