package org.acme.service;

import java.util.UUID;

import org.acme.dto.TokenDTO;
import org.acme.model.Token;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;

@ApplicationScoped
public class TokenService {

    @Inject
    @RestClient
    CelcoinRemoteService celcoinRemoteService;

    public TokenDTO getToken() {
        var form = new Form();
        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        return celcoinRemoteService.getToken(form);
    }

    public void save(TokenDTO record) {
        var token = new Token();
        token.setId(UUID.randomUUID());
        token.setToken(record.accessToken());
        token.persist();
    }
}
