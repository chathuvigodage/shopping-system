package com.paymedia.shopping_system.controller.customer;

import com.paymedia.shopping_system.controller.CrudController;
import com.paymedia.shopping_system.entity.Customer;
import com.paymedia.shopping_system.service.customer.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends CrudController<Customer, Long> {

    public CustomerController(CustomerService service) {
        super(service);
    }
}

