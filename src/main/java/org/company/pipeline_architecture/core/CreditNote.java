package org.company.pipeline_architecture.core;

public class CreditNote {
    private long creditNoteId;
    private String note;
    private boolean isCancellation;

    public long getCreditNoteId() { return creditNoteId; }
    public void setCreditNoteId(long creditNoteId) { this.creditNoteId = creditNoteId; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public boolean isCancellation() { return isCancellation; }
    public void setCancellation(boolean cancellation) { isCancellation = cancellation; }

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
