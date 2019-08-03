package com.mhl.parser;

import com.mhl.model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeParser {
    public static Employee parseRecord(final String employeeRecord) {
        final Employee employee = new Employee();
        List<String> employeeInfoList = Stream.of(employeeRecord.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        employee.setLastName(employeeInfoList.get(0));
        employee.setFirstName(employeeInfoList.get(1));
        employee.setDateOfBirth(LocalDate.parse(employeeInfoList.get(2), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        employee.setEmail(employeeInfoList.get(3));

        return employee;
    }
}
