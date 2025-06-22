package com.lucasmartins.github.github_manager.adapter.inbound.rest.mapper;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.CommitResponse;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;

public class CommitResponseMapper {

    private CommitResponseMapper() {
    }

    public static CommitResponse toCommitResponse(CommitDetailModel commitDetailModel) {
        return CommitResponse.builder()
                .url(commitDetailModel.getUrl())
                .sha(commitDetailModel.getSha())
                .email(commitDetailModel.getEmail())
                .date(commitDetailModel.getTime())
                .message(commitDetailModel.getMessage())
                .author(commitDetailModel.getAuthor())
                .build();
    }
}
