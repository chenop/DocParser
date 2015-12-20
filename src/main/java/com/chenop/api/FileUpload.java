package com.chenop.api;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

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
        XWPFDocument document = new XWPFDocument(fileInputStream);
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
        String text = wordExtractor.getText();
        System.out.println("result: " + text);

        return Response.ok("result: " + text).build();
    }
}
