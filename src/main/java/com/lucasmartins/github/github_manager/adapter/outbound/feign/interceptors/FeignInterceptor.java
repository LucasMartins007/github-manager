package com.lucasmartins.github.github_manager.adapter.outbound.feign.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {

    @Value("${github.security.token}")
    private String bearertoken;

    @Value("${github.client.user-agent}")
    private String userAgent;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + bearertoken);
        template.header("User-Agent", userAgent);
    }
}
