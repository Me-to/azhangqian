package com.example.demo.mq;

import com.example.demo.controller.SendByEmailController;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloCustomer {
    @Autowired
    SendByEmailController controller;

    @RabbitHandler
    public void receive1(String message1) {
        String message = message1.split("-")[0];
        String email = message1.split("-")[1];
        controller.send(message, email);
    }


}
