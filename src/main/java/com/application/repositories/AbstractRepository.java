package com.application.repositories;

import com.application.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
