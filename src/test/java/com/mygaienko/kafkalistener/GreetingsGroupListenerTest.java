package com.mygaienko.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by enda1n on 03.06.2018.
 */
@Slf4j
public class GreetingsGroupListenerTest {

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    @Test
    public void test() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 100; i++) {
            executor.execute(createTask(restTemplate, i));
        }

        executor.awaitTermination(10, TimeUnit.MINUTES);
    }

    private Runnable createTask(RestTemplate restTemplate, int i) {
        return () -> {
            restTemplate.getForObject("http://localhost:8080/greetings?message=hello" + i, Object.class);
            log.info("message {} sent", i);
        };
    }
}