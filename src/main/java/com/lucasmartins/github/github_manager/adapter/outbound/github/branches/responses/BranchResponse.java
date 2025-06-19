package com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchResponse {

    private String name;

    private CommitResponse commit;

    @JsonProperty("protected")
    private boolean isProtected;

    private ProtectionResponse protection;

    @JsonProperty("protection_url")
    private String protectionUrl;
}
