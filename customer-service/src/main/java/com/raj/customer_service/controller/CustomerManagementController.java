package com.raj.customer_service.controller;

import com.raj.customer_service.dto.Customer;
import com.raj.customer_service.service.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerManagementController {

    @Autowired
    private CustomerManagementService customerManagementService;

    @PostMapping(value = "/addCustomer")
    public void addCustomer(@RequestBody Customer customer){

        customerManagementService.addCustomer(customer);


    }

    @GetMapping(value = "/allCustomer")
    public List<Customer> getAllCustomer(){
        return customerManagementService.getAllCustomer();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerManagementService.getCustomer(id);
    }

    @PutMapping( value = "/updateCustomer" )
    public Customer updateCustomer(@RequestBody Customer  customer){
        return customerManagementService.updateCustomerDetails(customer);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id){
        try {
            customerManagementService.deleteCustomer(id);
        }catch (Exception e){
            return "Please try later!";
        }

        return "Deleted successfully!!";
    }

}
