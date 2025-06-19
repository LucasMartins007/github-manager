package com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommitDetailResponse {

    private String sha;

    @JsonProperty("node_id")
    private String nodeId;

    private String branchName;

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
