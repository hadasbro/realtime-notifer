** Realtime notifications, realtime publisher **


---

## Overview

This is just an example project how can we publish and subscribe realtime notification to user and/or concrete sessions.

*Solution base on Spring + websocked + RethinkDB*

Inside:

* Spring Boot (https://spring.io/projects/spring-boot)

* Hibernate (http://hibernate.org/)

* SockJs (https://github.com/sockjs)

* Stomp (http://stomp.github.io/)

* Jackson (https://github.com/FasterXML/jackson-databind)

* Thymeleaf (https://www.thymeleaf.org/)

* MySql (https://www.mysql.com/)

* Rethink DB (https://www.rethinkdb.com/) [ alternatively you can use Kafka (https://kafka.apache.org/)]

## Communication flow

System has 2 layers. REST layer (Spring REST + MySQL) and the Socket Communication Layer to communicate with client and subscribe changes in RethinkDB.


![picture](files/realtime-notifer.png)

---

## Testing

1. Update application.properties and set up your MySQL and RethinkDB credentials.
2. Check out client and sender HTML/JS example
    - http://localhost:8090/client
    - http://localhost:8090/sender
3. Open a few clients, log in as some of them and to conrete session and then open a sender window and try to publish notification to any of your clients/sessions
4. Now you can send any message or notification **to any user and concrete session/token** 
5. Also each user can have his own **subscribe channel** or many separate channels based on session/token

*Open below image in new tab to see the fullscreen example*

![picture](files/gif-notif.gif)


## Apache Kafka example

See https://www.baeldung.com/spring-kafka

## Web Sockets

See https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#websocket