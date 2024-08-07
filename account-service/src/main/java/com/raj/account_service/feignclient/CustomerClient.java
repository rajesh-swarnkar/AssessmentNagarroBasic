package com.raj.account_service.feignclient;

import com.raj.account_service.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerClient {
  @GetMapping("/customer/{id}")
  Customer getCustomer(@PathVariable("id") String userId);
}