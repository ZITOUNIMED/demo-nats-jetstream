package com.example.demo;

import io.nats.client.*;
import io.nats.client.api.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class App {
    public static void main(String[] args) {

        Options options = new Options.Builder().
                server("connect.ngs.global").
                authHandler(Nats.credentials("C:/dev/NGS-Mohamed-Zitouni-Medzit.creds")).
                build();
        try (Connection nc = Nats.connect(options)){
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
