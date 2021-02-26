package com.brunamello.mvc.mudi.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("nome", "Mundo");
        return "Hello";
    }
}
