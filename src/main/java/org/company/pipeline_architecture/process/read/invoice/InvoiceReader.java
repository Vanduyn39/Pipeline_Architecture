package org.company.pipeline_architecture.process.read.invoice;


import org.company.pipeline_architecture.services.DatabaseService;
import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;
import org.json.JSONArray;
import org.json.JSONObject;

public class InvoiceReader implements IFilter<IMessage> {



    private boolean checkInventory(JSONObject orderInfo){

        JSONArray orders = orderInfo.getJSONArray("orders");
        for (int i = 0; i < orders.length(); i++) {
            JSONObject order = orders.getJSONObject(i);
            int productId = order.getInt("productId");
            int quantity = order.getInt("quantity");

            boolean check = DatabaseService.checkInventory(productId, quantity);
            if (!check) {
                return false;
            }
        }
        return true;
    }

    @Override
    public IMessage execute(IMessage message) {
        // Implement invoice reading logic here

        JSONObject jsonObject = new JSONObject(message.getFileContent());

        // Truy xuất thông tin về đơn hàng
        JSONObject orderInfo = jsonObject.getJSONObject("order_info");

        // Kiểm tra đủ tồn
        boolean check = checkInventory(orderInfo);
        System.out.println("Kiểm tra hàng đủ cung ứng : " + check);


//        // Truy xuất thông tin giao hàng
//        JSONObject delivery = orderInfo.getJSONObject("delivery");
//        int nodeId = delivery.getInt("nodeId");
//        String note = delivery.getString("note");
//        String deliveryAddress = delivery.getString("deliveryAdd");
//        boolean isDelivery = delivery.getBoolean("isDelivery");
//
//        System.out.println("Delivery Node ID: " + nodeId);
//        System.out.println("Note: " + note);
//        System.out.println("Delivery Address: " + deliveryAddress);
//        System.out.println("Is Delivery: " + isDelivery);
//
//        // Truy xuất thông tin thanh toán
//        JSONObject payments = orderInfo.getJSONObject("payments");
//        int paymentId = payments.getInt("paymentId");
//        String cardNumber = payments.getString("cardNumber");
//        String cvv = payments.getString("cvv");
//
//        System.out.println("Payment ID: " + paymentId);
//        System.out.println("Card Number: " + cardNumber);
//        System.out.println("CVV: " + cvv);
        return message;
    }
}

