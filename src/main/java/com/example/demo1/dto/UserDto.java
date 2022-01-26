package com.example.demo1.dto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class UserDto {
    private Long seq;
    private String email;
    private String passwd;
    private int login_count;
    private LocalDateTime last_login_at;
    private LocalDateTime create_at;

}