package com.example.demo.http;

import java.io.IOException;

import com.example.demo.RabbitMqTestApplication;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitRestClient {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private Channel channel;

  @GetMapping(value = "/")
  public String index(){
    return "Hello World!";
  }

  @GetMapping(value = "/{message}")
  public String postMessage(@PathVariable("message") String message){
    rabbitTemplate.convertAndSend(RabbitMqTestApplication.topicExchangeName, "foo.bar.teste", message);

    return message;
  }

  @GetMapping(value = "/pull")
  public String pull() throws IOException {
    GetResponse response = channel.basicGet(RabbitMqTestApplication.queueName,true);

    if(response == null ){

      return "Nenhuma mensagem";

    } else {

      return new String(response.getBody());

    }


  }

}
