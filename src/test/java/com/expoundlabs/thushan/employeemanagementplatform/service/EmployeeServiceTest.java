package com.expoundlabs.thushan.employeemanagementplatform.service;

import com.expoundlabs.thushan.employeemanagementplatform.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    ObjectMapper MAPPER = new ObjectMapper();

    private static final Employee employee = Employee.builder()
            .id((long)1)
            .name("ravi")
            .email("thushankavishka@gmail.com")
            .jobTitle("senior software engineer")
            .phone("0712119385")
            .employeeCode("a4eeab1f-df27-4cfa-9eb7-c6a7691d06cf")
            .build();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Test Add Employee Details")
    public void addEmployee() {
    }

    @Test
    void findAllEmployees() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void findEmployeeById() {
    }

    @Test
    void deleteEmployee() {
    }
}