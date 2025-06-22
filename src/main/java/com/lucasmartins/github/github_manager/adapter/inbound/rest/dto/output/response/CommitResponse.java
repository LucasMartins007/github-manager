package com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommitResponse {

    private String sha;

    private String author;

    private String email;

    private String date;

    private String message;

    private String url;

}
