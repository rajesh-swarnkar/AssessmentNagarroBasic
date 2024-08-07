package com.raj.account_service.service;

import com.raj.account_service.dto.Account;
import com.raj.account_service.repository.AccountManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.raj.account_service.util.AccountUtil.validateCustomer;

public class AccountManagementServiceImpl implements  AccountManagementService{

    @Autowired
    private AccountManagementRepository accountManagementRepository;

    @Override
    public Account addMoney(Account account) {
        //validate customer
        try{
            validateCustomer(account);
        }catch (Exception e){
            return null;
        }
        Optional<com.raj.account_service.entity.Account> dbData=accountManagementRepository.findById(account.getAccountId());
        com.raj.account_service.entity.Account account1=new com.raj.account_service.entity.Account();
        if(dbData.isPresent()){
            account1.setAccountId(dbData.get().getAccountId());
            account1.setCustomerId(dbData.get().getCustomerId());
            account1.setBalance(dbData.get().getBalance()+account.getBalance());
        }
        account.setBalance(account1.getBalance());
        accountManagementRepository.save(account1);
        return account;
    }

    @Override
    public Account withdrawMondy(Account account) {
        //validate customer
        try{
            validateCustomer(account);
        }catch (Exception e){
            return null;
        }
        Optional<com.raj.account_service.entity.Account> dbData=accountManagementRepository.findById(account.getAccountId());
        com.raj.account_service.entity.Account account1=new com.raj.account_service.entity.Account();
        if(dbData.isPresent()){
            account1.setAccountId(dbData.get().getAccountId());
            account1.setCustomerId(dbData.get().getCustomerId());
            account1.setBalance(dbData.get().getBalance()-account.getBalance());
        }
        account.setBalance(account1.getBalance());
        accountManagementRepository.save(account1);
        return account;
    }

    @Override
    public Account getAccountDetails(String accountId) {
        Optional<com.raj.account_service.entity.Account> dbData=accountManagementRepository.findById(accountId);
        Account account1=new Account();
        if(dbData.isPresent()){
            account1.setAccountId(dbData.get().getAccountId());
            account1.setCustomerId(dbData.get().getCustomerId());
            account1.setBalance(dbData.get().getBalance());
        }
        return account1;
    }

    @Override
    public void deleteAccount(String accountId) {


        Optional<com.raj.account_service.entity.Account> dbData=accountManagementRepository.findById(accountId);
        com.raj.account_service.entity.Account account1=new com.raj.account_service.entity.Account();
        if(dbData.isPresent()){
            account1.setAccountId(dbData.get().getAccountId());
            account1.setCustomerId(dbData.get().getCustomerId());
            account1.setBalance(dbData.get().getBalance());
        }
        accountManagementRepository.delete(account1);

    }
}
