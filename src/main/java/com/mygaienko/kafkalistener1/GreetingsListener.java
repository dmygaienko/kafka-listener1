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
public class GreetingsListener {

    @Value("${spring.application.name}")
    private String appName;

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Instance {}. Received greetings: {}", appName, greetings);
    }
}
