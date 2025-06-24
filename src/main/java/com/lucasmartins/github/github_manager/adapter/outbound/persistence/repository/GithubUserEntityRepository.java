package com.lucasmartins.github.github_manager.adapter.outbound.persistence.repository;

import com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity.GithubUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubUserEntityRepository extends JpaRepository<GithubUserEntity, Integer> {
}