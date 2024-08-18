package com.raj.account_service.util;

import com.raj.account_service.dto.Account;
import com.raj.account_service.dto.Customer;
import com.raj.account_service.feignclient.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountUtil {

    @Autowired
    private static CustomerClient customerClient;

    public static boolean validateCustomer(Account account){

        //talk to customer service to fetch customer detail ... here we can use feign client or other way to communicate....

        if(account.getCustomerId()!=null && account.getAccountId()!=null){
            Customer customer= customerClient.getCustomer(account.getCustomerId());
            if(customer.getId().equals(account.getCustomerId()))
                return true;
        }
        throw new RuntimeException("Invalid customer or account id !!");
    }
}
