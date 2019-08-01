package com.mhl;

import com.mhl.logger.Logger;
import com.mhl.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public final static Logger logger = new Logger();

    public static void main(String[] args) throws IOException {
        findEmployeesByBirthday(LocalDate.now())
                .parallelStream()
                .forEach(App::sendGreetingEmail);
    }

    private static void sendGreetingEmail(final Employee employee) {
        System.out.println("Subject:Happy Birthday");
        System.out.println(String.format("Happy Birthday,dear %s", employee.getFirstName()));
    }

    public static List<Employee> findEmployeesByBirthday(final LocalDate birthday) throws IOException {
        return loadAllEmployees()
                .parallelStream()
                .filter(employee -> Objects.equals(employee.getDateOfBirth(), birthday))
                .collect(Collectors.toList());
    }

    private static List<Employee> loadAllEmployees() throws IOException {
        final List<Employee> allEmployees = new ArrayList<>();

        final InputStream inputStream = App.class.getClassLoader().getResourceAsStream("employee_records.txt");
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            allEmployees.add(employeeRecordParser(str));
        }
        return allEmployees;
    }

    private static Employee employeeRecordParser(final String employeeRecord) {
        final Employee employee = new Employee();
        Stream.of(employeeRecord.split(","))
                .map(String::trim)
                .forEach((record) -> {
                    if (Objects.isNull(employee.getLastName())) {
                        employee.setLastName(record);
                        return;
                    }
                    if (Objects.isNull(employee.getFirstName())) {
                        employee.setFirstName(record);
                        return;
                    }
                    if (Objects.isNull(employee.getDateOfBirth())) {
                        employee.setDateOfBirth(LocalDate.parse(record, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                        return;
                    }
                    if (Objects.isNull(employee.getEmail())) {
                        employee.setEmail(record);
                        return;
                    }
                });
        return employee;
    }

}
