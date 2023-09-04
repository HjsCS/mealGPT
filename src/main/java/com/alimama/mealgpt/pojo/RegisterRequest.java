package com.alimama.mealgpt.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterRequest {

    @NotBlank(message = "username can not be blank")
    private String userName;
    @NotBlank
    @Pattern(regexp = "^(02|03|04|07|08)\\d{8}$", message = "Invalid Australian phone number")
    private String phoneNumber;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "password can not be blank")
    private String password;
    @NotBlank(message = "gender can not be blank")
    private String gender;
}
