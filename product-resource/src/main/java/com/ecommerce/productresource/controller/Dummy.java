package com.ecommerce.productresource.controller;

import com.ecommerce.productresource.ProductResourceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Dummy {

    private static final Logger log = LoggerFactory.getLogger(ProductResourceApplication.class);

    @GetMapping("/test")
    public String test(){

        log.info("Hello Zipkin test log");
        return "Hello from test";
    }
}
