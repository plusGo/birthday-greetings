package com.mhl.parser;

import com.mhl.model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Stream;

public class EmployeeParser {
    public static Employee parseRecord(final String employeeRecord) {
        final Employee employee = new Employee();
        Stream.of(employeeRecord.split(","))
                .map(String::trim)
                .forEach((record) -> {
                    if (Objects.isNull(employee.getLastName())) {
                        employee.setLastName(record);
                        return;
                    }
                    if (Objects.isNull(employee.getFirstName())) {
                        employee.setFirstName(record);
                        return;
                    }
                    if (Objects.isNull(employee.getDateOfBirth())) {
                        employee.setDateOfBirth(LocalDate.parse(record, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                        return;
                    }
                    if (Objects.isNull(employee.getEmail())) {
                        employee.setEmail(record);
                    }
                });
        return employee;
    }
}
