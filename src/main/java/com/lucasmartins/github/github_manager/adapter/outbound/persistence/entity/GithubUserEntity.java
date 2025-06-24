package com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "github_user")
public class GithubUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_github_user_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_github_user", sequenceName = "seq_github_user")
    private Integer id;

    private String name;

    private String userName;

    private String branchName;

    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @OneToMany(mappedBy = "githubUserEntity")
    private List<PullRequestEntity> pullRequestEntityList;
}