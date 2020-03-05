package com.ac.backend.annotaion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = RoleNameValidator.class)
@Documented
public @interface ValidRoleName {
    String message() default "Invalid role name. Name of the role should start with prefix \"ROLE_\"";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}