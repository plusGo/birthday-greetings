package com.mhl.starter;

import com.google.common.collect.ImmutableList;
import com.mhl.model.Employee;
import com.mhl.service.EmailService;
import com.mhl.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreetingsStarterTest {
    @InjectMocks
    BirthdayGreetingsStarter birthdayGreetingsStarter;
    @Mock
    private EmailService emailService;
    @Mock
    private EmployeeService employeeService;

    @Test
    public void run() throws IOException {
        // given
        final Employee employee1 = new Employee();
        final Employee employee2 = new Employee();
        LocalDate localDate = LocalDate.now();

        when(employeeService.findEmployeesByBirthday(localDate)).thenReturn(ImmutableList.of(employee1, employee2));
        doNothing().when(emailService).sendGreetingEmail(any(Employee.class));

        // when
        birthdayGreetingsStarter.run();

        // then
        verify(employeeService, times(1)).findEmployeesByBirthday(localDate);
        verify(emailService, times(2)).sendGreetingEmail(any(Employee.class));
    }
}
