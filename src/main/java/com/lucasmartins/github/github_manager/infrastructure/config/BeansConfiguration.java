package com.lucasmartins.github.github_manager.infrastructure.config;

import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.BranchesClient;
import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.CommitsClient;
import com.lucasmartins.github.github_manager.application.ports.inbound.PullRequestServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.BranchServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import com.lucasmartins.github.github_manager.application.service.BranchService;
import com.lucasmartins.github.github_manager.application.service.CommitService;
import com.lucasmartins.github.github_manager.application.service.PullRequestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public BranchServicePort branchService(BranchesClient branchesClient) {
        return new BranchService(branchesClient);
    }

    @Bean
    public CommitServicePort commitService(CommitsClient commitsClient) {
        return new CommitService(commitsClient);
    }

    @Bean
    public PullRequestServicePort githubManagerService(BranchServicePort branchServicePort, CommitServicePort commitServicePort) {
        return new PullRequestService(branchServicePort, commitServicePort);
    }
}