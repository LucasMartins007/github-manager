package com.lucasmartins.github.github_manager.adapter.outbound.persistence.repository;

import com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamEntityRepository extends JpaRepository<TeamEntity, Integer> {
}