package org.company.pipeline_architecture.pipes;



import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;

import java.util.List;

public class Pipeline extends PipelineBase<IMessage> {
    public Pipeline(List<IFilter<IMessage>> filters) {
        for (IFilter<IMessage> filter : filters) {
            registerFilter(filter);
        }
    }
}
