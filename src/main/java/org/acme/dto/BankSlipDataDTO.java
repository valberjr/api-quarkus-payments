package org.acme.dto;

import java.math.BigDecimal;

public record BankSlipDataDTO(String digitable, String barCode, BigDecimal value) {
}
