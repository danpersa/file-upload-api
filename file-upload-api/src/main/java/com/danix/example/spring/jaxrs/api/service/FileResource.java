package com.danix.example.spring.jaxrs.api.service;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.danix.example.spring.jaxrs.api.domain.FileIn;
import com.danix.example.spring.jaxrs.api.domain.FileOut;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import java.io.IOException;

/**
 * @author dpersa
 */
@Path("files")
@Produces(MediaType.APPLICATION_JSON)
public interface FileResource {

    @GET
    @Path("/{id}")
    @Nonnull
    FileOut getFileById(@NotNull
                        @PathParam("id")
                        final Integer id);

    @GET
    @Path("/{id}/download")
    @Produces("multipart/form-data")
    @Nonnull
    MultipartFormDataOutput downloadFileById(@NotNull
                                             @PathParam("id")
                                             final Integer id);

    @POST
    @Path("/")
    @Consumes("multipart/form-data")
    @Nonnull
    FileOut create(@Valid @MultipartForm final FileIn fileIn);

    @GET
    @Path("/")
    String test();
}
