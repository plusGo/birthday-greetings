package com.mhl.service;

import com.mhl.Application;
import com.mhl.factory.SingleBeanFactory;
import com.mhl.logger.Logger;
import com.mhl.model.Employee;
import com.mhl.parser.EmployeeParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeService {
    final private static Logger logger = SingleBeanFactory.getLogger();

    public List<Employee> findEmployeesByBirthday(final LocalDate birthday) throws IOException {
        return this.loadAllEmployees()
                .parallelStream()
                .filter(employee -> Objects.equals(employee.getDateOfBirth(), birthday))
                .collect(Collectors.toList());
    }

    private List<Employee> loadAllEmployees() throws IOException {
        final List<Employee> allEmployees = new ArrayList<>();

        final InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("employee_records.txt");
        if (Objects.isNull(inputStream)) {
            logger.error("employee_records.txt not exist");
            throw new RuntimeException();
        }

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String employeeRecord;
        while ((employeeRecord = bufferedReader.readLine()) != null) {
            allEmployees.add(EmployeeParser.parseRecord(employeeRecord));
        }
        return allEmployees;
    }

}
