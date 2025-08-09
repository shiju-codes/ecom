/**
 * This file is provided without any copyright claims.
 * It is intended for free use, modification, and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 *
 */

package com.shiju.customer_service.facade;

import com.shiju.customer_service.models.CustomerCreationRequest;
import com.shiju.customer_service.models.CustomerResponse;

public interface CustomerFacade {

    CustomerResponse createCustomer(CustomerCreationRequest request);
}
