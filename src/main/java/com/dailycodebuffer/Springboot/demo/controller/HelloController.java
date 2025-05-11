package com.dailycodebuffer.Springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //@RequestMapping
    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloworld(){
        return msg;
    }

    @Value("${welcome.message}")
    private String msg;
}
