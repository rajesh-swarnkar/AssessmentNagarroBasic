package com.raj.customer_service.feignClient;

import com.raj.customer_service.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service",url = "http://localhost:8081",path = "/account")
public interface AccountClient {
  @DeleteMapping("/delete/{id}")
  public void deleteAccount(@PathVariable("id") Long accountId);

  @PostMapping("/addaccount")
  public Account addAccount(@RequestBody Account acccount);
}