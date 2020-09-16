package com.example.jpa.demo.application;

import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.TeamRepository;
import com.example.jpa.demo.domain.user.User;
import com.example.jpa.demo.domain.user.UserRepository;
import com.example.jpa.demo.domain.team.dto.request.CreateTeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;


    public List<Team> findTeams(Long userId) {

        return teamRepository.findAllByUserId(userId);
    }

    public Team createTeam(CreateTeamDto createTeamDto) {

        User user = userRepository.findById(createTeamDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("아이디 없음"));

        return teamRepository.save(createTeamDto.toEntity(user));
    }
}
