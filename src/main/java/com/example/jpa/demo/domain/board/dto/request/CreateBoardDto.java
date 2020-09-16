package com.example.jpa.demo.domain.board.dto.request;

import com.example.jpa.demo.domain.board.Board;
import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.user.User;
import lombok.Getter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@ToString
public class CreateBoardDto  {


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
