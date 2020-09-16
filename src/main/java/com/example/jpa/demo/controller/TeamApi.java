package com.example.jpa.demo.controller;

import com.example.jpa.demo.application.TeamService;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.dto.request.CreateTeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Team createTeam(@RequestBody CreateTeamDto createTeamDto) {

        log.info("createTeamDto -> {}", createTeamDto);

        return teamService.createTeam(createTeamDto);
    }
}
