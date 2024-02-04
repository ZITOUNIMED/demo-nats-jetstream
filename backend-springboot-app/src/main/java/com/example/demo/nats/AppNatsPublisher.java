package com.example.demo.nats;

import io.nats.client.Connection;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class AppNatsPublisher {
    private Connection nc;

    public void setConnection(Connection nc){
        this.nc = nc;
    }

    public void publish(String message){
        nc.publish("SR", message.getBytes(StandardCharsets.UTF_8));
    }
}
