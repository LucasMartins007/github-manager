package com.lucasmartins.github.github_manager.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BranchModel {

    private String branchName;

    private String sha;

    private String url;

}
