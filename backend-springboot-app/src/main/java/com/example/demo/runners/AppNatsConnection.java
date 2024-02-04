package com.example.demo.runners;

import com.example.demo.nats.AppNatsPublisher;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class AppNatsConnection implements CommandLineRunner {
    @Autowired AppNatsPublisher publisher;

    @Override
    public void run(String... args) throws Exception {
        String natsURL = "nats://localhost:4222";
        Connection nc = Nats.connect(natsURL);
        this.publisher.setConnection(nc);
        Dispatcher dispatcher = nc.createDispatcher((msg) -> {
            System.out.printf("%s on subject %s\n",
                    new String(msg.getData(), StandardCharsets.UTF_8),
                    msg.getSubject());
        });


        dispatcher.subscribe("SR");
    }

}
