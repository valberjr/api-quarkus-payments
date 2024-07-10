package org.acme.service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.BankSlipConsultResponseDTO;
import org.acme.dto.BankSlipDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.dto.TokenDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://sandbox.openfinance.celcoin.dev")
public interface CelcoinRemoteService {

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    TokenDTO getToken(Form form);

    @POST
    @Path("/v5/transactions/billpayments/authorize")
    BankSlipConsultResponseDTO check(@HeaderParam("Authorization") String token, BankSlipDTO dto);

    @POST
    @Path("/v5/transactions/billpayments")
    PaymentResponseDTO payment(@HeaderParam("Authorization") String token, BankSlipDTO dto);
}
