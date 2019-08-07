package com.mhl.service;

import com.mhl.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
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
