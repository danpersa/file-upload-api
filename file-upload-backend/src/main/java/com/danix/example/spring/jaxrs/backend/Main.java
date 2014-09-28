package com.danix.example.spring.jaxrs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author dpersa
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[]{Initializer.class}, args);
    }
}
