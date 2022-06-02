package com.sparta.springcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class SignupRequestDto {

    @NotNull
    @Length(min = 3, message = "닉네임은 최소 3글자 이상으로 생성해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "생성할 수 없는 닉네임 형식입니다.")
    private String username;

    @Length(min = 4, message = "비밀번호는 최소 4글자 이상으로 생성해주세요.")
    private String password;

    private String checkPassword;

    private boolean admin = false;

    private String adminToken = "";
}