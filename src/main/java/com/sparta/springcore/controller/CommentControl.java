package com.sparta.springcore.controller;

import com.sparta.springcore.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentControl
{
    private final CommentService commentService;
}
