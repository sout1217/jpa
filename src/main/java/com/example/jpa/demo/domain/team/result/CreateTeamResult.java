package com.example.jpa.demo.domain.team.result;

import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.team.dto.TeamDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CreateTeamResult {

    @JsonProperty(value = "type")
    private final String type;

    @JsonProperty(value = "team")
    private final TeamDto.Response response;

    private CreateTeamResult(String type, TeamDto.Response response) {
        this.type = type;
        this.response = response;
    }

    public static CreateTeamResult create( String type, Team team) {

        return new CreateTeamResult(type, TeamDto.toJson(team));

    }
}
