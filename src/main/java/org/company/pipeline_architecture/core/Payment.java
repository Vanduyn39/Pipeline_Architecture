package org.company.pipeline_architecture.core;

public class Payment {
    private long paymentId;
    private long custId;
    private String cardNumber;
    private String cvv;
    private double amount;

    public long getPaymentId() { return paymentId; }
    public void setPaymentId(long paymentId) { this.paymentId = paymentId; }

    public long getCustId() { return custId; }
    public void setCustId(long custId) { this.custId = custId; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", custId=" + custId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }

    public String toJson() {
        return "{ \"paymentId\": " + paymentId +
                ", \"custId\": " + custId +
                ", \"cardNumber\": \"" + cardNumber + "\"" +
                ", \"cvv\": \"" + cvv + "\"" +
                " }";
    }

}
