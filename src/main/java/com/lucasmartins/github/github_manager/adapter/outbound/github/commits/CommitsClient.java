package com.lucasmartins.github.github_manager.adapter.outbound.github.commits;

import com.lucasmartins.github.github_manager.adapter.outbound.github.commits.responses.CommitDetailResponse;
import com.lucasmartins.github.github_manager.adapter.outbound.feign.interceptors.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "CommitsClient",
        url = "${github.client.base-url}",
        configuration = FeignInterceptor.class
)
public interface CommitsClient {

    @GetMapping(path = "${github.client.repo-owner}/{repository_name}/commits")
    List<CommitDetailResponse> listCommitsFromBranchName(
            @PathVariable("repository_name") String repositoryName,
            @RequestParam("sha") String branchName
    );

    @GetMapping(path = "${github.client.repo-owner}/{repository_name}/commits")
    List<CommitDetailResponse> listCommitsFromBranchNameUntil(
            @PathVariable("repository_name") String repositoryName,
            @RequestParam("sha") String branchName,
            @RequestParam("until") String untilDate
    );
}
