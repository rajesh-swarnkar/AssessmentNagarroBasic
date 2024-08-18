package com.raj.customer_service.feignClient;

import com.raj.customer_service.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "account-service",url = "http://localhost:8081",path = "")
public interface AccountClient {
  @DeleteMapping("/account/{id}")
  public void deleteAccount(@PathVariable("id") Long accountId);

  @PostMapping("/account/addaccount")
  public Account addAccount(Account acccount);
}