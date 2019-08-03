package com.mhl.factory;

import com.mhl.logger.Logger;
import com.mhl.service.EmailService;
import com.mhl.service.EmployeeService;
import com.mhl.starter.BirthdayGreetingsStarter;

public class SingleBeanFactory {
    private final static EmployeeService employeeService = new EmployeeService();
    private final static EmailService emailService = new EmailService();
    private final static BirthdayGreetingsStarter birthdayGreetingsStarter = new BirthdayGreetingsStarter();

    private final static Logger logger = new Logger();

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static BirthdayGreetingsStarter getBirthdayGreetingStarter() {
        return birthdayGreetingsStarter;
    }

    public static EmailService getEmailService() {
        return emailService;
    }

}
