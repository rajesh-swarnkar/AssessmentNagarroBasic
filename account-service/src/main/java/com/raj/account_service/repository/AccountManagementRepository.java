package com.raj.account_service.repository;

import com.raj.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountManagementRepository extends JpaRepository<Account, String> {

}
