package com.example.jpa.demo.init;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.BoardRepository;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.TeamRepository;
import com.example.jpa.demo.domain.user.User;
import com.example.jpa.demo.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        User user = User.create()
                .username("root")
                .password("root")
                .build();

        Team team = Team.create()
                .name("Rose Class")
                .user(user)
                .build();

        Board board = Board.create()
                .name("게시글")
                .description("게시글 내용")
                .user(user)
                .team(team)
                .build();

        boolean userExisted = userRepository.existsById(1L);
        boolean teamExisted = teamRepository.existsById(1L);
        boolean boardExisted = boardRepository.existsById(1L);


        if ( !userExisted ) {
            userRepository.save(user);
        }

        if ( !teamExisted ) {
            teamRepository.save(team);
        }

        if ( !boardExisted ) {

            boardRepository.save(board);
        }

    }
}
