package com.example.demo;

import java.util.concurrent.TimeUnit;

import com.example.demo.receiver.Receiver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;

  public Runner( RabbitTemplate rabbitTemplate) {

    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Sending message...");
    rabbitTemplate.convertAndSend(RabbitMqTestApplication.topicExchangeName, "foo.bar.teste", "Hello from RabbitMQ!");
  }

}