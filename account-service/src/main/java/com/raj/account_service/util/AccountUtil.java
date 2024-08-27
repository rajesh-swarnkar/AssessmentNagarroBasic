package com.raj.account_service.util;

import com.raj.account_service.dto.Account;
import com.raj.account_service.dto.Customer;
import com.raj.account_service.feignclient.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountUtil {

    @Autowired
    private  CustomerClient customerClient;

    public boolean validateCustomer(Account account){

        //talk to customer service to fetch customer detail ... here we can use feign client or other way to communicate....

        if(account.getCustomerId()!=null && account.getAccountId()!=null){
            Customer customer= customerClient.getCustomer(account.getCustomerId());
            if(Objects.equals(customer.getId(), account.getCustomerId()) && Objects.equals(customer.getAccountNumber(),account.getAccountId()))
                return true;
        }
        throw new RuntimeException("Invalid customer or account id !!");
    }
}
