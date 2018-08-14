package com.chenop.api;

import com.chenop.DocAnalyzer;
import com.chenop.ParserManager;
import com.chenop.models.CVData;
import com.chenop.models.CaseInsensitiveList;
import org.apache.commons.codec.binary.Base64;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Chen.Oppenhaim on 11/18/2015.
 */
@Path("/")
public class DocParserController {

    /**
     * Upload a File
     */

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(@FormDataParam("file") InputStream fileInputStream,
						   @FormDataParam("file") FormDataContentDisposition fileMetaData)
    {
        try {
            String text = ParserManager.parse(fileInputStream);
            if (isBase64(text))
                text = decodeBase64ToText(text);
            CVData cvData = DocAnalyzer.extractCVData(text);

            return Response.ok(cvData).build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }


	@GET
	@Path("/wakeup")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String wakeup() {
		return "I'm awake";
	}

    @GET
    @Path("/keywords")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response keywords() {
        try {
            CaseInsensitiveList keywords = DocAnalyzer.getKeywords();

            return Response.ok(keywords).build();
        }
        catch (SQLException e) {
            return Response.serverError().build();
        }
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
