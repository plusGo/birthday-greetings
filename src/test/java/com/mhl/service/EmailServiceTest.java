package com.mhl.service;

import com.mhl.MockitoTest;
import com.mhl.model.Employee;
import org.junit.Test;
import org.mockito.InjectMocks;

public class EmailServiceTest extends MockitoTest {
    @InjectMocks
    private EmailService emailService;

    @Test
    public void should_send_greeting_email_success() {
        // given
        final Employee employee = new Employee();
        // when
        emailService.sendGreetingEmail(employee);

        // then
    }
}
