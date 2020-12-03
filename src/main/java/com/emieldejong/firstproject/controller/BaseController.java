package com.emieldejong.firstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String say_hello() {
        return "Hello world!!!";
    }

    @GetMapping("/koffie")
    public String koffie() {
        return "Graag een kopje koffie!!!";
    }
}
