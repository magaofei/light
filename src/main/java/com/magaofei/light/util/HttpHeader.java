package com.magaofei.light.util;

import com.magaofei.light.config.HttpConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.http.HttpHeaders.USER_AGENT;

public class HttpHeader {

    private static final Logger logger = LoggerFactory.getLogger(HttpHeader.class);

    public static HttpHeaders commonHeaders() {
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.set(USER_AGENT, HttpConstant.USER_AGENT_FIREFOX);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        return httpHeaders;
    }
}
