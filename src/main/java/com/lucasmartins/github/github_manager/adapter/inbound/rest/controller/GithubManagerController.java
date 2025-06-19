package com.lucasmartins.github.github_manager.adapter.inbound.rest.controller;

import com.lucasmartins.github.github_manager.application.ports.inbound.GithubManagerServicePort;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.GithubManagerResponse;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PrWithLastCommitRequest;
import com.lucasmartins.github.github_manager.application.ports.inbound.GithubManagerControllerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/manager")
public class GithubManagerController implements GithubManagerControllerPort {

    private final GithubManagerServicePort githubManagerServicePort;

    public GithubManagerController(GithubManagerServicePort githubManagerServicePort) {
        this.githubManagerServicePort = githubManagerServicePort;
    }

    @Override
    @GetMapping
    public List<GithubManagerResponse> listPRsWithLastCommit(@RequestParam(name = "repositoryName") String repositoryName,
                                                             @RequestParam(name = "timeLimit") String timeLimit,
                                                             @RequestParam(name = "lateCommits") boolean lateCommits) {
        final PrWithLastCommitRequest prWithLastCommitRequest = new PrWithLastCommitRequest(repositoryName, timeLimit, lateCommits);

        return githubManagerServicePort.listPRsWithLastCommit(prWithLastCommitRequest);
    }

}
