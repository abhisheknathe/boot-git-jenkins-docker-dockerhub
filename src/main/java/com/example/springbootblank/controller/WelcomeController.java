package com.example.springbootblank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/call")
public class WelcomeController {

    @GetMapping("/hello")
    public String welcome(){
        return "<h1>Hello, Abhishek, This is s docker application<h1>";
    }
}
