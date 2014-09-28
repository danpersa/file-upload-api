package com.danix.example.spring.jaxrs.backend.service;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import com.danix.example.spring.jaxrs.api.domain.FileIn;
import com.danix.example.spring.jaxrs.api.domain.FileOut;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.danix.example.spring.jaxrs.api.service.FileResource;

/**
 * @author dpersa
 */
public class FileInServiceAcceptanceTest {

    @BeforeClass
    public static void setupClass() {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
    }

    @Test
    public void testGetFileById() throws Exception {
        FileResource client = ProxyFactory.create(FileResource.class,
                "http://localhost:8081/backend/");
        FileOut file = client.getFileById(14);
        assertThat(file.getName(), is("upload.xml! " + 14));
    }

    @Test
    public void testCreate() throws Exception {
    }
}
