package com.lucasmartins.github.github_manager.rest;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@RequestMapping(path = "/manager")
public class GithubManagerController {

    // TODO criar DTO para retorno
    void listPRsWithLateCommit(String repositoryName, LocalDateTime timeLimit) {

    }
}
