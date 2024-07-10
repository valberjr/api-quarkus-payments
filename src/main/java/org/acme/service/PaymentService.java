package org.acme.service;

import java.util.List;
import java.util.UUID;

import org.acme.dto.BankSlipConsultResponseDTO;
import org.acme.dto.BankSlipDTO;
import org.acme.dto.PaymentRequestDTO;
import org.acme.dto.PaymentResponseDTO;
import org.acme.model.Payment;
import org.acme.repository.PaymentRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PaymentService {

    @Inject
    @RestClient
    CelcoinRemoteService celcoinService;

    @Inject
    PaymentRepository repository;

    @Inject
    TokenService tokenService;

    public BankSlipConsultResponseDTO check(BankSlipDTO dto) {
        return celcoinService.check(String.format("Bearer %s", tokenService.getToken().accessToken()), dto);
    }

    public PaymentResponseDTO payment(BankSlipDTO dto) {
        var response = celcoinService.payment(String.format("Bearer %s", tokenService.getToken().accessToken()), dto);

        var payment = new Payment();
        payment.setId(UUID.randomUUID());
        payment.setAmount(dto.bill().value());
        payment.setDigitable(dto.data().digitable());
        payment.setReceipt(response.getReceipt().getReceiptformatted());

        repository.persistPayment(payment);

        return response;
    }

    public List<Payment> payments() {
        return repository.listPayments();
    }

    public Payment findById(String id) {
        return repository.findByPaymentId(id);
    }

    public Payment findByIdFromHeader(String id) {
        return repository.findByPaymentIdFromHeader(id);
    }

    public Payment update(String id, PaymentRequestDTO dto) {
        return repository.update(id, dto);
    }

    public int updateFromHeaderParams(String id, String receipt) {
        return repository.updateFromHeaderParams(id, receipt);
    }

    public boolean deleteById(String id) {
        return repository.deleteById(id);
    }

}
