package com.maven.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maven.task.dto.Loginrequest;
import com.maven.task.model.User;
import com.maven.task.security.Jwtutil;
import com.maven.task.service.Userservice;

@RestController
@RequestMapping("/api/v1/auth")
public class Authcontroller {

	@Autowired
    private Userservice userService;
	
	@Autowired
    private Jwtutil jwtutil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody Loginrequest request) {
    	User user=userService.login(request);
        return jwtutil.generateToken(user.getEmail());
    }
}
