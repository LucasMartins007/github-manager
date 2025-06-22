package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;

public interface CommitServicePort {

    CommitDetailModel getMostRecentCommitFromBranch(String repositoryName, String branchName);
}
