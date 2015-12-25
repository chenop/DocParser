package com.chenop.api;

import com.chenop.DocAnalyzer;
import com.chenop.ParserManager;
import com.chenop.models.CVData;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        CVData cvData = DocAnalyzer.extractCVData(text);

        return Response.ok(cvData).build();
    }
}
