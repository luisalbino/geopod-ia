package com.application.parser;

import com.application.entities.AbstractEntity;
import com.application.services.AbstractService;

public abstract class AbstractParser<T extends AbstractEntity, S extends AbstractService<T, ?>> {

    protected final S service;

    public AbstractParser(S service) {
        this.service = service;
    }

    public abstract void parse(T scriptEntity);

}
