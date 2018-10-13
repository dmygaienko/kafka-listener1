package com.mygaienko.kafkalistener1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by enda1n on 02.06.2018.
 */
@Component
@Slf4j
public class GreetingsGroupListener {

    @Value("${spring.application.name}")
    private String appName;

    @StreamListener(GreetingsStreams.GROUP_INPUT)
    public void handleGreetings1st(@Payload Greetings greetings) {
        log.info("Instance {}. Received greetings by 3rd group listener: {}", appName, greetings);
    }

    @StreamListener(GreetingsStreams.GROUP_INPUT)
    public void handleGreetings2nd(@Payload Greetings greetings) {
        log.info("Instance {}. Received greetings by 4th group listener: {}", appName, greetings);
    }
}
