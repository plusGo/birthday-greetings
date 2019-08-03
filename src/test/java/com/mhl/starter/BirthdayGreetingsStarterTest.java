package com.mhl.starter;

import com.google.common.collect.ImmutableList;
import com.mhl.MockitoTest;
import com.mhl.model.Employee;
import com.mhl.service.EmailService;
import com.mhl.service.EmployeeService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class BirthdayGreetingsStarterTest extends MockitoTest {
    @InjectMocks
    BirthdayGreetingsStarter birthdayGreetingsStarter;
    @Mock
    private EmailService emailService;
    @Mock
    private EmployeeService employeeService;

    @Test
    public void should_run() throws IOException {
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
        verify(emailService, times(1)).sendGreetingEmail(employee1);
        verify(emailService, times(1)).sendGreetingEmail(employee2);
    }
}
