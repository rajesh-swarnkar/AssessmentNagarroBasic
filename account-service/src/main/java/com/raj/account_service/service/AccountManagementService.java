package com.raj.account_service.service;

import com.raj.account_service.dto.Account;

public interface AccountManagementService {
    public Account addMoney(Account account);
    public Account withdrawMondy(Account account);
    public Account getAccountDetails(Long accountId);
    public void deleteAccount(Long accountId);

    public Account addAccount(Account account);
}
