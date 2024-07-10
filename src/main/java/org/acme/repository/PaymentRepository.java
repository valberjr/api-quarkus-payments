package org.acme.repository;

import java.util.List;
import java.util.UUID;

import org.acme.dto.PaymentRequestDTO;
import org.acme.model.Payment;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentRepository implements PanacheRepositoryBase<Payment, UUID> {

    public Payment persistPayment(Payment payment) {
        persist(payment);
        return payment;
    }

    public List<Payment> listPayments() {
         return listAll();
    }

    public Payment findByPaymentId(String id) {
        return findById(UUID.fromString(id));
    }

    public Payment findByPaymentIdFromHeader(String id) {
        return find("id", UUID.fromString(id)).firstResult();
    }

    public Payment update(String id, PaymentRequestDTO dto) {
        Payment payment = findByPaymentId(id);
        payment.setReceipt(dto.getReceipt());
        getEntityManager().merge(payment);
        return payment;
    }

    public int updateFromHeaderParams(String id, String receipt) {
        return update("receipt = :receipt where id = :id",
                Parameters.with("id", UUID.fromString(id)).and("receipt", receipt));
    }

    public boolean deleteById(String id) {
        return deleteById(UUID.fromString(id));
    }

}
