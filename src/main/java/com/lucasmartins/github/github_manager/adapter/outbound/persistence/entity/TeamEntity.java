package com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_team_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_team", sequenceName = "seq_team")
    private Integer id;

    private String name;

    private Integer numberOfMembers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private List<GithubUserEntity> githubUserEntityList;
}