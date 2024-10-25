package org.assurance.assuranceapp.service.serviceInterfaces;

import java.util.List;
import java.util.UUID;

public interface GenericServiceInterface<T> {
    T save(T entity);
    T findById(UUID id);
    List<T> findAll();
    void deleteById(UUID id);
}
