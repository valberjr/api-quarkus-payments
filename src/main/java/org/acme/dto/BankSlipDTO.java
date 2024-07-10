package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public record BankSlipDTO(

        @JsonbProperty("barCode")
        BankSlipDataDTO data,

        @JsonbProperty("billData")
        BankSlipDataDTO bill,

        Long transactionIdAuthorize,

        String cpfCnpj,

        String dueDate) {
}
