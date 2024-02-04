package com.example.demo;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class App2 {
    public static void main(String[] args) {
        String natsURL = "nats://localhost:4222";

        // System.getenv("NATS_URL");
        /*if (natsURL == null) {
            natsURL = "nats://nats:4222";
        }*/

        try (Connection nc = Nats.connect(natsURL)) {

            byte[] messageBytes = "hello".getBytes(StandardCharsets.UTF_8);
            nc.publish("greet.joe", messageBytes);

            Dispatcher dispatcher = nc.createDispatcher((msg) -> {
                System.out.printf("%s on subject %s\n",
                        new String(msg.getData(), StandardCharsets.UTF_8),
                        msg.getSubject());
            });


            dispatcher.subscribe("greet.*");


            nc.publish("greet.bob", messageBytes);
            nc.publish("greet.sue", messageBytes);
            nc.publish("greet.pam", messageBytes);


            Thread.sleep(200);


        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
