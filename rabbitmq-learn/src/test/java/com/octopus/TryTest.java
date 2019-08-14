package com.octopus;

import com.octpous.RabbitMQApplication;
import com.octpous.config.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class TryTest {
    @Autowired
    private Sender sender;

    @Test
    public void trySend() {
        sender.send();
    }
}
