package org.company.pipeline_architecture.core;

public class Note {
    private long nodeId;
    private String note;
    private String deliveryAdd;
    private boolean isDelivery;

    public long getNodeId() { return nodeId; }
    public void setNodeId(long nodeId) { this.nodeId = nodeId; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getDeliveryAdd() { return deliveryAdd; }
    public void setDeliveryAdd(String deliveryAdd) { this.deliveryAdd = deliveryAdd; }

    public boolean isDelivery() { return isDelivery; }
    public void setDelivery(boolean delivery) { isDelivery = delivery; }

    public String toString() {
        return "Note{" +
                "nodeId=" + nodeId +
                ", note='" + note + "'" +
                ", deliveryAdd='" + deliveryAdd + "'" +
                ", isDelivery=" + isDelivery +
                '}';
    }

    public String toJson() {
        return "{ \"nodeId\": " + nodeId +
                ", \"note\": \"" + note + "\"" +
                ", \"deliveryAdd\": \"" + deliveryAdd + "\"" +
                ", \"isDelivery\": " + isDelivery +
                " }";
    }
}
