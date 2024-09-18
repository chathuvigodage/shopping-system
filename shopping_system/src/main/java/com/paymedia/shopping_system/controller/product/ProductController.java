package com.paymedia.shopping_system.controller.product;

import com.paymedia.shopping_system.controller.CrudController;
import com.paymedia.shopping_system.entity.Product;
import com.paymedia.shopping_system.service.product.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Product, Long> {

    public ProductController(ProductService service) {
        super(service);
    }
}

