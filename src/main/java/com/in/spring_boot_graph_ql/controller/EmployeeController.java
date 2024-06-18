package com.in.spring_boot_graph_ql.controller;

import com.in.spring_boot_graph_ql.annotation.LogRequest;
import com.in.spring_boot_graph_ql.annotation.LogTime;
import com.in.spring_boot_graph_ql.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @LogTime
    @GetMapping("{employ_id}")
    public ResponseEntity<?> getEmployee(@PathVariable("employ_id") Long id) {
        log.info(" employeeId : {} ", id);
        Employee employee = Employee.builder().email("manojSingh").build();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
