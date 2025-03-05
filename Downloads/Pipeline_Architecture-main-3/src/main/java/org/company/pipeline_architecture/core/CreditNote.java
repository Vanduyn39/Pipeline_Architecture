package org.company.pipeline_architecture.core;

public class CreditNote {
    private long creditNoteId;
    private String note;
    private boolean isCancellation;
    private String creditId;
    private double availableCredit;

    public long getCreditNoteId() { return creditNoteId; }
    public void setCreditNoteId(long creditNoteId) { this.creditNoteId = creditNoteId; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public boolean isCancellation() { return isCancellation; }
    public void setCancellation(boolean cancellation) { isCancellation = cancellation; }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String toString() {
        return "CreditNote{" +
                "creditNoteId=" + creditNoteId +
                ", note='" + note + "'" +
                ", isCancellation=" + isCancellation +
                '}';
    }

    public String toJson() {
        return "{ \"creditNoteId\": " + creditNoteId +
                ", \"note\": \"" + note + "\"" +
                ", \"isCancellation\": " + isCancellation +
                " }";
    }
}
