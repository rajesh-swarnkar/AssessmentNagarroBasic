package com.raj.account_service.feignclient;

import com.raj.account_service.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service",url = "http://localhost:8080" ,path = "")
public interface CustomerClient {
  @GetMapping("/customer/{id}")
  public Customer getCustomer(@PathVariable Long id);
}