package com.tajbir.Security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        return "Hello World!" + request.getSession().getId();
    }
}
