package com.lucasmartins.github.github_manager.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PullRequestModel {

    private String repositoryName;

    private String personName;

    private String author;

    private String branchName;

    private String email;

    private String lastCommitMessage;

    private String openPrTime;

    private boolean isLate;

    private CommitDetailModel commitDetailModelList;

}
