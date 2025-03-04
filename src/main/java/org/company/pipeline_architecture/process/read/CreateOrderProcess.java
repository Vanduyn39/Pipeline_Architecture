package org.company.pipeline_architecture.process.read;

import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class CreateOrderProcess implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {
        // Cập nhật data xuống DB
        return null;
    }
}
