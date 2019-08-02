package com.mhl.starter;

import com.mhl.factory.BeanFactory;
import com.mhl.logger.Logger;
import com.mhl.service.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;

public class BirthdayGreetingsStarter {
    private final static Logger logger = BeanFactory.getLogger();
    private EmployeeService employeeService = BeanFactory.getEmployeeService();

    public void run() {
        try {
            employeeService.findEmployeesByBirthday(LocalDate.now())
                    .parallelStream()
                    .forEach(employeeService::sendGreetingEmail);
        } catch (IOException exception) {
            logger.error("birthday greeting task execute failed", exception);
        }
    }

}
