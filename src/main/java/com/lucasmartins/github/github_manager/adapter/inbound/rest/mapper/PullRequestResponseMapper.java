package com.lucasmartins.github.github_manager.adapter.inbound.rest.mapper;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.PullRequestResponse;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;

import java.util.List;

public class PullRequestResponseMapper {

    private PullRequestResponseMapper() {
    }

    public static PullRequestResponse toResponse(PullRequestModel pullRequestModel) {
        return PullRequestResponse.builder()
                .repositoryName(pullRequestModel.getRepositoryName())
                .branchName(pullRequestModel.getBranchName())
                .lastCommitMessage(pullRequestModel.getLastCommitMessage())
                .openPrTime(pullRequestModel.getOpenPrTime())
                .personName(pullRequestModel.getPersonName())
                .isLate(pullRequestModel.isLate())
                .commitResponse(CommitResponseMapper.toCommitResponse(pullRequestModel.getCommitDetailModelList()))
                .build();
    }

    public static List<PullRequestResponse> toResponseList(List<PullRequestModel> pullRequestModels) {
        return pullRequestModels.stream()
                .map(PullRequestResponseMapper::toResponse)
                .toList();
    }
}
