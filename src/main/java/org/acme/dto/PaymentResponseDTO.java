package org.acme.dto;

import java.math.BigDecimal;

public class PaymentResponseDTO {

    private String convenant;
    private boolean isExpired;
    private BigDecimal authentication;
    private PaymentAuthDTO authenticationAPI;
    private ReceiptDTO receipt;
    private String settleDate;
    private String createDate;
    private Integer transactionId;
    private String Urlreceipt;
    private String errorCode;
    private String message;
    private Integer status;

    public String getConvenant() {
        return convenant;
    }

    public void setConvenant(String convenant) {
        this.convenant = convenant;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public BigDecimal getAuthentication() {
        return authentication;
    }

    public void setAuthentication(BigDecimal authentication) {
        this.authentication = authentication;
    }

    public PaymentAuthDTO getAuthenticationAPI() {
        return authenticationAPI;
    }

    public void setAuthenticationAPI(PaymentAuthDTO authenticationAPI) {
        this.authenticationAPI = authenticationAPI;
    }

    public ReceiptDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getUrlreceipt() {
        return Urlreceipt;
    }

    public void setUrlreceipt(String urlreceipt) {
        Urlreceipt = urlreceipt;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
