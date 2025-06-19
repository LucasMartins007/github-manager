package com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProtectionResponse {

    private boolean enabled;

    @JsonProperty("required_status_checks")
    private RequiredStatusChecksResponse requiredStatusChecks;
}
