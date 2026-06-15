package com.demo.controller;

import com.demo.pojo.Emp;
import com.demo.pojo.LoginInfo;
import com.demo.pojo.Result;
import com.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
private EmpService empService;
    @RequestMapping
    public Result login(@RequestBody Emp emp) {
     log.info("用户登录，用户名：{}", emp.getName());
     LoginInfo info = empService.login(emp);
       if (info != null) {
           return Result.success(info);
       }
           return Result.error("用户名或密码错误");
    }
}
