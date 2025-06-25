package com.lucasmartins.github.github_manager.adapter.outbound.github.mapper;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PullRequestRequest;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;

public class PullRequestModelMapper {

    private PullRequestModelMapper() {
    }

    public static PullRequestModel toDomain(PullRequestRequest pullRequestRequest, CommitDetailModel commitDetailModel) {
        return PullRequestModel.builder()
                .repositoryName(pullRequestRequest.getRepositoryName())
                .personName(commitDetailModel.getPersonName())
                .branchName(commitDetailModel.getBranchName())
                .author(commitDetailModel.getAuthor())
                .email(commitDetailModel.getEmail())
                .commitDetailModelList(Collections.singletonList(commitDetailModel))
                .commitMessage(commitDetailModel.getMessage())
                .openPrTime(commitDetailModel.getTime())
                .isLate(isLateCommit(commitDetailModel.getTime(), pullRequestRequest.getTimeLimit()))
                .build();
    }

    private static boolean isLateCommit(String lastCommitDate, String commitDateLimit) {
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
