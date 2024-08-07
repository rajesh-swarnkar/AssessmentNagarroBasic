package com.raj.customer_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountClient {
  @DeleteMapping("/account/{id}")
  void deleteAccount(@PathVariable("id") String accountId);
}