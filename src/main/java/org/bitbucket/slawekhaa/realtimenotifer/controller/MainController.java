package org.bitbucket.slawekhaa.realtimenotifer.controller;

import org.bitbucket.slawekhaa.realtimenotifer.domain.UserSession;
import org.bitbucket.slawekhaa.realtimenotifer.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class MainController {

    @Autowired
    UserSessionRepository userSessionRepository;

    @RequestMapping("/")
    public String index() {
        return "redirect:client";
    }

    @RequestMapping("/client")
    public String index(Model model, @RequestParam(value = "usersess", required = false) Integer uSessId) {

        Collection<UserSession> allSess = userSessionRepository.getAllUsersSessions();


        model.addAttribute("allSess", allSess);

        if(uSessId != null){

            UserSession usess = userSessionRepository.getUserSessionById(uSessId);

            model.addAttribute("user_id_subscribe_show", usess.getId());
            model.addAttribute("user_id_subscribe", usess.getUser_id());
            model.addAttribute("user_session_subscribe", usess.getSession_token());
        }



        return "client";
    }

    @RequestMapping("/sender")
    public String sendTo(Model model) {

        Collection<UserSession> allSess = userSessionRepository.getAllUsersSessions();

        model.addAttribute("allSess", allSess);

        return "sendto";
    }
}
