package com.welleplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("view")
@Controller
public class ViewController {
    @CrossOrigin
    @GetMapping("tologin")
    public String toLogin(){
        return "http://localhost/my-adminlte/login/";
    }
}
