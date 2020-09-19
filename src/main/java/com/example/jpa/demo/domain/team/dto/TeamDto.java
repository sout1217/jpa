package com.example.jpa.demo.domain.team.dto;

import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class TeamDto {

    public static Response toJson(Team team) {
        if ( StringUtils.isEmpty(team) ||  StringUtils.isEmpty(team.getId())) {
            throw new IllegalArgumentException("team must exist and userId of team must exist !");
        }

        return Response.builder()
                .id(team.getId())
                .name(team.getName())
                .archived(team.isArchived())
                .createdAt(team.getCreatedAt())
                .userId(team.getUser().getId())
                .build();
    }

    public static List<Response> toJsonList(List<Team> teams) {

        if ( StringUtils.isEmpty(teams) ) {
            return Collections.emptyList();
        }

        return teams.stream()
                .map(TeamDto::toJson)
                .collect(Collectors.toList());
    }

    @Getter
    @ToString
    public static class Request {

        private String name;

        private Long userId; // @AuthenticationPrinciple 로 대체 가능

        public Team toEntity(User user) {
            return Team.create()
                    .name(this.name)
                    .user(user)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class Response {

        private final Long id;
        private final String name;
        private final boolean archived;
        private final Date createdAt;
        private final Long userId;

        @Builder
        private Response(Long id, String name, boolean archived, Date createdAt, Long userId) {
            this.id = id;
            this.name = name;
            this.archived = archived;
            this.createdAt = createdAt;
            this.userId = userId;
        }
    }

}
