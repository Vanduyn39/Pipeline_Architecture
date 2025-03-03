package org.company.pipeline_architecture.process.read.credit;


import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class CreditNoteReader implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {
        // Implement credit note reading logic here
        return message;
    }
}
