package com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GithubManagerResponse {

    private String repositoryName;

    private String personName;

    private String branchName;

    private String lastCommitMessage;

    private String openPrTime;

    private String lastCommitTime;

    private boolean isLateCommit;
}
