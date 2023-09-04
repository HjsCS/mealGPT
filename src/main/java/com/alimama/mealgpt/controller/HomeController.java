package com.alimama.mealgpt.controller;

import com.alimama.mealgpt.pojo.*;
import com.alimama.mealgpt.result.ApiResult;
import com.alimama.mealgpt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        // whether the user found or not

        LoginResponse loginResponse = userService.login(loginRequest);

        HttpStatus code;
        if (loginResponse.getToken() == null) {
            code = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(code, "User not found");
            //return "User not found";
            //return new ResponseEntity(code, loginResponse);
        } else {
            code = HttpStatus.ACCEPTED;
            return new ResponseEntity(code, loginResponse);
        }


    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);

        HttpStatus code = HttpStatus.ACCEPTED;

        return new ResponseEntity(code, registerResponse);
    }

    @GetMapping("/test")
    public String sayHello() {
        return "Hello World";
    }

}