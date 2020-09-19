package com.example.jpa.demo.domain.user.result;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.board.dto.BoardDto;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.dto.TeamDto;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class MyDataResult {

    List<TeamDto.Response> teams = new ArrayList<>();

    List<BoardDto.Response> boards = new ArrayList<>();

    private MyDataResult(List<TeamDto.Response> teams, List<BoardDto.Response> boards) {
        this.teams = teams;
        this.boards = boards;
    }

    public static MyDataResult of(List<Team> teams, List<Board> boards) {

        return new MyDataResult(TeamDto.toJsonList(teams), BoardDto.toJsonList(boards));
    }
}
