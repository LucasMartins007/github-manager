package com.lucasmartins.github.github_manager.application.ports.outbound;

import java.util.List;

public interface BranchServicePort {

    List<String> listBranchNamesByRepositoryName(String repositoryName);
}
