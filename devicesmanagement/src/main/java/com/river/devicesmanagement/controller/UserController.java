package com.river.devicesmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(value = "/user")
    @ResponseBody
    public String userApi(){
        return "Returned successfully from User API";
    }

    @GetMapping(value = "/admin")
    @ResponseBody
    public String adminApi(){
        return "Returned successfully from Admin API";
    }
}
