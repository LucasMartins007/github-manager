package com.lucasmartins.github.github_manager.application.ports.outbound;

import com.lucasmartins.github.github_manager.domain.model.BranchModel;

import java.util.List;

public interface BranchServicePort {

    List<BranchModel> listBranchNamesByRepositoryName(String repositoryName);
}
