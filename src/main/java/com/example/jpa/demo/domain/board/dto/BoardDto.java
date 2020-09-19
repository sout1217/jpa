package com.example.jpa.demo.domain.board.dto;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {


    public static Response toJson(Board board) {

        if ( StringUtils.isEmpty(board) || StringUtils.isEmpty(board.getUser()) ) {
            throw new IllegalArgumentException("board must exist and userId of board must exist !");
        }

        return Response.builder()
                .id(board.getId())
                .name(board.getName())
                .createdAt(board.getCreatedAt())
                .userId(board.getUser().getId())
                .teamId(board.getTeam() != null ? board.getTeam().getId() : null)
                .build();

    }

    public static List<Response> toJsonList(List<Board> boards) {

        if ( StringUtils.isEmpty(boards) ) {
            return Collections.emptyList();
        }

        return boards.stream()
                .map(BoardDto::toJson)
                .collect(Collectors.toList());
    }

    @Getter
    @ToString
    public static class Request {

        private String name;

        private String description;

        private Long userId; // @AuthenticationPrinciple 로 대체 가능

        private Long teamId;


        public Board toEntity(User user, Team team) {

            return Board.create()
                    .name(this.name)
                    .description(this.description)
                    .user(user)
                    .team(team)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class Response {

        private Long id;
        private String name;
        private Date createdAt;
        private Long userId;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long teamId;

        @Builder
        private Response(Long id, String name, Date createdAt, Long userId, Long teamId) {
            this.id = id;
            this.name = name;
            this.createdAt = createdAt;
            this.userId = userId;
            this.teamId = teamId;
        }
    }
}
