package com.lucasmartins.github.github_manager.adapter.outbound.persistence.adapter;

import com.lucasmartins.github.github_manager.adapter.outbound.persistence.entity.GithubUserEntity;
import com.lucasmartins.github.github_manager.adapter.outbound.persistence.mapper.GithubUserEntityMapper;
import com.lucasmartins.github.github_manager.adapter.outbound.persistence.repository.GithubUserEntityRepository;
import com.lucasmartins.github.github_manager.application.ports.outbound.GithubUserRepository;
import com.lucasmartins.github.github_manager.domain.model.GithubUserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GithubPersistenceAdapter implements GithubUserRepository {

    private final GithubUserEntityRepository githubUserEntityRepository;

    @Override
    public GithubUserEntity save(GithubUserModel githubUserModel) {
        final GithubUserEntity githubUserEntity = GithubUserEntityMapper.toEntity(githubUserModel);

        return githubUserEntityRepository.save(githubUserEntity);
    }

    @Override
    public Optional<GithubUserEntity> findById(Integer id) {
        return githubUserEntityRepository.findById(id);
    }

    @Override
    public List<GithubUserEntity> findAll() {
        return githubUserEntityRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        githubUserEntityRepository.deleteById(id);
    }
}
