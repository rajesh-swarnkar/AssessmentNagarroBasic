package com.raj.customer_service.service;

import com.netflix.discovery.converters.Auto;
import com.raj.customer_service.dto.Account;
import com.raj.customer_service.feignClient.AccountClient;
import com.raj.customer_service.repository.CustomerRepository;
import com.raj.customer_service.dto.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Customer addCustomer(Customer customer) {

        if(customer.getId()!=null)
            return new Customer();
        com.raj.customer_service.entity.Customer entity=new com.raj.customer_service.entity.Customer();
        modelMapper.map(customer,entity);
//        entity.setId(customer.getId());
//        entity.setName(customer.getName());
//        entity.setAccountNumber(customer.getAccountNumber());
        entity=customerRepository.save(entity);
        Account account=new Account();
        account.setBalance(0D);
        account.setCustomerId(entity.getId());
        Account result = accountClient.addAccount(account);
        entity.setAccountNumber(result.getAccountId());
        entity=customerRepository.save(entity);

        customer.setId(entity.getId());
        customer.setAccountNumber(entity.getAccountNumber());

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
    public Customer getCustomer(Long  id) {
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
    public int deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        try{
            accountClient.deleteAccount(customerRepository.findById(id).get().getAccountNumber());
        }catch (Exception e){
            return 0;
        }
        return 1;
    }
}
