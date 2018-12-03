package com.welleplus.controller;

import com.welleplus.entity.User;
import com.welleplus.result.Result;
import com.welleplus.server.UserServer;
import com.welleplus.utils.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("login")
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserServer userServer;
    /**
     * 登录
     * @param params
     * @return
     */
    @CrossOrigin
    @RequestMapping("login")
    public Result login(@RequestBody Map<String,String> params, HttpServletRequest request){
        Result result = new Result();
        if(params==null){
            result.setStatus(false);
            result.setMessage("参数不能为空");
            return result;
        }

        String userName = params.get("userName");
        String password = params.get("password");

        if(StringUtils.isEmpty(userName)){
            result.setStatus(false);
            result.setMessage("用户名不允许为空");
            return result;
        }

        if(StringUtils.isEmpty(password)){
            result.setStatus(false);
            result.setMessage("密码不允许为空");
            return result;
        }

        password = Md5Util.md5String(password);
        User loginUser = userServer.findByUserName(userName);
        if(loginUser==null){
            result.setStatus(false);
            result.setMessage("用户不存在！");
            return result;
        }
        User user = userServer.findByUserNameAndPassword(userName,password);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username",userName);
            session.setAttribute("password",password);
            result.setData(user);

            result.setStatus(true);
            result.setMessage("登录成功!");
            logger.info(userName + " 登录成功!");
        }else{
            result.setStatus(false);
            result.setMessage("用户名或密码错误");
            logger.info(userName + " 登录失败!");
        }

        return result;
    }

    /**
     * 退出
     * @param request
     */
    @CrossOrigin
    @GetMapping("logout")
    public Result logout(HttpServletRequest request){
        Result result = new Result();
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("username");
        session.removeAttribute("username");
        result.setStatus(true);
        logger.info(userName + " 退出成功!");
        return result;
    }
}
