package com.danix.example.spring.jaxrs.api.domain;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;

import static com.google.common.base.Preconditions.*;

/**
 * @author dpersa
 */
public class FileIn extends FileOut {

    @NotNull
    @FormParam("uploadedFile")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private final byte[] data;

    @Nonnull
    public static FileIn from(@Nonnull final String name, @Nonnull final String uploader,
                               @Nonnull final Date documentDate, @Nonnull final Date uploadDate, byte[] data) {
        return new FileIn(name, uploader, documentDate, uploadDate, data);
    }

    private FileIn(@Nonnull final String name, @Nonnull final String uploader,
                   @Nonnull final Date documentDate, @Nonnull final Date uploadDate, byte[] data) {
        super(name, uploader, documentDate, uploadDate);
        this.data = checkNotNull(data, "data should not be null");
    }

    @Nonnull
    public byte[] getData() {
        return data;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, uploader, documentDate, uploadDate, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FileIn other = (FileIn) obj;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.uploader, other.uploader)
                && Objects.equal(this.documentDate, other.documentDate)
                && Objects.equal(this.uploadDate, other.uploadDate)
                && Objects.equal(this.data, other.data);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("uploader", uploader)
                .add("documentDate", documentDate)
                .add("uploadDate", uploadDate)
                .add("data", data)
                .toString();
    }
}
