/**
 * This file is provided without any copyright claims. It is intended for free use, modification,
 * and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 */

package com.shiju.customer_service.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.shiju.customer_service.entity.Customer;
import com.shiju.customer_service.models.CustomerCreationRequest;
import com.shiju.customer_service.models.CustomerResponse;
import org.springframework.beans.BeanUtils;

public class CustomerHelper {

  public static Customer transformCustomerRequestToCustomerEntity(CustomerCreationRequest customerCreationRequest){
    Customer customer = new Customer();
    BeanUtils.copyProperties(customerCreationRequest, customer);
    return customer;
  }

  public static CustomerResponse transformCustomerRequestToCustomerEntity(Customer customer){
    return new CustomerResponse(customer.getFirstName(),
        customer.getLastName(), customer.getEmail(), customer.getPhoneNumber());
  }

}
