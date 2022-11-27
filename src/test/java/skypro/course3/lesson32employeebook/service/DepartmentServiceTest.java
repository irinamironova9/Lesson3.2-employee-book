package skypro.course3.lesson32employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static skypro.course3.lesson32employeebook.service.DepartmentServiceTestConstants.*;

class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService = new EmployeeService();

    @InjectMocks
    private DepartmentService out;

    @BeforeEach
    public void setUp() {
        EMPLOYEE_REQUESTS.forEach(employeeService::addEmployee);
    }

    @Test
    void getAllEmployeesSortedByDepartment() {
        assertNotNull(employeeService);
        when(employeeService.getEmployees()).thenReturn();
        Map<Integer, List<Employee>> actual = out.getAllEmployeesSortedByDepartment();
        assertEquals(EXPECTED, actual);
    }

    @Test
    void getEmployeesOfGivenDepartment() {
    }

    @Test
    void getMaxSalaryInDepartment() {
    }

    @Test
    void getMinSalaryInDepartment() {
    }

    @Test
    void getSumOfSalariesInDepartment() {
    }
}