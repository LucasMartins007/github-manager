package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.adapter.outbound.github.CommitDetailModelMapper;
import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.CommitsClient;
import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import com.lucasmartins.github.github_manager.domain.exception.CommitsClientException;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class CommitService implements CommitServicePort {

    private final CommitsClient commitsClient;

    @Override
    public List<CommitDetailModel> listCommitsFromBranch(String repositoryName, String branchName) {
        try {
            final List<CommitDetailResponse> commitDetailResponses = listCommitsFromBranchName(repositoryName, branchName);

            return CommitDetailModelMapper.toDomainList(commitDetailResponses, branchName);
        } catch (Exception e) {
            throw new CommitsClientException("ocorreu um erro na consulta dos commits da branch " + branchName + ": " + e.getMessage());
        }
    }

    @Override
    public CommitDetailModel getMostRecentCommitFromBranch(String repositoryName, String branchName) {
        try {
            final List<CommitDetailResponse> commitDetailResponses = listCommitsFromBranchName(repositoryName, branchName);
            final List<CommitDetailModel> commitDetailModels = CommitDetailModelMapper.toDomainList(commitDetailResponses, branchName);

            return commitDetailModels.stream()
                    .filter(Objects::nonNull)
                    .min(CommitService::sortMostRecent)
                    .orElse(null);
        } catch (FeignException e) {
            log.error("ocorreu um erro na consulta do commits mais recente da branch {}: {}", branchName, e.getMessage());
            throw new CommitsClientException("ocorreu um erro na consulta do commits mais recente da branch " + branchName + ": " + e.getMessage());
        }
    }

    private List<CommitDetailResponse> listCommitsFromBranchName(String repositoryName, String branchName) {
        try {
            log.info("Iniciando consulta dos commits da branch {}", branchName);
            final List<CommitDetailResponse> commits = commitsClient.listCommitsFromBranchName(repositoryName, branchName);

            log.info("Consulta dos commits da branch {} finalizada com sucesso!", branchName);

            return commits;
        } catch (FeignException.NotFound e) {
            log.error("Não foram encontrados commits na branch {}: {}", branchName, e.getMessage());
            throw new CommitsClientException("Não foram encontrados commits na branch {0}: {1}", branchName, e);

        } catch (FeignException e) {
            log.error("ocorreu um erro na consulta dos commits da branch {}: {}", branchName, e.getMessage());
            throw new CommitsClientException("ocorreu um erro na consulta dos commits da branch {0}: {1}", branchName, e);
        }
    }

    private static int sortMostRecent(CommitDetailModel commitDetailResponse, CommitDetailModel commitDetailResponse1) {
        final Instant d1 = Instant.parse(commitDetailResponse.getTime());
        final Instant d2 = Instant.parse(commitDetailResponse.getTime());
        return d2.compareTo(d1);
    }
}
