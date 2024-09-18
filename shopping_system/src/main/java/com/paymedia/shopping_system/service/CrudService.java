package com.paymedia.shopping_system.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    T update(ID id, T entity);
    void deleteById(ID id);
    Page<T> findAll(Pageable pageable);
    Page<T> searchByField(String fieldName, String value, Pageable pageable);
}

