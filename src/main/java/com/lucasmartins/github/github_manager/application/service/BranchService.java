package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.domain.exception.BranchClientException;
import com.lucasmartins.github.github_manager.application.ports.outbound.BranchServicePort;
import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.BranchesClient;
import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses.BranchResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BranchService implements BranchServicePort {

    private final BranchesClient branchesClient;

    @Override
    public List<String> listBranchNamesByRepositoryName(String repositoryName) {
        try {
            var branchResponses = branchesClient.listBranches(repositoryName);

            log.info("Listando o nome das branches do repositorio {}", repositoryName);
            return branchResponses.stream()
                    .map(BranchResponse::getName)
                    .toList();
        } catch (FeignException e) {
            throw new BranchClientException("ocorreu um erro na consulta das branches: " + e);
        }
    }
}
