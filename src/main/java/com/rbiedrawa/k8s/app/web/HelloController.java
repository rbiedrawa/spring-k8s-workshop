package com.rbiedrawa.k8s.app.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${app.hello}")
    private String envVariable;

    @Value("${app.secret}")
    private String secret;

    @GetMapping
    ResponseEntity<String> hello() {
        log.info("Hello requested...");
        return ResponseEntity.ok(String.format("env variable %s, Secret %s", envVariable, secret));
    }
}
