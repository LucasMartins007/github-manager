package com.lucasmartins.github.github_manager.github.clients;

import com.lucasmartins.github.github_manager.github.responses.branch.BranchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "BranchesClient",
        url = "${github.client.base-url}"
)
public interface BranchesClient {

    @GetMapping(path = "${github.client.repo-owner}/{repository_name}/branches")
    List<BranchResponse> listBranches(@PathVariable("repository_name") String repositoryName);
}
