package org.company.pipeline_architecture.core;
import java.util.List;

public class InvoiceInfo {
    private List<Invoice> invoices;
    private List<Payment> payments;
    private List<CreditNote> creditNotes;
    private List<Note> notes;

    public List<Invoice> getInvoices() { return invoices; }
    public void setInvoices(List<Invoice> invoices) { this.invoices = invoices; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }

    public List<CreditNote> getCreditNotes() { return creditNotes; }
    public void setCreditNotes(List<CreditNote> creditNotes) { this.creditNotes = creditNotes; }

    public List<Note> getNotes() { return notes; }
    public void setNotes(List<Note> notes) { this.notes = notes; }

    public String toString() {
        return "\nInvoiceInfo{" +
                "\ninvoices=" + invoices +
                ", \npayments=" + payments +
                ", \ncreditNotes=" + creditNotes +
                ", \nnotes=" + notes +
                '}';
    }

    public String toJson() {
        return "{ \"invoices\": " + invoices +
                ", \"payments\": " + payments +
                ", \"creditNotes\": " + creditNotes +
                ", \"notes\": " + notes +
                " }";
    }
}
