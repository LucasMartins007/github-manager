package com.lucasmartins.github.github_manager.adapter.outbound.github.branches;

import com.lucasmartins.github.github_manager.adapter.outbound.github.branches.responses.BranchResponse;
import com.lucasmartins.github.github_manager.adapter.outbound.feign.interceptors.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "BranchesClient",
        url = "${github.client.base-url}",
        configuration = FeignInterceptor.class
)
public interface BranchesClient {

    @GetMapping(path = "${github.client.repo-owner}/{repository_name}/${github.client.branches-endpoint}")
    List<BranchResponse> listBranches(@PathVariable("repository_name") String repositoryName);
}
