package com.welleplus.controller;

import com.welleplus.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class Test {

    @CrossOrigin
    @RequestMapping("test")
    public Result test(){
        Result result = new Result();
        result.setStatus(true);
        return result;
    }

    @GetMapping("testerror")
    public void testError(){
        String str = null;
        str.substring(2);

    }
}
