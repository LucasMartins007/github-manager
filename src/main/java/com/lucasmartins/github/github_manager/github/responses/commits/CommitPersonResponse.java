package com.lucasmartins.github.github_manager.github.responses.commits;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitPersonResponse {

    private String name;

    private String email;

    private String date;
}
