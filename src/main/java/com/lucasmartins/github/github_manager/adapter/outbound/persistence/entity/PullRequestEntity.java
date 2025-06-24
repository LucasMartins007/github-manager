package com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pull_request")
public class PullRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_pull_request_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_pull_request", sequenceName = "seq_pull_request")
    private Integer id;

    private String repositoryName;

    private String lastCommitMessage;

    private String openPrTime;

    @ManyToOne
    @JoinColumn(name = "github_user_id")
    private GithubUserEntity githubUserEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pullRequestEntity")
    private List<CommitDetailEntity> commitDetailEntityList;

}
