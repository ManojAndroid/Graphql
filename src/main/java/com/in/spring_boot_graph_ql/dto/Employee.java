package com.in.spring_boot_graph_ql.dto;

import com.in.spring_boot_graph_ql.annotation.ValidateEmployeeType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Builder
public class Employee {
    @NotNull(message = "Name should not be empty !")
    private String name;
    @NotEmpty()
    private String email;
    //@ValidateEmployeeType
    private String employeeType;
}
