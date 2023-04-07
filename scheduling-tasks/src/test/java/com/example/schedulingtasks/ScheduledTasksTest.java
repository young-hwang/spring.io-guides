package com.example.schedulingtasks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduledTasksTest {
    @SpyBean
    ScheduledTasks scheduledTasks;

    @Test
    void reportCurrentTime() {
        // given
        // when
        // then
        await().atMost(10, SECONDS).untilAsserted(() -> {
            Mockito.verify(scheduledTasks, Mockito.atLeast(2)).reportCurrentTime();
        });
    }
}