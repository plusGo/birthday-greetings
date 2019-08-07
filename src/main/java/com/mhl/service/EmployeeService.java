package com.mhl.service;

import com.mhl.repository.EmployeeRepository;
import com.mhl.factory.SingleBeanFactory;
import com.mhl.model.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeService {
    private EmployeeRepository employeeRepository = SingleBeanFactory.getEmployeeRepository();

    public List<Employee> findEmployeesByBirthday(final Integer day) throws IOException {
        return employeeRepository.findAll()
                .parallelStream()
                .filter(employee -> Objects.equals(employee.getDateOfBirth().getDayOfYear(), day))
                .collect(Collectors.toList());
    }


}
