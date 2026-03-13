package com.amigoscode.order.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;


// TODO: 4 - Implement the ConstraintValidator for @ValidOrderStatus:
//  - Implement ConstraintValidator<ValidOrderStatus, String>
//  - Define a List of valid statuses: PENDING, SHIPPED, DELIVERED, CANCELLED
//  - In isValid(), return true if value is null (let @NotBlank handle null) or if value is in the list
public class OrderStatusValidator implements ConstraintValidator<ValidOrderStatus, String> {
    private static final List<String> VALID_STATUSES = List.of(
            "PENDING", "SHIPPED", "DELIVERED", "CANCELLED"
    );
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s == null || VALID_STATUSES.contains(s.toUpperCase());
    }
}
