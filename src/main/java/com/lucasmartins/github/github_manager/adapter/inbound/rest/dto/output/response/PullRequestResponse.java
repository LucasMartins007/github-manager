package com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PullRequestResponse {

    private String repositoryName;

    private String personName;

    private String branchName;

    private String lastCommitMessage;

    private String openPrTime;

    private boolean isLate;

    private CommitResponse commitResponse;
}
