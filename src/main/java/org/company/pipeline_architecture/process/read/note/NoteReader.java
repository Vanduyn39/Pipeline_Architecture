package org.company.pipeline_architecture.process.read.note;


import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

public class NoteReader implements IFilter<IMessage> {
    @Override
    public IMessage execute(IMessage message) {
        // Implement note reading logic here
        return message;
    }
}
