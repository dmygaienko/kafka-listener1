package com.mygaienko.kafkalistener1;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by enda1n on 02.06.2018.
 */
public interface GreetingsStreams {

    String INPUT = "greetings-in";

    String GROUP_INPUT = "group-greetings-in";

    String PART_INPUT = "part-greetings-in";

    String PART_INPUT2 = "part-greetings-in2";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();

    @Input(GROUP_INPUT)
    SubscribableChannel groupInboundGreetings();

    @Input(PART_INPUT)
    SubscribableChannel partInboundGreetings();

    @Input(PART_INPUT2)
    SubscribableChannel partInboundGreetings2();

}
