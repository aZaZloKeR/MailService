package com.azazland.mailservice.service;

import com.azazland.mailservice.config.MailConfig;
import com.azazland.mailservice.db.model.MailingData;
import com.azazland.mailservice.db.model.Messages;
import com.azazland.mailservice.db.repository.MailingDataRepo;
import com.azazland.mailservice.db.repository.MessagesRepo;
import com.azazland.mailservice.db.representation.UserRepr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.ArrayList;

@Service
public class MailService {
    @Autowired
    MailConfig mailConfig;
    @Autowired
    MessagesRepo messagesRepo;
    @Autowired
    MailingDataRepo mailingDataRepo;
    @Value("${spring.mail.username}")
    private String login;

    public void sendConformation(UserRepr userRepr){
        sendEmail(
                "Подтверждение вашего email",
                "Здравствуйте " + userRepr.getName() + ", подтвердите пожалуйста ваш email: " + generateUrl(userRepr.getUserId()),
                userRepr.getMail()
        );
    }

    private void sendEmail(String to,String theme, String body){
        JavaMailSender javaMailSender = mailConfig.getMailSender();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(login);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(theme);
        simpleMailMessage.setText(body);
        try {
            javaMailSender.send(simpleMailMessage);
        }
        catch( Exception e){
            e.printStackTrace();
        }
    }
    private String generateUrl(int userId){
        return "79.120.10.217:1500/auth/verified/{" + generateToken(userId) + "}";
    }

    private String generateToken(int userId){
        String temp = "";
        byte[] bytes = ByteBuffer.allocate(4).putInt(userId*69+5051).array();
        for(byte b: bytes){
            temp += b;
        }
        return temp;
    }

    public void sendMessage(int messageId){
        Iterable<MailingData> mailingDataAll = mailingDataRepo.findAllByMessageId(messageId);
        if (messagesRepo.findById(messageId).isPresent()) {
            Messages messages = messagesRepo.findById(messageId).get();
            for (MailingData mailingData :mailingDataAll){
                sendEmail(mailingData.getMail(), messages.getTheme(),messages.getBody());//,messages.getName() Не используется тут, хз надо ли
            }
        }
    }

}
