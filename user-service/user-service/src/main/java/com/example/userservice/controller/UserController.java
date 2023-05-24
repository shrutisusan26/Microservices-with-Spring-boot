package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.Users;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        log.info("inside user service to post");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside user service to get user information with department");
        return  userService.getUserWithDepartment(userId);
    }


}
