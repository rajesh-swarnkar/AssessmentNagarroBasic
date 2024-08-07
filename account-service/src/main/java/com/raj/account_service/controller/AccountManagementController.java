package com.raj.account_service.controller;

import com.raj.account_service.dto.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountManagementController {

    @PutMapping(value = "/addmoney")
    public Account addMoney(@RequestBody Account account){
        return  null;
    }

    @PutMapping(value = "/wihtdraw")
    public Account withdrawMoney(@RequestBody Account account){
        return  null;
    }

    @GetMapping(value = "/accountDetails/{id}")
    public Account getAccountDetails(@PathVariable String id){
        return  null;
    }

    @DeleteMapping(value ="/delete/{id}" )
    public String  deleteAccountDeatils(@PathVariable String id){
        try{

        }catch (Exception e){
            return "Please try agian later!";
        }

        return "Account deleted sucessfully!";
    }
}
