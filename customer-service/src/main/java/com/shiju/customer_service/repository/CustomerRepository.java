/**
 * This file is provided without any copyright claims. It is intended for free use, modification,
 * and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 */

package com.shiju.customer_service.repository;

import com.shiju.customer_service.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
