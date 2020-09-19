package com.example.jpa.demo.domain.team.controller;

import com.example.jpa.demo.domain.team.application.TeamService;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.dto.TeamDto;
import com.example.jpa.demo.result.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class TeamApi {

    private final TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<?> createTeam(@RequestBody final TeamDto.Request creationRequestDto) {

        log.info("createTeamDto -> {}", creationRequestDto);

        final Team team = teamService.createTeam(creationRequestDto);

        return ApiResult.ok("팀 생성", team);
    }
}
