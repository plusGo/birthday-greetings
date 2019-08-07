package com.mhl.service;

import com.mhl.factory.SingleBeanFactory;
import com.mhl.model.Employee;
import com.mhl.repository.EmployeeRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class EmployeeService {
    private EmployeeRepository employeeRepository = SingleBeanFactory.getEmployeeRepository();

    public List<Employee> findEmployeesByBirthday(final Integer dayOfYear) throws IOException {
        return employeeRepository.findAll()
                .parallelStream()
                .filter(employee -> Objects.equals(employee.getDateOfBirth().getDayOfYear(), dayOfYear) ||
                        this.isBirthdayWhenLeapYearBorn(employee, dayOfYear)
                )
                .collect(toList());
    }

    private boolean isBirthdayWhenLeapYearBorn(final Employee employee, final Integer dayOfYear) {
        final LocalDate birthday = employee.getDateOfBirth();
        return Objects.equals(birthday.getMonth(), Month.FEBRUARY)
                && Objects.equals(birthday.getDayOfMonth(), 29)
                && !LocalDate.now().isLeapYear()
                && Objects.equals(LocalDate.of(LocalDate.now().getYear(), 2, 28).getDayOfYear(), dayOfYear);
    }


}
