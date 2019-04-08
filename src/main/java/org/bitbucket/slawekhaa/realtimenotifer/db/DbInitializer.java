package org.bitbucket.slawekhaa.realtimenotifer.db;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.bitbucket.slawekhaa.realtimenotifer.service.RethinkListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class DbInitializer implements InitializingBean {
    @Autowired
    private RethinkConnector connectionFactory;

    @Autowired
    private RethinkListener rethinkListener;

    private static final RethinkDB r = RethinkDB.r;

    @Override
    public void afterPropertiesSet() {
//        createDb();
//        rethinkListener.pushChangesToWebSocket();
    }

    private void createDb() {
//        Connection connection = connectionFactory.createConnection();
//        List<String> dbList = r.dbList().run(connection);
//        if (!dbList.contains("controller")) {
//            r.dbCreate("controller").run(connection);
//        }
//        List<String> tables = r.db("controller").tableList().run(connection);
//        if (!tables.contains("messages")) {
//            r.db("controller").tableCreate("messages").run(connection);
//            r.db("controller").table("messages").indexCreate("time").run(connection);
//        }
    }
}
