package com.azazland.mailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

@RestController
public class TestController {

    @GetMapping(value = "test/getByte")
    public String getByte(){
        String temp = "";
        byte[] bytes = ByteBuffer.allocate(4).putInt(20*69+5051).array();
        for(byte b: bytes){
            temp += b;
        }
        return temp;
    }
}
