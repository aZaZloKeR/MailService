package com.azazland.mailservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.ArrayList;
import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.protocol}")
    private String protocol;

    //не делаю бином, так как хочу пересоздавать каждый раз, что бы настройки SMTP сервера изменялись динамически
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties prop = mailSender.getJavaMailProperties();
        //prop.setProperty("mail.smtp.starttls.enable","true");
        prop.setProperty("mail.transport.protocol",protocol);
        prop.setProperty("mail.smtp.ssl.protocols","TLSv1.2");

        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));
        mailSender.setUsername(username);
        mailSender.setPassword(password);


        return mailSender;
    }
}
