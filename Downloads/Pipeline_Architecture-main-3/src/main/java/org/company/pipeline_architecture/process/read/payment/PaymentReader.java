package org.company.pipeline_architecture.process.read.payment;


import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class PaymentReader implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {
        // Implement payment reading logic here
        return message;
    }
}
