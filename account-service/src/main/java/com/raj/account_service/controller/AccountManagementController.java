package com.raj.account_service.controller;

import com.raj.account_service.dto.Account;
import com.raj.account_service.service.AccountManagementService;
import feign.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/account")
@RefreshScope
//@ConfigurationPropertiesScan
//@ConfigurationProperties(prefix = "")
public class AccountManagementController {
    @Value("${msg: Hello World}")
    String msg;

    @Value("${withdrawMSG}")
    String withdrawMsg;

    private static final Logger log = LoggerFactory.getLogger(AccountManagementController.class);
    @Autowired
    private AccountManagementService accountManagementService;

    @PutMapping(value = "/addmoney")
    public Account addMoney(@RequestBody Account account){
        return  accountManagementService.addMoney(account);
    }

    @PutMapping(value = "/wihtdraw")
    public ResponseEntity<Object>  withdrawMoney(@RequestBody Account account){
        Account account1;
        Map<String ,Object> map=new HashMap<>();
        try{
            account1=  accountManagementService.withdrawMondy(account);
            map.put("data",account1);
            map.put("message",withdrawMsg);//withdraw successful!!
        }catch (Exception e){

            map.put("data",new Account());
            map.put("message","Invalid customer!!");
            return new ResponseEntity<Object>(map, HttpStatus.OK);

        }

        return new ResponseEntity<Object>(map,HttpStatus.OK);

    }

    @GetMapping(value = "/accountDetails/{id}")
    public Account getAccountDetails(@PathVariable Long id){

        log.info("msg from central repo: {}",msg);

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
    public Account addAccount(@RequestBody Account account){
        log.info("addAccount is called with following values: {}", account);
        return accountManagementService.addAccount(account);
    }
}
