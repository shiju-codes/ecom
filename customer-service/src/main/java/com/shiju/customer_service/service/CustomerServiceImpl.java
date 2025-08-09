/**
 * This file is provided without any copyright claims. It is intended for free use, modification,
 * and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 */

package com.shiju.customer_service.service;

import com.shiju.customer_service.entity.Customer;
import com.shiju.customer_service.models.CustomerCreationRequest;
import com.shiju.customer_service.models.CustomerResponse;
import com.shiju.customer_service.repository.CustomerRepository;
import com.shiju.customer_service.utils.CustomerHelper;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public CustomerResponse createCustomer(CustomerCreationRequest request) {
    Customer customer = customerRepository.save(CustomerHelper.transformCustomerRequestToCustomerEntity(request));
    return CustomerHelper.transformCustomerRequestToCustomerEntity(customer);
  }
}
