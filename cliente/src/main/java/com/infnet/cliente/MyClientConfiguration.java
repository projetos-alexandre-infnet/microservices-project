package com.infnet.cliente;

import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class MyClientConfiguration {

    @Value("${api.username}")
    private String username;

    @Value("${api.password}")
    private String password;

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", username);
            requestTemplate.header("password", password);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}