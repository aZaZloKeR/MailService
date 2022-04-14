package com.azazland.mailservice.controller;

import com.azazland.mailservice.db.representation.UserRepr;
import com.azazland.mailservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping(value = "/mail/sendConfirmation")
    public void sendConfirmation(@RequestBody UserRepr userRepr){
        mailService.sendConformation(userRepr);
    }
    @GetMapping(value = "/mail/sendMessage/{messageId}")
    public void sendMessage(@PathVariable int messageId){
        mailService.sendMessage(messageId);
    }


}
