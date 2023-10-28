package com.alimama.mealgpt.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    private String userName;
    private String password;


}
