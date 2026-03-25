package org.example;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(
            @FormParam("username") String username,
            @FormParam("password") String password) {

        try {
            authenticate(username, password);
            String token = issueToken(username);

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username,
                              String password) throws Exception {
        throw new Exception();
    }

    private String issueToken(String username) {
        return username.toUpperCase() + UUID.randomUUID();
    }

}
