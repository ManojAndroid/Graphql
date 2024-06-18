package com.in.spring_boot_graph_ql.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {
    String message() default " Employee type is not valid it should be Permanent or PartTime";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
