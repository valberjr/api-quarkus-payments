package org.acme.dto;

import java.math.BigDecimal;

public record RegisterDataDTO(
        String documentRecipient,
        String documentPayer,
        String payDueDate,
        String nextBusinessDay,
        String dueDateRegister,
        boolean allowChangeValue,
        String recipient,
        String payer,
        BigDecimal discountValue,
        BigDecimal interestValueCalculated,
        BigDecimal maxValue,
        BigDecimal minValue,
        BigDecimal fineValueCalculated,
        BigDecimal originalValue,
        BigDecimal totalUpdated,
        BigDecimal totalWithDiscount,
        BigDecimal totalWithAdditional) {
}
