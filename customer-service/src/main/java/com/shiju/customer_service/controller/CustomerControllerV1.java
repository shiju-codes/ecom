/**
 * This file is provided without any copyright claims.
 * It is intended for free use, modification, and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 *
 */

package com.shiju.customer_service.controller;

import com.shiju.customer_service.facade.CustomerFacade;
import com.shiju.customer_service.models.CustomerCreationRequest;
import com.shiju.customer_service.models.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerControllerV1 {

  private final CustomerFacade customerFacade;

  public CustomerControllerV1(CustomerFacade customerFacade) {
    this.customerFacade = customerFacade;
  }

  @PostMapping("/create")
  public ResponseEntity<CustomerResponse> createCustomer(
      @RequestBody CustomerCreationRequest request) {
    log.info("2EA7BA6A-349E-4215-9ED6-64D854987FF0 - Request received for customer creation : {}", request);
    return ResponseEntity.ok(customerFacade.createCustomer(request));
  }
}
