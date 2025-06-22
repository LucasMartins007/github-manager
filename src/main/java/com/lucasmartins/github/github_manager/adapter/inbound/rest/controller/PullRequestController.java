package com.lucasmartins.github.github_manager.adapter.inbound.rest.controller;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PullRequestRequest;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.PullRequestResponse;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.mapper.PullRequestResponseMapper;
import com.lucasmartins.github.github_manager.application.ports.inbound.PullRequestControllerPort;
import com.lucasmartins.github.github_manager.application.ports.inbound.PullRequestServicePort;
import com.lucasmartins.github.github_manager.domain.exception.NotFoundException;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/github")
public class PullRequestController implements PullRequestControllerPort {

    private final PullRequestServicePort pullRequestServicePort;

    @Override
    @GetMapping(path = "/pull-requests")
    public ResponseEntity<List<PullRequestResponse>> listPRsWithLastCommit(
            @RequestParam(name = "repositoryName") String repositoryName,
            @RequestParam(name = "timeLimit") String timeLimit,
            @RequestParam(name = "lateCommits") boolean lateCommits) {

        log.info("Iniciando consulta de pull requests do repositorio {}", repositoryName);
        final PullRequestRequest pullRequestRequest = new PullRequestRequest(repositoryName, timeLimit, lateCommits);

        final List<PullRequestModel> pullRequestModels = pullRequestServicePort.listPullResquestsWithLastCommit(pullRequestRequest);
        if (pullRequestModels.isEmpty()) {
            throw new NotFoundException("Pulls requests do repositorio {0} não encontrado!", repositoryName);
        }

        log.info("Consulta de pull requests do repositorio {} finalizada com sucesso!", repositoryName);
        return ResponseEntity.ok(PullRequestResponseMapper
                .toResponseList(pullRequestModels));
    }

}
