package com.lucasmartins.github.github_manager.github.responses.commits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitVerification {

    private boolean verified;

    private String reason;

    private String signature;

    private String payload;

    @JsonProperty("verified_at")
    private String verifiedAt;
}
