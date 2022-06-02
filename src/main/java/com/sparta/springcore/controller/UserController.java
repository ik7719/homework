package com.sparta.springcore.controller;

import com.sparta.springcore.dto.SignupRequestDto;
import com.sparta.springcore.dto.UserInfoDto;
import com.sparta.springcore.domain.UserRoleEnum;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/loginView")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<SignupRequestDto> registerUser(@Valid SignupRequestDto requestDto) {
        SignupRequestDto user = userService.registerUser(requestDto);
        return ResponseEntity.ok(user);
    }

    // 회원 관련 정보 받기
    @PostMapping("/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        UserRoleEnum role = userDetails.getUser().getRole();
        boolean isAdmin = (role == UserRoleEnum.ADMIN);

        return new UserInfoDto(username, isAdmin);
    }
}