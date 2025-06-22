package com.lucasmartins.github.github_manager.domain.exception;

import com.lucasmartins.github.github_manager.domain.exception.abstracts.GeneralGithubManagerException;

public class NotFoundException extends GeneralGithubManagerException {

    public NotFoundException(String message, Object... args) {
        super(message, args);
    }
}
