package com.lucasmartins.github.github_manager.github.clients;

import com.lucasmartins.github.github_manager.github.responses.commits.CommitDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "BranchesClient",
        url = "${github.client.base-url}"
)
public interface CommitsClient {

    @GetMapping(path = "${github.client.repo-owner}/{repository_name}/commits")
    List<CommitDataResponse> listCommitsFromBranchName(
            @PathVariable("repository_name") String repositoryName,
            @RequestParam("sha") String branchName
    );
}
