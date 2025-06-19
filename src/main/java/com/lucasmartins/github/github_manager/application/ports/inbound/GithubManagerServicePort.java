package com.lucasmartins.github.github_manager.application.ports.inbound;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.GithubManagerResponse;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PrWithLastCommitRequest;

import java.util.List;

public interface GithubManagerServicePort {

    List<GithubManagerResponse> listPRsWithLastCommit(PrWithLastCommitRequest prWithLastCommitRequest);

}
