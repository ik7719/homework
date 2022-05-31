package com.try01.domain;

import com.try01.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    private String password;

    private String samePassword;

    private String regExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])";

    @Column(nullable = false)
    private String titles;

    @Column(nullable = false)
    private String writer;

    public void getComments(UserDto userDto) {
        this.comment = userDto.getComment();
    }
}