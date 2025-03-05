package org.company.pipeline_architecture.core.entities;

public interface IFilter <T> {
    T execute(T message);
}
