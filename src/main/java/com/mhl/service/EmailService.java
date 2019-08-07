package com.mhl.service;

import com.mhl.model.Employee;

public class EmailService {

    public boolean sendGreetingEmail(final Employee employee) {
        System.out.println("Subject:Happy Birthday");
        System.out.println(String.format("Happy Birthday,dear %s", employee.getFirstName()));
        return true;
    }

}
