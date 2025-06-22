package com.lucasmartins.github.github_manager.domain.exception.abstracts;

import java.text.MessageFormat;

public abstract class GeneralGithubManagerException extends RuntimeException {

    protected GeneralGithubManagerException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
