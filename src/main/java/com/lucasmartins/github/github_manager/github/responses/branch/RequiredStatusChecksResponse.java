package com.lucasmartins.github.github_manager.github.responses.branch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequiredStatusChecksResponse {

    @JsonProperty("enforcement_level")
    private String enforcementLevel;

    private List<String> contexts;
    private List<String> checks;
}
