package com.example.jpa.demo.domain.user.controller;

import com.example.jpa.demo.domain.board.application.BoardService;
import com.example.jpa.demo.domain.team.application.TeamService;
import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.result.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/users")
public class MeApi {

    private final TeamService teamService;

    private final BoardService boardService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getMyData(@PathVariable("userId") final Long userId) {

        log.info("userId -> {}", userId);

        List<Team> teams = teamService.findTeams(userId);
        List<Board> boards = boardService.findBoards(userId);

        return ApiResult.ok(teams, boards);
    }

}
