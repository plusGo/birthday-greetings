package com.mhl.parser;

import com.google.common.base.Splitter;
import com.mhl.model.Employee;

import java.util.List;

public class EmployeeParser {
    public static Employee parseRecord(final String employeeLine) {
        final List<String> employeeInfoList = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .splitToList(employeeLine);

        return new Employee(
                employeeInfoList.get(0),
                employeeInfoList.get(1),
                employeeInfoList.get(2),
                employeeInfoList.get(3)
        );
    }
}
