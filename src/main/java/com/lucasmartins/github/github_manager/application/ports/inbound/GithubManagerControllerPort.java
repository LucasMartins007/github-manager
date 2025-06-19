package com.lucasmartins.github.github_manager.application.ports.inbound;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.GithubManagerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GithubManagerControllerPort {

    @GetMapping
    List<GithubManagerResponse> listPRsWithLastCommit(@RequestParam(name = "repositoryName") String repositoryName,
                                                      @RequestParam(name = "timeLimit") String timeLimit,
                                                      @RequestParam(name = "lateCommits") boolean lateCommits);
}
