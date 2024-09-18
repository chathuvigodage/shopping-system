package com.paymedia.shopping_system.service.product;

import com.paymedia.shopping_system.entity.Product;
import com.paymedia.shopping_system.repository.product.ProductRepository;
import com.paymedia.shopping_system.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

@Service
public class ProductService extends GenericCrudServiceImpl<Product, Long> {

    public ProductService(ProductRepository repository, EntityManager entityManager) {
        super(repository, entityManager, Product.class);
    }
}

