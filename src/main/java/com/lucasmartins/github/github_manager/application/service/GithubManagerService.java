package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PrWithLastCommitRequest;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.GithubManagerResponse;
import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;
import com.lucasmartins.github.github_manager.application.ports.inbound.GithubManagerServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.BranchServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubManagerService implements GithubManagerServicePort {

    private final BranchServicePort branchServicePort;

    private final CommitServicePort commitServicePort;

    @Override
    public List<GithubManagerResponse> listPRsWithLastCommit(PrWithLastCommitRequest prWithLastCommitRequest) {
        final List<String> branchNames = branchServicePort.listBranchNamesByRepositoryName(prWithLastCommitRequest.getRepositoryName());

        final List<CommitDetailResponse> commitDataResponses = branchNames.stream()
                .map(branchName -> commitServicePort.getMostRecentCommitFromBranch(prWithLastCommitRequest.getRepositoryName(), branchName))
                .toList();

        return commitDataResponses.stream()
                .filter(Objects::nonNull)
                .map(commitDetailResponse -> createGihubManagerDto(prWithLastCommitRequest, commitDetailResponse))
                .filter(githubManagerResponse -> filterLateCommits(prWithLastCommitRequest.isLateCommits(), githubManagerResponse))
                .toList();
    }

    private static boolean filterLateCommits(boolean lateCommits, GithubManagerResponse githubManagerResponse) {
        if (lateCommits) {
            return githubManagerResponse.isLateCommit();
        }
        return !githubManagerResponse.isLateCommit();
    }


    private GithubManagerResponse createGihubManagerDto(PrWithLastCommitRequest prWithLastCommitRequest, CommitDetailResponse commitDetailResponse) {
        return GithubManagerResponse.builder()
                .repositoryName(prWithLastCommitRequest.getRepositoryName())
                .personName(commitDetailResponse.getBranchName().replace("feature/", ""))
                .branchName(commitDetailResponse.getBranchName())
                .lastCommitMessage(commitDetailResponse.getCommit().getMessage())
                .lastCommitTime(commitDetailResponse.getCommit().getCommitter().getDate())
                .openPrTime(commitDetailResponse.getCommit().getCommitter().getDate())
                .isLateCommit(isLateCommit(commitDetailResponse.getCommit().getCommitter().getDate(), prWithLastCommitRequest.getTimeLimit()))
                .build();
    }

    public boolean isLateCommit(String lastCommitDate, String commitDateLimit) {
        try {
            final DateTimeFormatter limitFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            final LocalDateTime limitDate = LocalDateTime.parse(commitDateLimit, limitFormatter);
            final Instant referenceInstant = limitDate.toInstant(ZoneOffset.UTC);

            final Instant commitInstant = Instant.parse(lastCommitDate);

            return commitInstant.isAfter(referenceInstant);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido", e);
        }
    }

}
