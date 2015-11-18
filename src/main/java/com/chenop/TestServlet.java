package com.chenop;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Chen.Oppenhaim on 10/20/2015.
 */
@Path("api")
public class TestServlet {

    @GET
    @Produces("application/json")
    @Path("track")
    public Track getTrack() {
        return new Track("Living for Love", "Madonna");
    }
}
