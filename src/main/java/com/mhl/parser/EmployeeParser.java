package com.mhl.parser;

import com.mhl.model.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeParser {
    public static Employee parseRecord(final String employeeRecord) {
        List<String> employeeInfoList = Stream.of(employeeRecord.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new Employee(
                employeeInfoList.get(0),
                employeeInfoList.get(1),
                employeeInfoList.get(2),
                employeeInfoList.get(3)
        );
    }
}
