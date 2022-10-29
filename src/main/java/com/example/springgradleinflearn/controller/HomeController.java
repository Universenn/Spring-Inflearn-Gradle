package com.example.springgradleinflearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
