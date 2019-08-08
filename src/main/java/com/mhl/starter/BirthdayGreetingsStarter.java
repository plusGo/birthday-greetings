package com.mhl.starter;

import com.mhl.factory.SingleBeanFactory;
import com.mhl.logger.Logger;
import com.mhl.service.EmailService;
import com.mhl.service.EmployeeService;

import java.time.LocalDate;

public class BirthdayGreetingsStarter {
    private final static Logger logger = SingleBeanFactory.getLogger();
    private EmailService emailService = SingleBeanFactory.getEmailService();
    private EmployeeService employeeService = SingleBeanFactory.getEmployeeService();

    public void run() {
        try {
            employeeService.findEmployeesByBirthday(LocalDate.now())
                    .parallelStream()
                    .forEach(emailService::sendGreetingEmail);
        } catch (Exception exception) {
            logger.error("birthday greeting task execute failed", exception);
        }
    }

}
