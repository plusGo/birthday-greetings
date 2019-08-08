package com.mhl.repository;

import com.mhl.factory.SingleBeanFactory;
import com.mhl.model.Employee;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeRepositoryTest {
    private final EmployeeRepository employeeRepository = SingleBeanFactory.getEmployeeRepository();

    @Test
    public void should_find_all_success() throws IOException {
        // given

        // when
        List<Employee> allEmployees = employeeRepository.findAll();

        // then
        assertEquals(allEmployees.size(), 4);
    }
}
