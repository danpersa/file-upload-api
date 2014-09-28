package com.danix.example.spring.jaxrs.backend.config;

import com.danix.example.spring.jaxrs.api.service.FileResource;
import com.danix.example.spring.jaxrs.backend.service.FileResourceImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.jboss.resteasy.spi.Registry;
import org.jboss.resteasy.spi.ResteasyDeployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.google.common.collect.ImmutableMap;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author dpersa
 */
@Configuration
@EnableAspectJAutoProxy
@ImportResource("classpath:springmvc-resteasy.xml")
public class ApplicationConfig {

    @Autowired
    private FileResource fileResource;

    @Autowired
    private Registry registry;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ResteasyDeployment resteasyDeployment() {
        registry.addSingletonResource(fileResource);

        ResteasyDeployment resteasyDeployment = new ResteasyDeployment();
        resteasyDeployment.setAsyncJobServiceEnabled(true);
        resteasyDeployment.setWiderRequestMatching(true);
        resteasyDeployment.setMediaTypeMappings(ImmutableMap.of("json", "application/json", "html", MediaType.TEXT_HTML));


        return resteasyDeployment;
    }



    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
