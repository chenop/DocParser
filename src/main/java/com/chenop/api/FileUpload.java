package com.chenop.api;

import com.chenop.KeywordsAnalyzer;
import com.chenop.ParserManager;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

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
    public Response uploadPdfFile(  @FormDataParam("file") InputStream fileInputStream,
                                    @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
    {
        String text = ParserManager.parse(fileInputStream);
        List<String> keywords = KeywordsAnalyzer.extractKeywords(text);

        return Response.ok(keywords).build();
    }
}
