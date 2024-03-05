package com.application.services;

import com.application.entities.AbstractEntity;
import com.application.repositories.AbstractRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractService<E extends AbstractEntity, T extends AbstractRepository<E>> {

    protected final T repository;

    protected AbstractService(T repository) {
        this.repository = repository;
    }

    public Collection<E> getAll() {
        return new ArrayList<>(this.repository.findAll());
    }

    public void save(E data) {
        this.save(Collections.singletonList(data));
    }

    public void save(Collection<E> data) {
        this.repository.saveAll(data);
    }

    public void remove(E data) {
        remove(Collections.singletonList(data));
    }

    public void remove(Collection<E> data) {
        this.repository.deleteAll(data);
    }
}
