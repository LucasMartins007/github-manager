package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;

public interface CommitServicePort {

    CommitDetailResponse getMostRecentCommitFromBranch(String repositoryName, String branchName);
}
