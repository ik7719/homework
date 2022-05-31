package com.try01.controller;

import com.try01.domain.User;
import com.try01.repository.UserRepository;
import com.try01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/comments") // 댓글 목록 조회 API
    public List<User> getComments()
    {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }
}