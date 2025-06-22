package com.lucasmartins.github.github_manager.domain.exception;

import com.lucasmartins.github.github_manager.domain.exception.abstracts.GeneralGithubManagerException;

public class PullRequestServiceException extends GeneralGithubManagerException {

    public PullRequestServiceException(String message, Object... args) {
        super(message, args);
    }
}
