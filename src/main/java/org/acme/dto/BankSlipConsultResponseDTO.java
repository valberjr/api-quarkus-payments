package org.acme.dto;

import java.math.BigDecimal;

public record BankSlipConsultResponseDTO(
        String assignor,
        RegisterDataDTO registerData,
        String settleDate,
        String dueDate,
        String endHour,
        String initeHour,
        String nextSettle,
        String digitable,
        String transactionId,
        String type,
        BigDecimal value,
        BigDecimal maxValue,
        BigDecimal minValue,
        String errorCode,
        String message,
        String status) {
}
