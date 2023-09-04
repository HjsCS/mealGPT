package com.alimama.mealgpt.service;

import com.alimama.mealgpt.dao.AuthoritiesRepository;
import com.alimama.mealgpt.dao.UserRepository;
import com.alimama.mealgpt.entity.Authorities;
import com.alimama.mealgpt.entity.User;
import com.alimama.mealgpt.entity.WebUser;
import com.alimama.mealgpt.pojo.LoginRequest;
import com.alimama.mealgpt.pojo.LoginResponse;
import com.alimama.mealgpt.pojo.RegisterRequest;
import com.alimama.mealgpt.pojo.RegisterResponse;
import com.alimama.mealgpt.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AuthoritiesRepository authoritiesRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository, AuthoritiesRepository theAuthoritiesRepository, BCryptPasswordEncoder thePasswordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = theUserRepository;
        this.authoritiesRepository = theAuthoritiesRepository;
        this.passwordEncoder = thePasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        User user = userRepository.findUserByUserName(loginRequest.getUserName());
        System.out.println(user.getUsername());
        if (user != null) {

            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
                String token = jwtTokenProvider.generateToken(user);
                loginResponse.setToken(token);
                loginResponse.setUserName(user.getUsername());
            }
        }
        return loginResponse;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();

        if (registerRequest != null) {
            String userName = registerRequest.getUserName().toString();
            registerResponse.setMsg("Successfully Registered " + userName);
            save(registerRequest);
        } else {
            registerResponse.setMsg("Unknown issue occur");
        }

        return registerResponse;
    }

    @Override
    public void save(RegisterRequest registerRequest) {
        User user = new User();

        user.setUserName(registerRequest.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setGender(registerRequest.getGender());
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
        authoritiesRepository.save(new Authorities(registerRequest.getUserName(), "ROLE_USER"));

    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }



}
