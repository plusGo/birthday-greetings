package com.mhl.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String email;

    public Employee() {
    }

    public Employee(final String lastName, final String firstName, final String dateOfBirth, final String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
