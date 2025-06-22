package com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PullRequestRequest {

    private String repositoryName;

    private String timeLimit;

    private boolean lateCommits;
}
