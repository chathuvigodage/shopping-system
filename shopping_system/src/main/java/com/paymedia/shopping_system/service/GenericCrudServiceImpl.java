package com.paymedia.shopping_system.service;

import com.paymedia.shopping_system.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.Optional;

public class GenericCrudServiceImpl<T, ID> implements CrudService<T, ID> {

    private final GenericRepository<T, ID> repository;
    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public GenericCrudServiceImpl(GenericRepository<T, ID> repository, EntityManager entityManager, Class<T> domainClass) {
        this.repository = repository;
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
        repository.deleteById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<T> searchByField(String fieldName, String value, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(domainClass);  // Use the domainClass field
        Root<T> root = query.from(domainClass);  // Use the domainClass field

        Predicate predicate = cb.like(root.get(fieldName), "%" + value + "%");
        query.where(predicate);

        Specification<T> specification = (root1, query1, criteriaBuilder) -> predicate;
        return repository.findAll(specification, pageable);  // Use the Specification with Pageable
    }
}

