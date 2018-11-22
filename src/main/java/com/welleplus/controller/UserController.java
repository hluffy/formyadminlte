package com.welleplus.controller;

import com.welleplus.entity.User;
import com.welleplus.result.Result;
import com.welleplus.server.UserServer;
import com.welleplus.utils.Md5Util;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserServer userServer;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @CrossOrigin
    @RequestMapping("save")
    public Result saveUser(@RequestBody  User user){
        Result result = new Result();
        if(user==null){
            result.setStatus(false);
            result.setMessage("参数不能为空");
            return result;
        }
        if(StringUtils.isEmpty(user.getUserName())){
            result.setStatus(false);
            result.setMessage("用户名不允许为空");
            return result;
        }

        if(StringUtils.isEmpty(user.getPassword())){
            result.setStatus(false);
            result.setMessage("密码不允许为空");
            return result;
        }
        User info = userServer.findByUserName(user.getUserName());
        if(info!=null){
            result.setStatus(false);
            result.setMessage("用户名已存在");
            return result;
        }

        user.setPassword(Md5Util.md5String(user.getPassword()));
        User data = userServer.save(user);
        result.setStatus(true);
        result.setMessage("保存成功");
        result.setData(data);
        return result;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("findall")
    public Result findAll(){
        Result result = new Result();
        List<User> users = userServer.findAll();
        result.setData(users);
        result.setStatus(true);
        return result;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @CrossOrigin
    @PostMapping("edituser")
    public Result editUser(@RequestBody User user){
        Result result = new Result();
        if(user==null){
            result.setStatus(false);
            result.setMessage("参数不能为空!");
            return result;
        }
        if(StringUtils.isEmpty(user.getUserName().trim())){
            result.setStatus(false);
            result.setMessage("用户名不允许为空!");
            return result;
        }
        User data = userServer.findByUserName(user.getUserName());
        if(data!=null){
            result.setStatus(false);
            result.setMessage("用户名已存在！");
            return result;
        }
        User updateUser = userServer.save(user);
        result.setData(updateUser);
        result.setStatus(true);
        result.setMessage("保存成功！");
        return result;
    }

    /**
     * 删除用户信息
     * @param user
     * @return
     */
    @CrossOrigin
    @PostMapping("deleteuser")
    public Result deleteUser(@RequestBody User user){
        Result result = new Result();
        if(user==null){
            result.setStatus(false);
            result.setMessage("参数不允许为空！");
            return result;
        }
        userServer.deleteById(user.getId());
        result.setStatus(true);
        result.setMessage("删除成功！");
        return result;
    }

    /**
     * 测试异常
     * @throws Exception
     */
    @GetMapping("testexception")
    public void testException() throws Exception {
        throw new Exception();
    }


}
