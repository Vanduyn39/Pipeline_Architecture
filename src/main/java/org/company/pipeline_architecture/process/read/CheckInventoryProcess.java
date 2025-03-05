package org.company.pipeline_architecture.process.read;

import org.company.pipeline_architecture.services.DatabaseService;
import org.company.pipeline_architecture.core.Invoice;
import org.company.pipeline_architecture.core.InvoiceInfo;
import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CheckInventoryProcess implements IFilter<IMessage> {

    InvoiceInfo invoiceInfo = new InvoiceInfo();
    List<Invoice> invoices = new ArrayList<Invoice>();

    private boolean checkInventory(JSONObject orderInfo){

        JSONArray orders = orderInfo.getJSONArray("orders");
        for (int i = 0; i < orders.length(); i++) {
            JSONObject order = orders.getJSONObject(i);
            int productId = order.getInt("productId");
            int quantity = order.getInt("quantity");
            int custId = order.getInt("custId");
            int orderId = order.getInt("orderId");
            String description = order.getString("description");

            //Thêm sp vào hoá đơn nháp
            Invoice invoice = new Invoice();
            invoice.setProductId(productId);
            invoice.setQuantity(quantity);
            invoice.setCustId(custId);
            invoice.setInvoiceId(orderId);
            invoice.setDescription(description);
            invoices.add(invoice);

            boolean check = DatabaseService.checkInventory(productId, quantity);
            if (!check) {
                return false;
            }
        }
        return true;
    }

    @Override
    public IMessage execute(IMessage message) {

        JSONObject jsonObject = new JSONObject(message.getFileContent());

        System.out.println(jsonObject.toString());

        // Truy xuất thông tin về đơn hàng
        JSONObject orderInfo = jsonObject.getJSONObject("order_info");

        // Kiểm tra số tồn từ DB
        boolean check = checkInventory(orderInfo);

        //Nếu không đủ tồn, tạo logic dừng xử lý và thông báo
        if (!check) {
            throw new RuntimeException("Inventory not sufficent");
        }

        invoiceInfo.setInvoices(invoices);
        message.setInvoiceInfo(invoiceInfo);

        return message;
    }
}
