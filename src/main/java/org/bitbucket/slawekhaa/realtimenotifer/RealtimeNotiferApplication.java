package org.bitbucket.slawekhaa.realtimenotifer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RealtimeNotiferApplication {

    
    public static void main(String[] args) {
        SpringApplication.run(RealtimeNotiferApplication.class, args);
    }
}
