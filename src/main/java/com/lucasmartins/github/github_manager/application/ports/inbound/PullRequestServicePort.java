package com.lucasmartins.github.github_manager.application.ports.inbound;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PullRequestRequest;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;

import java.util.List;

public interface PullRequestServicePort {

    List<PullRequestModel> listPullResquestsWithLastCommit(PullRequestRequest pullRequestRequest);

}
