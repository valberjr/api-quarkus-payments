package org.acme;

import org.acme.dto.BankSlipDTO;
import org.acme.dto.PaymentRequestDTO;
import org.acme.service.PaymentService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class PaymentResource {

    @Inject
    PaymentService service;

    @POST
    @Path("/check-bank-slip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consult(BankSlipDTO dto) {
        return Response.ok(service.check(dto)).build();
    }

    @POST
    @Path("/payments")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response payment(BankSlipDTO dto) {
        return Response.ok().entity(service.payment(dto)).build();
    }

    @GET
    @Path("/payments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payments() {
        return Response.ok().entity(service.payments()).build();
    }

    @GET
    @Path("/payments/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") String id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @GET
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdFromHeader(@HeaderParam("id") String id) {
        return Response.ok().entity(service.findByIdFromHeader(id)).build();
    }

    @PATCH
    @Path("/payments/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") String id, PaymentRequestDTO dto) {
        return Response.ok().entity(service.update(id, dto)).build();
    }

    @PATCH
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateWithHeaderParam(@HeaderParam("id") String id, @HeaderParam("receipt") String receipt) {
        return Response.ok().entity(service.updateFromHeaderParams(id, receipt)).build();
    }

    @DELETE
    @Path("/payments/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteById(@PathParam("id") String id) {
        return Response.ok().entity(service.deleteById(id)).build();
    }

}
