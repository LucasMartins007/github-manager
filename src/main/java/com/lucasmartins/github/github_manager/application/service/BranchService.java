package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.BranchesClient;
import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses.BranchResponse;
import com.lucasmartins.github.github_manager.application.ports.outbound.BranchServicePort;
import com.lucasmartins.github.github_manager.domain.exception.BranchClientException;
import com.lucasmartins.github.github_manager.domain.exception.NotFoundException;
import com.lucasmartins.github.github_manager.domain.model.BranchModel;
import com.lucasmartins.github.github_manager.domain.model.BranchModelMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BranchService implements BranchServicePort {

    private final BranchesClient branchesClient;

    @Override
    public List<BranchModel> listBranchNamesByRepositoryName(String repositoryName) {
        final List<BranchResponse> branchResponses = listBranchesFromRepository(repositoryName);

        return branchResponses.stream()
                .map(BranchModelMapper::toDomain)
                .toList();
    }

    private List<BranchResponse> listBranchesFromRepository(String repositoryName) {
        try {
            log.info("Iniciando consulta das branches do repositorio {}", repositoryName);
            final List<BranchResponse> branchResponses = branchesClient.listBranches(repositoryName);

            log.info("Consulta das branches do repositorio {} finalizada com sucesso!", repositoryName);
            return branchResponses;
        } catch (FeignException.NotFound e) {
            throw new NotFoundException("Não foram encontradas branches do repositorio {0}: {1}", repositoryName, e);

        } catch (FeignException e) {
            throw new BranchClientException("Ocorreu um erro na consulta das branches: {0}", e);

        }
    }
}
