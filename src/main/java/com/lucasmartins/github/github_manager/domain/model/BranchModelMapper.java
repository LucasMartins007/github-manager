package com.lucasmartins.github.github_manager.domain.model;

import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses.BranchResponse;

public class BranchModelMapper {

    private BranchModelMapper() {
    }

    public static BranchModel toDomain(BranchResponse branchResponse) {
        return BranchModel.builder()
                .sha(branchResponse.getCommit().getSha())
                .branchName(branchResponse.getName())
                .url(branchResponse.getCommit().getUrl())
                .build();
    }
}
