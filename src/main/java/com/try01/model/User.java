package com.try01.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.Setter;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "users")
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id // 자동으로 unique
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String checkPassword;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    // db에 저장할 때 String으로 변환해서 저장
    private UserRoleEnum role; // 값을 한정 짓기 위해서

    public User(String username, String password, UserRoleEnum role, String checkPassword) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.checkPassword = checkPassword;
    }
}