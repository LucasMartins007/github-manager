package com.lucasmartins.github.github_manager.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommitDetailModel {

    private String sha;

    private String personName;

    private String branchName;

    private String repositoryName;

    private String author;

    private String email;

    private String message;

    private String url;

    private String time;


}
