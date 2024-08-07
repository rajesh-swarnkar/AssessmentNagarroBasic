package com.raj.customer_service.service;

import com.raj.customer_service.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerManagementService {

    public Customer addCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public Customer getCustomer(String  id);
    public Customer updateCustomerDetails(Customer customer);
    public int deleteCustomer(String id);

}
