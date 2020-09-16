package com.example.jpa.demo.domain.team.dto.request;

import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.user.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateTeamDto {

    private String name;

    private Long userId; // @AuthenticationPrinciple 로 대체 가능

    public Team toEntity(User user) {
        return Team.create()
                .name(this.name)
                .user(user)
                .build();
    }
}
