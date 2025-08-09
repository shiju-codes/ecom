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

import com.shiju.common.model.BaseRequest;
import java.util.regex.Pattern;

public record CustomerCreationRequest(
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String password,
    BaseRequest baseRequest
) {

  private static final Pattern EMAIL_PATTERN =
      Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

  private static final Pattern PHONE_PATTERN =
      Pattern.compile("^\\+?[0-9]{10,15}$");

  public CustomerCreationRequest {
    if (isNullOrBlank(firstName)) {
      throw new IllegalArgumentException("First name is required");
    }
    if (isNullOrBlank(lastName)) {
      throw new IllegalArgumentException("Last name is required");
    }
    if (isNullOrBlank(email) || !EMAIL_PATTERN.matcher(email).matches()) {
      throw new IllegalArgumentException("Invalid email format");
    }
    if (isNullOrBlank(phoneNumber) || !PHONE_PATTERN.matcher(phoneNumber).matches()) {
      throw new IllegalArgumentException("Invalid phone number format");
    }
    if (isNullOrBlank(password) || password.length() < 8){
      throw new IllegalArgumentException("Password should not be null or less than 8 characters");
    }
  }

  private static boolean isNullOrBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}