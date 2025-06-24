package com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commit_detail")
public class CommitDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_team_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_team", sequenceName = "seq_team")
    private Integer id;

    private String sha;

    private String message;

    private String authorName;

    private String authorEmail;

    @ManyToOne
    @JoinColumn(name = "pull_request_entity_id")
    private PullRequestEntity pullRequestEntity;

}