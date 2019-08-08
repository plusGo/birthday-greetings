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

    public List<Employee> findEmployeesByBirthday(final LocalDate birthday) throws IOException {
        final Month month = birthday.getMonth();
        final Integer dayOfMonth = birthday.getDayOfMonth();

        return employeeRepository.findAll()
                .parallelStream()
                .filter(employee -> Objects.equals(month, employee.getDateOfBirth().getMonth()))
                .filter(employee -> {
                    final LocalDate employeeBirthday = employee.getDateOfBirth();
                    if (Objects.equals(employeeBirthday.getDayOfMonth(), dayOfMonth)) {
                        return true;
                    }

                    /**
                     * 平年2月28日，应当作2月29日出生员工的生日
                     */
                    return !LocalDate.now().isLeapYear()
                            && Objects.equals(month, Month.FEBRUARY)
                            && Objects.equals(dayOfMonth, 28)
                            && Objects.equals(employeeBirthday.getDayOfMonth(), 29);
                })
                .collect(toList());
    }

}
