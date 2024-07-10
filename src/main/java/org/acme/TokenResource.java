package org.acme;

import org.acme.service.TokenService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class TokenResource {

    @Inject
    TokenService service;

    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response hello() {
        var token = service.getToken();
        service.save(token);

        return Response.ok().entity(token).build();
    }

}
