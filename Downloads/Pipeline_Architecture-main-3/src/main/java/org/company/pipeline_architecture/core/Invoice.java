package org.company.pipeline_architecture.core;

public class Invoice {
    private long invoiceId;
    private long custId;
    private String description;
    private long productId;
    private long quantity;


    public long getInvoiceId() { return invoiceId; }
    public void setInvoiceId(long invoiceId) { this.invoiceId = invoiceId; }

    public long getCustId() { return custId; }
    public void setCustId(long custId) { this.custId = custId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public long getProductId() { return productId; }
    public void setProductId(long productId) { this.productId = productId; }

    public long getQuantity() { return quantity; }
    public void setQuantity(long quantity) { this.quantity = quantity; }

    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", custId=" + custId +
                ", description='" + description + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public String toJson() {
        return "{ \"invoiceId\": " + invoiceId +
                ", \"custId\": " + custId +
                ", \"description\": \"" + description + "\"" +
                ", \"productId\": " + productId +
                ", \"quantity\": " + quantity +
                " }";
    }

}
