/**
 * This file is provided without any copyright claims. It is intended for free use, modification,
 * and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 */

package com.shiju.customer_service.facade;

import com.shiju.customer_service.models.CustomerCreationRequest;
import com.shiju.customer_service.models.CustomerResponse;
import com.shiju.customer_service.service.CustomerService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerFacadeImpl implements CustomerFacade {

  private final CustomerService customerService;

  private final Counter myCounter;

  public CustomerFacadeImpl(CustomerService customerService, MeterRegistry registry) {
    this.customerService = customerService;
    this.myCounter = Counter.builder("my.counter")
        .description("Counts something")
        .tags("region", "us-east")
        .register(registry);
  }

  @Override
  public CustomerResponse createCustomer(CustomerCreationRequest request) {
    //Audit incoming request
    CustomerResponse customerResponse = customerService.createCustomer(request);
    log.info("2EA7BA6A-349E-4215-9ED6-64D854987FF0 - Customer response : {}", customerResponse);
    //Audit outgoing request
    return customerResponse;
  }
}
