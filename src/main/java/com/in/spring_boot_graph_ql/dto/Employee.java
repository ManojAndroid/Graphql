package com.in.spring_boot_graph_ql.dto;

import com.in.spring_boot_graph_ql.annotation.ValidateEmployeeType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Employee {
    @NotNull(message = "Name should not be empty !")
    private String name;
    @NotEmpty()
    private String email;

    @ValidateEmployeeType
    private String employeeType;
}
