package com.lucasmartins.github.github_manager.application.ports.inbound;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.CommitResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CommitsControllerPort {

    @GetMapping
    List<CommitResponse> listCommitsFromBranchName(String repositoryName, String branchName);
}
