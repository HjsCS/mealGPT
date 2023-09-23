package com.alimama.mealgpt.service;
import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.entity.User;
import com.alimama.mealgpt.pojo.*;


public interface UserService {
    void save(RegisterRequest registerRequest);

    User findByUserName(String userName);

    LoginResponse login(LoginRequest loginRequest);

    RegisterResponse register(RegisterRequest registerRequest);
}
