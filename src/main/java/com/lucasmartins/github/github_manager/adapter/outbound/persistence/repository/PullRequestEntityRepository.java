package com.lucasmartins.github.github_manager.adapter.outbound.persistence.repository;

import com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity.PullRequestEntity;
import com.lucasmartins.github.github_manager.domain.model.PullRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PullRequestEntityRepository extends JpaRepository<PullRequestEntity, Integer> {

    PullRequestEntity save(PullRequestModel pullRequestModel);

}