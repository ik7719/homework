package com.sparta.springcore.service;

import com.sparta.springcore.dto.SignupRequestDto;
import com.sparta.springcore.domain.User;
import com.sparta.springcore.domain.UserRoleEnum;
import com.sparta.springcore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignupRequestDto registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인

        String username = requestDto.getUsername();
        Optional<User> foundUsername = userRepository.findByUsername(username);
        if (foundUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        String password = requestDto.getPassword();
        String checkPassword = requestDto.getCheckPassword();
        if(password.contains(username) || !checkPassword.equals(requestDto.getCheckPassword()))
        {
            throw new IllegalArgumentException
                    ("\n" + "비밀번호에 닉네임이 포함되면 안됩니다." + "\n" + "비밀번호가 일치하지 않습니다.");
        } else {
            password = passwordEncoder.encode(requestDto.getPassword());
            checkPassword = passwordEncoder.encode(requestDto.getPassword());// 패스워드 암호화
        }

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, role, checkPassword);
        userRepository.save(user);
        return requestDto;
    }
}

