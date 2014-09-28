package com.danix.example.spring.jaxrs.frontend.service;

import com.danix.example.spring.jaxrs.api.domain.FileIn;
import com.danix.example.spring.jaxrs.api.domain.FileOut;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.danix.example.spring.jaxrs.api.service.FileResource;

import java.util.Date;

/**
 * @author  dpersa
 */
@Service("indexService")
public class IndexService {

    /**
     * We inject the rest service into a regular service.
     */
    @Autowired
    FileResource fileResource;

    /**
     * This will make a GET to the backend service.
     */
    public FileOut getRandomFortuneCookie() {
        return fileResource.getFileById(11);
    }

    /**
     * This will make a POST to the backend service.
     */
    public FileOut createFile() {
        final FileIn file = FileIn.from("upload.xml", "danix", new Date(), new Date(), new byte[]{});
        return fileResource.create(file);
    }

}
