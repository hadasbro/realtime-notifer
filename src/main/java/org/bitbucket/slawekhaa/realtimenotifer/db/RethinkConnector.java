package org.bitbucket.slawekhaa.realtimenotifer.db;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import java.util.concurrent.TimeoutException;

@SuppressWarnings({"unused","WeakerAccess","WeakAccess","FieldCanBeLocal"})
public class RethinkConnector {
    private String host;
    private Integer port;

    public RethinkConnector(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Connection createConnection() {
        try {
            return RethinkDB.r.connection().hostname(host).connect();   //port(port).
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
