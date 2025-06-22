package com.lucasmartins.github.github_manager.adapter.inbound.rest.controller;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.output.response.CommitResponse;
import com.lucasmartins.github.github_manager.adapter.inbound.rest.mapper.CommitResponseMapper;
import com.lucasmartins.github.github_manager.application.ports.inbound.CommitsControllerPort;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/github")
public class CommitsController implements CommitsControllerPort {

    private final CommitServicePort commitServicePort;

    @Override
    @GetMapping(path = "/commits")
    public List<CommitResponse> listCommitsFromBranchName(
            @RequestParam("repositoryName") String repositoryName,
            @RequestParam("branchName") String branchName
    ) {
        log.info("Iniciando consulta dos commits da branch {}", branchName);
        final List<CommitDetailModel> commitDetailModels = commitServicePort.listCommitsFromBranch(repositoryName, branchName);

        log.info("Consulta dos commits da branch {} finalizada com sucesso!", branchName);
        return commitDetailModels.stream()
                .map(CommitResponseMapper::toCommitResponse)
                .toList();
    }
}
