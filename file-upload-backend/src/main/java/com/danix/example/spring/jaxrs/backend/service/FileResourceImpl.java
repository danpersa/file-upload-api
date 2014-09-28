package com.danix.example.spring.jaxrs.backend.service;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import javax.validation.Validator;

import com.danix.example.spring.jaxrs.api.domain.FileIn;
import com.danix.example.spring.jaxrs.api.domain.FileOut;
import com.danix.example.spring.jaxrs.api.exception.FileNotFoundException;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;

import com.danix.example.spring.jaxrs.api.service.FileResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author dpersa
 */
@Component
@Validated
public class FileResourceImpl implements FileResource {

    private static final int MISSING_FILE = 12;

    @PostConstruct
    public void init() {
        System.out.println("INIT");
    }

    @Override
    public FileIn getFileById(final Integer id) {
        if (id.equals(MISSING_FILE)) {
            throw FileNotFoundException.from(12);
        }

        final FileIn file = FileIn.from("upload.xml", "danix", new Date(), new Date(), new byte[]{});

        return file;
    }

    @Override
    public MultipartFormDataOutput downloadFileById(@Nonnull final Integer id) {
        return null;
    }

    @Nonnull
    @Override
    public FileOut create(@Nonnull final FileIn fileIn) {
        String fileName = "d:\\anything";


        try {
            writeFile(fileIn.getData(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final FileOut file = FileOut.from("upload.xml", "danix", new Date(), new Date());
        return file;

    }

    @Override
    public String test() {
        return "Hello World";
    }

    private void writeFile(byte[] content, @Nonnull String filename) throws IOException {

        final File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);
        fop.flush();
        fop.close();

    }
}
