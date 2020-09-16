package com.example.jpa.demo.controller;

import com.example.jpa.demo.application.BoardService;
import com.example.jpa.demo.application.TeamService;
import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.team.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/users")
public class ControllerApi {

    private final TeamService teamService;

    private final BoardService boardService;

    @GetMapping(value = "/{userId}")
    public Map<String, List<?>> getAccount(@PathVariable("userId") Long userId) {

        log.info("userId -> {}", userId);

        List<Team> teams = teamService.findTeams(userId);
        List<Board> boards = boardService.findBoards(userId);

        Map<String, List<?>> map = new HashMap<>();

        map.put("teams", teams);
        map.put("boards", boards);

        return map;
    }

}
