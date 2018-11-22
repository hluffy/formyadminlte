package com.welleplus.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class Md5Util {
    public static void main(String[] args) {
        String str = "test";
        System.out.println(md5String(str));

    }
    public static String md5String(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64 = new BASE64Encoder();
            str = base64.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }
}
