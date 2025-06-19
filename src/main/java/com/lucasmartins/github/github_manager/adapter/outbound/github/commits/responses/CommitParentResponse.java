package com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommitParentResponse {


    private String sha;

    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

}
