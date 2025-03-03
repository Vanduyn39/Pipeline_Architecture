package org.company.pipeline_architecture.process.read.invoice;


import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class InvoiceReader implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {
        // Implement invoice reading logic here
        return message;
    }
}

