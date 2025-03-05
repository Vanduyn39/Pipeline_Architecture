package org.company.pipeline_architecture.process.read;

import org.company.pipeline_architecture.services.DatabaseService;
import org.company.pipeline_architecture.core.InvoiceInfo;
import org.company.pipeline_architecture.core.Note;
import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CheckDeliveryRatesProcess implements IFilter<IMessage> {

    Note deliveryNote = new Note();

    private boolean checkDeliveryStatus(int nodeId) {

        return DatabaseService.checkDeliveryStatus(nodeId);
    }
    private float getDeliveryRates(int nodeId){
        return 0;
    }

    @Override
    public IMessage execute(IMessage message) {
        JSONObject jsonObject = new JSONObject(message.getFileContent());
        // Truy xuất thông tin đơn hàng
        JSONObject orderInfo = jsonObject.getJSONObject("order_info");

        // Truy xuất thông tin giao hàng
        JSONObject delivery = orderInfo.getJSONObject("delivery");
        int nodeId = delivery.getInt("nodeId");
        String note = delivery.getString("note");
        String deliveryAddress = delivery.getString("deliveryAdd");
        boolean isDelivery = delivery.getBoolean("isDelivery");


        deliveryNote.setNodeId(nodeId);
        deliveryNote.setNote(note);
        deliveryNote.setDeliveryAdd(deliveryAddress);
        deliveryNote.setDelivery(isDelivery);

        boolean deliveryStatus = checkDeliveryStatus(nodeId);

        //Nếu chưa giao cập nhật cước phí, cập nhật thông tin giao hàng vào invoice nháp
        if(!deliveryStatus){

            InvoiceInfo invoiceInfo = message.getInvoiceInfo();
            List<Note> notes = new ArrayList<>();

            notes.add(deliveryNote);
            invoiceInfo.setNotes(notes);
            message.setInvoiceInfo(invoiceInfo);
        }

        return message;
    }
}
