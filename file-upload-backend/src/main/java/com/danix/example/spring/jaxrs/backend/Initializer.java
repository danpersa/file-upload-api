package com.danix.example.spring.jaxrs.backend;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.concurrent.TimeUnit;

/**
 * @author dpersa
 */
@Configuration
@ComponentScan(basePackages = "com.danix.example.spring.jaxrs.backend.service")
public class Initializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();

        servletContext.setInitParameter("spring.profiles.default", "development");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServletRest",
                dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9000);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        //factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html"));
        return factory;
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.danix.example.spring.jaxrs.backend.config");
        return context;
    }
}
