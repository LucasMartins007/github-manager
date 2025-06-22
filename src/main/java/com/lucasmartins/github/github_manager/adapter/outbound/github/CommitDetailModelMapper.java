package com.lucasmartins.github.github_manager.adapter.outbound.github;

import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;

import java.util.List;

public class CommitDetailModelMapper {

    private CommitDetailModelMapper() {
    }

    public static CommitDetailModel toDomain(CommitDetailResponse commitDetailResponse, String branchName) {
        return CommitDetailModel.builder()
                .url(commitDetailResponse.getUrl())
                .sha(commitDetailResponse.getSha())
                .personName(branchName.replace("feature/", ""))
                .branchName(branchName)
                .author(commitDetailResponse.getCommit().getAuthor().getName())
                .email(commitDetailResponse.getCommit().getAuthor().getEmail())
                .message(commitDetailResponse.getCommit().getMessage())
                .time(commitDetailResponse.getCommit().getAuthor().getDate())
                .repositoryName(getRepositoryNameFromUrl(commitDetailResponse.getUrl()))
                .build();
    }

    public static List<CommitDetailModel> toDomainList(List<CommitDetailResponse> commitDetailResponses, String branchName) {
        return commitDetailResponses.stream()
                .map(commitDetailResponse -> toDomain(commitDetailResponse, branchName))
                .toList();
    }

    private static String getRepositoryNameFromUrl(String url) {
        final String[] parts = url.split("/");
        return parts.length > 5 ? parts[5] : null;
    }
}
