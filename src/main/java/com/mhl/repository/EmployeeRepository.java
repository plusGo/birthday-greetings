package com.mhl.repository;

import com.google.common.base.Charsets;
import com.mhl.model.Employee;
import com.mhl.parser.EmployeeParser;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.io.Resources.asCharSource;
import static com.google.common.io.Resources.getResource;

public class EmployeeRepository {
    public List<Employee> findAll() throws IOException {
        return asCharSource(getResource("employee_records.txt"), Charsets.UTF_8)
                .readLines()
                .parallelStream()
                .map(EmployeeParser::parseRecord)
                .collect(Collectors.toList());
    }
}
