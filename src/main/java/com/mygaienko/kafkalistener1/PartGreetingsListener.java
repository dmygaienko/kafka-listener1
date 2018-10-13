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
public class PartGreetingsListener {

    @Value("${spring.application.name}")
    private String appName;

    @StreamListener(GreetingsStreams.PART_INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Partitioned. Instance {}. Received greetings: {}", appName, greetings);
    }

    @StreamListener(GreetingsStreams.PART_INPUT2)
    public void handleGreetings2(@Payload Greetings greetings) {
        log.info("Partitioned. Group: partGroup2. Instance {}. Received greetings: {}", appName, greetings);
    }
}
