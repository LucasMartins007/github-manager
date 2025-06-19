package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;

import java.util.List;

public interface CommitServicePort {

    List<CommitDetailResponse> listCommitsFromBranch(String branchName, String repositoryName);

    List<CommitDetailResponse> listCommitsFromBranchUntil(String branchName, String repositoryName, String until);

    CommitDetailResponse getMostRecentCommit(String repositoryName, String branchName);
}
