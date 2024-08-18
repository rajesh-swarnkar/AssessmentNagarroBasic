package com.raj.account_service.controller;

import com.raj.account_service.dto.Account;
import com.raj.account_service.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountManagementController {

    @Autowired
    private AccountManagementService accountManagementService;

    @PutMapping(value = "/addmoney")
    public Account addMoney(@RequestBody Account account){
        return  accountManagementService.addMoney(account);
    }

    @PutMapping(value = "/wihtdraw")
    public Account withdrawMoney(@RequestBody Account account){
        return  accountManagementService.withdrawMondy(account);
    }

    @GetMapping(value = "/accountDetails/{id}")
    public Account getAccountDetails(@PathVariable Long id){
        return accountManagementService.getAccountDetails(id);
    }

    @DeleteMapping(value ="/delete/{id}" )
    public String  deleteAccountDeatils(@PathVariable Long id){
        try{
            accountManagementService.deleteAccount(id);

        }catch (Exception e){
            return "Please try agian later!";
        }

        return "Account deleted sucessfully!";
    }

    @PostMapping(value = "/addaccount")
    public Account addAccount(Account account){
       return accountManagementService.addAccount(account);
    }
}
