package com.try01.service;

import com.try01.dto.SignupRequestDto;
import com.try01.model.User;
import com.try01.model.UserRoleEnum;
import com.try01.repository.UserRepository;
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

    public void registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인

        String username = requestDto.getUsername();
        if (! username.matches("^[a-zA-Z0-9]{3,}$"))
        {
            throw new IllegalArgumentException("'" + username+ "'" + "는 올바른 닉네임 형식이 아닙니다.");
        } else {
            Optional<User> foundUsername = userRepository.findByUsername(username);
            if (foundUsername.isPresent()) {
                throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

            String password = requestDto.getPassword();
            if (! password.matches("^[.]{4,}$") )
            {
                throw new IllegalArgumentException("비밀번호는 최소 4자 이상이며, 닉네임이 포함될 수 없습니다.");
            } else {
                password = passwordEncoder.encode(requestDto.getPassword()); // 패스워드 암호화
            }

            String email = requestDto.getEmail();

            // 사용자 ROLE 확인
            UserRoleEnum role = UserRoleEnum.USER;
            if (requestDto.isAdmin()) {
                if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                    throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
                }
                role = UserRoleEnum.ADMIN;
            }

            User user = new User(username, password, email, role);
            userRepository.save(user);
        }
    }
}