package com.try01.service;

import com.try01.domain.User;
import com.try01.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    User user = new User();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}