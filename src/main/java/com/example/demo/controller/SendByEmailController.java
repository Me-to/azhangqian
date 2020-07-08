/**
 *
 */
package com.example.demo.controller;


import com.example.demo.service.impl.SendByEmailTools;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SendByEmailController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    @Qualifier("serdbyemail")
    private SendByEmailTools service;
    @Value("${spring.mail.username}")
    private String sender;

    @GetMapping("/a")
    public void aVoid(String message,String email) {
        rabbitTemplate.convertAndSend("hello", "" + message+"-"+email);
    }

    @GetMapping("/send")
    public String send(String message, String email) {
//		String receiver="zhangqianfun@163.com";  //这个是接受人的邮箱
        String receiver = email;  //这个是接受人的邮箱
        String title = "邮箱验证";    //标题
        String text = "验证码为 " + message;
        String result = service.send(sender, receiver, title, text);
        return result;
    }

}