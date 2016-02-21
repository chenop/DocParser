package com.chenop.api;

import com.chenop.DocAnalyzer;
import com.chenop.ParserManager;
import com.chenop.models.CVData;
import org.apache.commons.codec.binary.Base64;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chen.Oppenhaim on 11/18/2015.
 */
@Path("files")
public class FileUpload {

    /**
     * Upload a File
     */

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@FormDataParam("file") InputStream fileInputStream,
                               @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
    {
        String text = ParserManager.parse(fileInputStream);
        if (isBase64(text))
            text = decodeBase64ToText(text);
        CVData cvData = DocAnalyzer.extractCVData(text);

        return Response.ok(cvData).build();
    }

    private boolean isBase64(String text) {
        if (!text.contains(","))
            return false;
        String base64String = text.split(",")[1]; // remove the first part of the string
        return Base64.isBase64(base64String);
    }

    private String decodeBase64ToText(String text) throws IOException {
        byte[] bytes = Base64.decodeBase64(text.split(",")[1]);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        return ParserManager.parse(inputStream);
    }
}
