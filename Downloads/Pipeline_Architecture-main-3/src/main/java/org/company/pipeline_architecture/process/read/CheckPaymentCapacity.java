package org.company.pipeline_architecture.process.read;

import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class CheckPaymentCapacity implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {

        //Test thông tin hoá đơn nháp
        System.out.println("[Test view draft invoice info] " + message.getInvoiceInfo().toString());

        return message;
    }
}
