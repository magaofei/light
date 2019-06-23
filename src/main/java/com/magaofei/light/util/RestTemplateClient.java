package com.magaofei.light.util;

import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {

    private RestTemplateClient() {}

    public static RestTemplate getInstance() {
        return RestClientHolder.INSTANCE;
    }

    private static class RestClientHolder {
        private static final RestTemplate INSTANCE = new RestTemplate();

    }
}
