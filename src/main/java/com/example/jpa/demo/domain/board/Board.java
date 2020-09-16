package com.example.jpa.demo.domain.board;

import com.example.jpa.demo.domain.team.Team;
import com.example.jpa.demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean archived;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @Builder(builderMethodName = "create")
    private Board(String name, String description, User user, Team team) {
        this.name = name;
        this.description = description;
        this.archived = false;
        this.user = user;
        this.team = team;
    }
}
