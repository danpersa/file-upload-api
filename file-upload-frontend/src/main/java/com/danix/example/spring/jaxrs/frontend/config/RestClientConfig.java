package com.danix.example.spring.jaxrs.frontend.config;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.danix.example.spring.jaxrs.api.service.FileResource;

/**
 * @author  dpersa
 */
@Configuration
public class RestClientConfig {

    /**
     * we create a rest service client.
     */
    @Bean
    public FileResource fortuneCookieService() {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());

        FileResource client = ProxyFactory.create(FileResource.class, "http://localhost:8080/api");
        return client;
    }
}
