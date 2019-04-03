package org.bitbucket.slawekhaa.realtimenotifer.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class RethinkConfig {

    @Autowired
    private Environment env;

    public static String DBHOST = "";
    public static Integer DBPORT = 0;

    @PostConstruct
    public void init() {

        DBHOST = this.env.getProperty("rethinkdb.dbhost");
        DBPORT = Integer.parseInt(this.env.getProperty("rethinkdb.dbport"));

    }

    @Bean
    public RethinkConnector connectionFactory() {
        return new RethinkConnector(DBHOST, DBPORT);
    }

    @Bean
    DbInitializer dbInitializer() {
        return new DbInitializer();
    }
}
