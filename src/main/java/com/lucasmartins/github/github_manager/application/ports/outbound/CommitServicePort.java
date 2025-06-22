package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;

import java.util.List;

public interface CommitServicePort {

    List<CommitDetailModel> listCommitsFromBranch(String repositoryName, String branchName);

    CommitDetailModel getMostRecentCommitFromBranch(String repositoryName, String branchName);
}
