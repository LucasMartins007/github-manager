package com.lucasmartins.github.github_manager.adapter.outbound.persistence.repository;

import com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity.CommitDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitDetailEntityRepository extends JpaRepository<CommitDetailEntity, Integer> {
}