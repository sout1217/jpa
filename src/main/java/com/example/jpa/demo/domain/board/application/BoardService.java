package com.example.jpa.demo.domain.board.application;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.BoardRepository;
import com.example.jpa.demo.domain.board.dto.BoardDto;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.TeamRepository;
import com.example.jpa.demo.domain.user.User;
import com.example.jpa.demo.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public List<Board> findBoards(Long userId) {

        return boardRepository.findAllByUserId(userId);

    }

    public Board createBoard(BoardDto.Request createBoardDto) {


        User user = userRepository.findById(createBoardDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("아이디 없음"));


        Team team = teamRepository.findById(createBoardDto.getTeamId()).orElse(null);

        return boardRepository.save(createBoardDto.toEntity(user, team));
    }
}
