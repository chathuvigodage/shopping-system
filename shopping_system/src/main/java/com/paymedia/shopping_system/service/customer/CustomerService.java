package com.paymedia.shopping_system.service.customer;

import com.paymedia.shopping_system.entity.Customer;
import com.paymedia.shopping_system.repository.customer.CustomerRepository;
import com.paymedia.shopping_system.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

@Service
public class CustomerService extends GenericCrudServiceImpl<Customer, Long> {

    public CustomerService(CustomerRepository repository, EntityManager entityManager) {
        super(repository, entityManager,Customer.class);
    }
}

