package org.company.pipeline_architecture.pipes;


import org.company.pipeline_architecture.core.entities.IFilter;

import java.util.ArrayList;
import java.util.List;

public abstract class PipelineBase<T> {
    private final List<IFilter<T>> filters = new ArrayList<>();

    public PipelineBase()
    {

    }
    public void registerFilter(IFilter<T> filter) {
        filters.add(filter);
    }

    public T processFilters(T input) {
        for (IFilter<T> filter : filters) {
            input = filter.execute(input);
        }
        return input;
    }
}