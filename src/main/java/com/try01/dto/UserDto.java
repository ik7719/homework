package com.try01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDto
{
    private Long id;
    private String writer;
    private String titles;
    private String comment;

    private String username;
    private String password;
    private String samePassword;
}
