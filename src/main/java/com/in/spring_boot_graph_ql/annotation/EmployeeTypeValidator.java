package com.in.spring_boot_graph_ql.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType, String> {
    @Override
    public void initialize(ValidateEmployeeType validateEmployeeType) {
    }

    @Override
    public boolean isValid(String employeeType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> employeeTypeList = Arrays.asList("Permanent", "PartTime");
        return employeeTypeList.contains(employeeType);
    }
}
