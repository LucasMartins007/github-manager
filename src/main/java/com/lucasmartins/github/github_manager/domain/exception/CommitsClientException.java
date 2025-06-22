package com.lucasmartins.github.github_manager.domain.exception;

import com.lucasmartins.github.github_manager.domain.exception.abstracts.GeneralGithubManagerException;

public class CommitsClientException extends GeneralGithubManagerException {

    public CommitsClientException(String message, Object... args) {
        super(message, args);
    }

}
