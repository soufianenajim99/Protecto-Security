package org.assurance.assuranceapp.repository.repositoryInterfaces;

import java.util.List;
import java.util.UUID;

public interface GenericRepository<T> {
    T save(T entity);
    T findById(UUID id);
    List<T> findAll();
    void deleteById(UUID id);
}
