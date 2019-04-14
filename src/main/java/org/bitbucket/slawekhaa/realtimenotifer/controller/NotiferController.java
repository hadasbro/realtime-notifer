package org.bitbucket.slawekhaa.realtimenotifer.controller;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Cursor;
import org.bitbucket.slawekhaa.realtimenotifer.db.RethinkConnector;
import org.bitbucket.slawekhaa.realtimenotifer.domain.SingleMessage;
import org.bitbucket.slawekhaa.realtimenotifer.domain.UserSession;
import org.bitbucket.slawekhaa.realtimenotifer.repository.UserSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/notifer")
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class NotiferController {

    @Autowired
    UserSessionRepository userSessionRepository;

    protected final Logger log = LoggerFactory.getLogger(NotiferController.class);
    private static final RethinkDB r = RethinkDB.r;

    @Autowired
    private RethinkConnector connectionFactory;

    @RequestMapping(method = RequestMethod.POST)
    public SingleMessage postMessage(@RequestBody SingleMessage singleMessage) {

        singleMessage.setTime(OffsetDateTime.now());

        HashMap run = r
                .db("controller")
                .table("messages")
                .insert(singleMessage)
                .run(connectionFactory.createConnection());

        return singleMessage;
    }

    /**
     * getMessages
     *
     * get msg for user/sess
     *
     * @param usessId -
     * @return List<SingleMessage>
     */
    @RequestMapping(value="/get-messages", method = RequestMethod.GET)
    public List getMessages(@RequestParam(value = "usessId") Integer usessId) {

        UserSession usess = userSessionRepository.getUserSessionById(usessId);

        Cursor cursor =
                r.db("controller").table("messages")
                .orderBy("time")
                .optArg("index", r.desc("time"))
                .filter(

                        row -> row
                                .g("toUserId")
                                .eq(usess.getUser_id())
                                .and(row.g("toUsessToken")
                                .eq(usess.getSession_token()))
                )
                .limit(500)
                .run(connectionFactory.createConnection(), SingleMessage.class);

        System.out.println("cursorcursorcursor");
        System.out.println(cursor);
        return cursor.toList();
    }

    /**
     * getMessagesAll tst
     *
     * test method
     *
     * get msgs sent to all (sender website)
     *
     * @return List<SingleMessage>
     */
    @RequestMapping(value="/get-messages-all", method = RequestMethod.GET)
    public List<SingleMessage> getMessagesAll() {

        return r.db("controller")
                .table("messages")
                .orderBy()
                .optArg("index", r.desc("time"))
                .limit(500)
                .orderBy("time")
                .run(connectionFactory.createConnection(), SingleMessage.class);
    }
}
