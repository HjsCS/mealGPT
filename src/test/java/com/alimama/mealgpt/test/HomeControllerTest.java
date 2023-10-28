package com.alimama.mealgpt.test;

import com.alimama.mealgpt.controller.HomeController;
import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.pojo.*;
import com.alimama.mealgpt.service.FitnessService;
import com.alimama.mealgpt.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private FitnessService fitnessService;


    @Test
    public void testLoginEndpoint() throws Exception {
        LoginRequest loginRequest = new LoginRequest("john", "fun123");
        LoginResponse loginResponse = new LoginResponse("john", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huIiwiaWF0IjoxNjk4NDY3MjYzLCJleHAiOjE2OTg1MDMyNjN9.W2tqs5L9lvWhTxFAT_SkaUWuemnBOJTYn5rJHcBXGIYY5jxfC7ZVtU-u0hzfK7CSz3o0rf3eW3tOa5-kLg3cUQ");

        Mockito.when(userService.login(Mockito.any(LoginRequest.class))).thenReturn(loginResponse);

        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", Matchers.notNullValue()));
    }

    @Test
    public void testRegisterEndpoint() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("Hengji", "0421440171", "hengji@gmail.com", "hengji123", "MALE");
        RegisterResponse registerResponse = new RegisterResponse("Successfully Registered Hengji");

        Mockito.when(userService.register(Mockito.any(RegisterRequest.class))).thenReturn(registerResponse);

        mockMvc.perform(post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(registerRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.notNullValue()));
    }

    @Test
    public void testUpdateFitnessInfoEndpoint() throws Exception {
        FitnessInfoUpdateRequest fitnessInfoUpdateRequest = new FitnessInfoUpdateRequest("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huIiwiaWF0IjoxNjk4NDY3MjYzLCJleHAiOjE2OTg1MDMyNjN9.W2tqs5L9lvWhTxFAT_SkaUWuemnBOJTYn5rJHcBXGIYY5jxfC7ZVtU-u0hzfK7CSz3o0rf3eW3tOa5-kLg3cUQ", new FitnessInfo("Hengji", 177.12, 90.0,"lose weight", "MALE", 22, "gym once a week"));
        FitnessInfoUpdateResponse fitnessInfoUpdateResponse = new FitnessInfoUpdateResponse("Successfully update your fitness Info Hengji");

        Mockito.when(fitnessService.update(Mockito.any(FitnessInfoUpdateRequest.class))).thenReturn(fitnessInfoUpdateResponse);

        mockMvc.perform(post("/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(fitnessInfoUpdateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.notNullValue()));
    }

    // Helper method to convert objects to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

