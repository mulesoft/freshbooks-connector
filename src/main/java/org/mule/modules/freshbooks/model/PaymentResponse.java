package org.mule.modules.freshbooks.model;

public class PaymentResponse extends BaseResponse {
    private String paymentId;
    private Payment payment;
    private Payments payments;

    public PaymentResponse(Response response) {
        initBaseResponseFields(response);
        paymentId = response.getPaymentId();
        payment = response.getPayment();
        payments = response.getPayments();
    }
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

}
