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
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void should_find_employees_by_birthday_success() throws IOException {
        // given
        final LocalDate birthday = LocalDate.of(2019, 8, 8);

        // when
        List<Employee> employeesByBirthday = employeeService.findEmployeesByBirthday(birthday);

        // then
        assertNotNull(employeesByBirthday);
        assertEquals(employeesByBirthday.size(), 1);
    }

    @Test
    public void should_find_employees_contains_tom_when_day_of_ordinary_year_is_2_29() throws IOException {
        // given
        final LocalDate birthday = LocalDate.of(2019, 2, 28);

        // when
        List<Employee> employeesByBirthday = employeeService.findEmployeesByBirthday(birthday);

        // then
        Optional<Employee> tom = employeesByBirthday.stream()
                .filter(employee -> Objects.equals(employee.getLastName(), "Tom"))
                .findAny();

        assertTrue(tom.isPresent());
    }


    @Test(expected = DateTimeException.class)
    public void should_find_employees_by_birthday_failed() throws IOException {
        // given
        final LocalDate birthday = LocalDate.of(2019, 2, 29);

        // when
        List<Employee> employeesByBirthday = employeeService.findEmployeesByBirthday(birthday);

        // then
        assertNotNull(employeesByBirthday);
        assertEquals(employeesByBirthday.size(), 0);
    }

}
