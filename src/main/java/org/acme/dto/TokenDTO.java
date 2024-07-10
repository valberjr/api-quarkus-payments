package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public record TokenDTO(@JsonbProperty("access_token") String accessToken) {
}
