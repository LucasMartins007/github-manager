package com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommitDetailResponse {

    private String sha;

    @JsonProperty("node_id")
    private String nodeId;

    private CommitDataResponse commit;

    private GitHubUserResponse author;

    private GitHubUserResponse committer;

    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    private List<CommitParentResponse> parents;
}
