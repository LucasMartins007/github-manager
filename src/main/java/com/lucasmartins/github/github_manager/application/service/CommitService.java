package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.CommitsClient;
import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import com.lucasmartins.github.github_manager.domain.exception.CommitsClientException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommitService implements CommitServicePort {

    private final CommitsClient commitsClient;

    @Override
    public CommitDetailResponse getMostRecentCommitFromBranch(String repositoryName, String branchName) {
        try {
            log.info("iniciando consulta dos commits da branch {}", branchName);
            final List<CommitDetailResponse> commits = commitsClient.listCommitsFromBranchName(repositoryName, branchName);

            return commits.stream()
                    .filter(Objects::nonNull)
                    .min(CommitService::sortMostRecent)
                    .map(commit -> {
                        commit.setBranchName(branchName);
                        return commit;
                    })
                    .orElse(null);
        } catch (FeignException e) {
            log.error("ocorreu um erro na consulta do commits mais recente da branch {}: {}", branchName, e.getMessage());
            throw new CommitsClientException("ocorreu um erro na consulta do commits mais recente da branch " + branchName + ": " + e.getMessage());
        }
    }

    private static int sortMostRecent(CommitDetailResponse commitDetailResponse, CommitDetailResponse commitDetailResponse1) {
        final Instant d1 = Instant.parse(commitDetailResponse.getCommit().getCommitter().getDate());
        final Instant d2 = Instant.parse(commitDetailResponse1.getCommit().getCommitter().getDate());
        return d2.compareTo(d1);
    }
}
