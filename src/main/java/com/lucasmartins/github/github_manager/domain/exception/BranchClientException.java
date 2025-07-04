package com.lucasmartins.github.github_manager.domain.exception;

import com.lucasmartins.github.github_manager.domain.exception.abstracts.GeneralGithubManagerException;

public class BranchClientException extends GeneralGithubManagerException {

    public BranchClientException(String message, Object... args) {
        super(message, args);
    }
}
