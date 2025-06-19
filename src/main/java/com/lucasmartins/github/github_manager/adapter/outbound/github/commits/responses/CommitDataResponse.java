package com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitDataResponse {

    private CommitPersonResponse author;

    private CommitPersonResponse committer;

    private String message;

    private CommitTreeResponse tree;

    @JsonProperty("comment_count")
    private int commentCount;

    private CommitVerification verification;
}
