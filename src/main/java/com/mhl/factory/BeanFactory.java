package com.mhl.factory;

import com.mhl.logger.Logger;
import com.mhl.service.EmployeeService;
import com.mhl.starter.BirthdayGreetingsStarter;

public class BeanFactory {
    private final static EmployeeService employeeService = new EmployeeService();
    private final static Logger logger = new Logger();
    private final static BirthdayGreetingsStarter birthdayGreetingsStarter = new BirthdayGreetingsStarter();

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static BirthdayGreetingsStarter getBirthdayGreetingStarter() {
        return birthdayGreetingsStarter;
    }

}
