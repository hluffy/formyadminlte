package com.welleplus.controller;

import com.welleplus.result.Result;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("test")
@RestController
public class Test {

    @CrossOrigin
    @RequestMapping("test")
    public Result test(HttpServletRequest request) {
//        获取IP
//        String ip = request.getRemoteAddr();
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
//            ip = request.getHeader("x-forwarded-for");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        System.out.println(ip);
        Result result = new Result();
//        result.setData(ip);
        result.setStatus(true);
        return result;
    }

    @GetMapping("testerror")
    public void testError() {
        String str = null;
        str.substring(2);

    }
}
