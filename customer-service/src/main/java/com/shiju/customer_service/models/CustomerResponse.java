/**
 * This file is provided without any copyright claims.
 * It is intended for free use, modification, and distribution.
 *
 * @author Shiju S
 * @version 0.0.1
 * @since 2025
 *
 */

package com.shiju.customer_service.models;

import lombok.Builder;

public record CustomerResponse(String firstName, String lastName, String email,
                               String phoneNumber) {

}
