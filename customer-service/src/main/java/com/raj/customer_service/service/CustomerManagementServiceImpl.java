package com.raj.customer_service.service;

import com.raj.customer_service.CustomerRepository;
import com.raj.customer_service.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManagementServiceImpl implements CustomerManagementService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        com.raj.customer_service.entity.Customer entity=new com.raj.customer_service.entity.Customer();
        entity.setId(customer.getId());
        entity.setName(customer.getName());
        entity.setAccountNumber(customer.getAccountNumber());
        customerRepository.save(entity);
        return customer ;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<com.raj.customer_service.entity.Customer> customerList=customerRepository.findAll();
        List<Customer> result=new ArrayList<>();
        customerList.stream().forEach(cust->{
            Customer customer1=new Customer();
            customer1.setId( cust.getId());
            customer1.setName(cust.getName());
            customer1.setAccountNumber(cust.getAccountNumber());
            result.add(customer1);
        });

        return result;
    }

    @Override
    public Customer getCustomer(String  id) {
        Optional<com.raj.customer_service.entity.Customer> customer=customerRepository.findById(id);
        Customer result=new Customer();
        if(customer.isPresent()){
            result.setId(customer.get().getId());
            result.setName(customer.get().getName());
            result.setAccountNumber(customer.get().getAccountNumber());
        }
        return result;
    }

    @Override
    public Customer updateCustomerDetails(Customer customer) {
        com.raj.customer_service.entity.Customer entity=new com.raj.customer_service.entity.Customer();
        entity.setId(customer.getId());
        entity.setName(customer.getName());
        entity.setAccountNumber(customer.getAccountNumber());
        customerRepository.save(entity);
        return customer;
    }

    @Override
    public int deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return 1;
    }
}
