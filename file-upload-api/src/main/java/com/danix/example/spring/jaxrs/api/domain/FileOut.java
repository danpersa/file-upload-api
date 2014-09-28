package com.danix.example.spring.jaxrs.api.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author dpersa
 */
public class FileOut {

    @NotBlank
    @FormParam("name")
    @PartType(MediaType.TEXT_PLAIN)
    protected final String name;

    @NotBlank
    @FormParam("uploader")
    @PartType(MediaType.TEXT_PLAIN)
    protected final String uploader;

    @NotBlank
    @FormParam("documentDate")
    @PartType(MediaType.TEXT_PLAIN)
    protected final Date documentDate;

    @NotBlank
    @FormParam("uploadDate")
    @PartType(MediaType.TEXT_PLAIN)
    protected final Date uploadDate;

    @Nonnull
    public static FileOut from(@Nonnull final String name, @Nonnull final String uploader,
                               @Nonnull final Date documentDate, @Nonnull final Date uploadDate) {
        return new FileOut(name, uploader, documentDate, uploadDate);
    }

    protected FileOut(@Nonnull final String name, @Nonnull final String uploader,
                      @Nonnull final Date documentDate, @Nonnull final Date uploadDate) {
        this.name = checkNotNull(name, "name should not be null");
        this.uploader = checkNotNull(uploader, "uploader should not be null");
        this.documentDate = checkNotNull(documentDate, "documentDate should not be null");
        this.uploadDate = checkNotNull(uploadDate, "uploadDate should not be null");
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String getUploader() {
        return uploader;
    }

    @Nonnull
    public Date getDocumentDate() {
        return documentDate;
    }

    @Nonnull
    public Date getUploadDate() {
        return uploadDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, uploader, documentDate, uploadDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FileOut other = (FileOut) obj;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.uploader, other.uploader)
                && Objects.equal(this.documentDate, other.documentDate)
                && Objects.equal(this.uploadDate, other.uploadDate);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("uploader", uploader)
                .add("documentDate", documentDate)
                .add("uploadDate", uploadDate)
                .toString();
    }
}
