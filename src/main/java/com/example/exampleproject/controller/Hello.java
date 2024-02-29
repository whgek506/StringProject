package com.example.exampleproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    private final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

    //http://localhost:8080/swagger-ui/index.html
    @GetMapping(value = "/hello")
    public String Hello() {
        return "Hello";
    }

    @PostMapping("log-test")
    public void logTest() {

        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }
}
