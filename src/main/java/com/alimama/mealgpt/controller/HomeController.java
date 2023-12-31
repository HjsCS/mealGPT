package com.alimama.mealgpt.controller;

import com.alimama.mealgpt.dao.FitnessInfoRepository;
import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.entity.GptPlan;
import com.alimama.mealgpt.pojo.*;
import com.alimama.mealgpt.result.ApiResult;
import com.alimama.mealgpt.service.FitnessService;
import com.alimama.mealgpt.service.PlanService;
import com.alimama.mealgpt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private FitnessService fitnessService;

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

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);

        HttpStatus code = HttpStatus.ACCEPTED;

        return new ResponseEntity(code, registerResponse);
    }

    @GetMapping("test")
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("update")
    public ResponseEntity updateFitnessInfo(@RequestBody FitnessInfoUpdateRequest fitnessInfoUpdateRequest) {
        FitnessInfoUpdateResponse fitnessInfoUpdateResponse = fitnessService.update(fitnessInfoUpdateRequest);
        HttpStatus code;
        if (fitnessInfoUpdateResponse.getMsg() == null) {
            code = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(code, "Fail to Update");
        } else {
            code = HttpStatus.ACCEPTED;
            return new ResponseEntity(code, fitnessInfoUpdateResponse);
        }


    }

    @GetMapping("getFitnessInfo")
    public ResponseListEntity getFitnessInfo(@RequestParam String username) {
        List<FitnessInfo> fitnessInfoList = fitnessService.getFitnessInfoByUserName(username);

        if (fitnessInfoList == null || fitnessInfoList.isEmpty()) {
            return new ResponseListEntity(HttpStatus.BAD_REQUEST, Collections.emptyList());
        } else {
            System.out.println("FitnessInfo List: " + fitnessInfoList);
            return new ResponseListEntity(HttpStatus.ACCEPTED, fitnessInfoList);
        }
    }

    @Autowired
    private PlanService planService;

    @PostMapping("savePlan")
    public ResponseEntity savePlan(@RequestBody GptPlanEntity gptPlanEntity) {
        try {
            planService.savePlan(gptPlanEntity);
            return new ResponseEntity(HttpStatus.ACCEPTED, "Plan saved successfully");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST, "Error saving the plan");
        }
    }


}