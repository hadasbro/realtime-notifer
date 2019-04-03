package org.bitbucket.slawekhaa.realtimenotifer.service;

import org.bitbucket.slawekhaa.realtimenotifer.db.RethinkConnector;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Cursor;
import org.bitbucket.slawekhaa.realtimenotifer.domain.SingleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class RethinkListener {

    protected final Logger log = LoggerFactory.getLogger(RethinkListener.class);

    private static final RethinkDB r = RethinkDB.r;

    @Autowired
    private RethinkConnector connectionFactory;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Async
    public void pushChangesToWebSocket() {

        Cursor<SingleMessage> cursor = r.db("controller").table("messages")
                .changes()
                .getField("new_val")
                .run(connectionFactory.createConnection(), SingleMessage.class);

        while (cursor.hasNext()) {
            SingleMessage notifMessage = cursor.next();
            webSocket.convertAndSend("/channel/"
                    +notifMessage.getToUserId()+"/"
                    +notifMessage.getToUsessToken()+"/messages", notifMessage);
        }
    }

}
