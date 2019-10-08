package com.zrh.sbls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发邮件测试
 * @author zhangrenhua
 */
@RestController
@RequestMapping("/test")
public class EmailController {

    @Autowired
    private JavaMailSender jms;
    
    @Value("${spring.mail.username}")
    private String from;
    
    @RequestMapping("sendSimpleEmail")
    public String sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            // 接收地址
            message.setTo("zhangrenhua@extracme.com");
            // 标题
            message.setSubject("一封简单的邮件");
            // 内容
            message.setText("使用Spring Boot发送简单邮件。");
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}