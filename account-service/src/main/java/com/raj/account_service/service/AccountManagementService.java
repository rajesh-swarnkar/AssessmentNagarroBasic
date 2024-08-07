package com.raj.account_service.service;

import com.raj.account_service.dto.Account;

public interface AccountManagementService {
    public Account addMoney(Account account);
    public Account withdrawMondy(Account account);
    public Account getAccountDetails(String accountId);
    public void deleteAccount(String accountId);
}
