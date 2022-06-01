package com.sparta.springcore.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends Timestamped
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String password;

    private String contents;

    private List<Comment> comments = new ArrayList<>();

    public Board(String title, String password, String contents)
    {
        this.title = title;
        this.password = password;
        this.contents = contents;
    }


}
