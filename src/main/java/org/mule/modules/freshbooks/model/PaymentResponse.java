package org.mule.modules.freshbooks.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class PaymentResponse extends BaseResponse {
    @XmlElement(name = "payment_id", nillable=true)
    private String paymentId;
    @XmlElement(name = "payment", required = false)
    private Payment payment;
    @XmlElement(name = "payments", required = false)
    private Payments payments;

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
