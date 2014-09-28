package com.danix.example.spring.jaxrs.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

import javax.ws.rs.core.Response;

/**
 * @author  dpersa
 */
public class FileNotFoundException extends ApiException {

    private final Integer id;

    protected FileNotFoundException(@Nonnull final Integer id) {
        super(Response.Status.NOT_FOUND);
        this.id = checkNotNull(id);
    }

    public static FileNotFoundException from(@Nonnull final Integer id) {
        return new FileNotFoundException(id);
    }

    @Nonnull
    public Integer getId() {
        return id;
    }
}
