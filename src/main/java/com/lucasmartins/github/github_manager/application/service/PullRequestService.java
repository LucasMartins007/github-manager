package com.lucasmartins.github.github_manager.application.service;

import com.lucasmartins.github.github_manager.adapter.inbound.rest.dto.input.request.PullRequestRequest;
import com.lucasmartins.github.github_manager.adapter.outbound.github.mapper.PullRequestModelMapper;
import com.lucasmartins.github.github_manager.application.ports.inbound.PullRequestServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.BranchServicePort;
import com.lucasmartins.github.github_manager.application.ports.outbound.CommitServicePort;
import com.lucasmartins.github.github_manager.domain.exception.PullRequestServiceException;
import com.lucasmartins.github.github_manager.domain.model.BranchModel;
import com.lucasmartins.github.github_manager.domain.model.CommitDetailModel;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PullRequestService implements PullRequestServicePort {

    private final BranchServicePort branchServicePort;

    private final CommitServicePort commitServicePort;

    @Override
    public List<PullRequestModel> listPullResquestsWithLastCommit(PullRequestRequest pullRequestRequest) {
        try {
            final List<BranchModel> branchModels = branchServicePort.listBranchNamesByRepositoryName(pullRequestRequest.getRepositoryName());

            return branchModels.parallelStream()
                    .map(branchModel -> getMostRecentCommitFromBranch(pullRequestRequest, branchModel))
                    .map(commitDetailModel -> PullRequestModelMapper.toDomain(pullRequestRequest, commitDetailModel))
                    .filter(pullRequestModel -> pullRequestModel.isLate() == pullRequestRequest.isLateCommits())
                    .toList();
        } catch (Exception e) {
            throw new PullRequestServiceException("Ocorreu um erro ao listar os pull requests com o commit mais recente do repositorio {0}: {1}", pullRequestRequest.getRepositoryName(), e);
        }
    }

    private CommitDetailModel getMostRecentCommitFromBranch(PullRequestRequest pullRequestRequest, BranchModel branchModel) {
        return commitServicePort.getMostRecentCommitFromBranch(pullRequestRequest.getRepositoryName(), branchModel.getBranchName());
    }

}
