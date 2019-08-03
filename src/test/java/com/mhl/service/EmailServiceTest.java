package com.mhl.service;

import com.mhl.MockitoTest;
import com.mhl.model.Employee;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EmailServiceTest extends MockitoTest {
    @InjectMocks
    private EmailService emailService;

    @Test
    public void should_send_greeting_email_success() {
        // given
        final Employee employee = mock(Employee.class);
        final String mockFirstName = "Jordan";
        when(employee.getFirstName()).thenReturn(mockFirstName);

        // when
        emailService.sendGreetingEmail(employee);

        // then
       verify(employee, times(1)).getFirstName();
    }
}
