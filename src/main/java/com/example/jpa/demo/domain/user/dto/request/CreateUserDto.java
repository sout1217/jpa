package com.example.jpa.demo.domain.user.dto.request;

import com.example.jpa.demo.domain.user.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateUserDto {

    public User toEntity() {
        return null;
    }
}
