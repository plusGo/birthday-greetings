package com.mhl.service;

import com.mhl.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void should_find_employees_by_birthday_success() throws IOException {
        // given
        final Integer birthDay = LocalDate.of(2019, 8, 6).getDayOfYear();

        // when
        List<Employee> employeesByBirthday = employeeService.findEmployeesByBirthday(birthDay);

        // then
        assertNotNull(employeesByBirthday);
        assertEquals(employeesByBirthday.size(), 1);
    }

    @Test(expected = DateTimeException.class)
    public void should_find_employees_by_birthday_failed() throws IOException {
        // given
        final Integer birthDay = LocalDate.of(2019, 2, 29).getDayOfYear();

        // when
        List<Employee> employeesByBirthday = employeeService.findEmployeesByBirthday(birthDay);

        // then
        assertNotNull(employeesByBirthday);
        assertEquals(employeesByBirthday.size(), 0);
    }

}
