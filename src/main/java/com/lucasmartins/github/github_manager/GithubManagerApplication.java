package com.lucasmartins.github.github_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GithubManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubManagerApplication.class, args);
    }

}
