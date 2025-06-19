package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses.BranchResponse;

import java.util.List;

public interface BranchServicePort {

    List<BranchResponse> findBranchesByRepositoryName(String repositoryName);

    List<String> listBranchNamesByRepositoryName(String repositoryName);
}
