package skypro.course3.lesson32employeebook.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.course3.lesson32employeebook.exception.EmployeeAlreadyAddedException;
import skypro.course3.lesson32employeebook.exception.EmployeeNotFoundException;
import skypro.course3.lesson32employeebook.exception.InvalidEmployeeRequestException;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;
import java.util.Collection;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static skypro.course3.lesson32employeebook.service.TestConstants.*;

class EmployeeServiceTest {

    private EmployeeService out;

    @BeforeEach
    void setUp() {
        out = new EmployeeService();
        EMPLOYEE_REQUESTS.forEach(out::addEmployee);
    }

    @Test
    void addEmployee() {
        EmployeeRequest expected = new EmployeeRequest(
                "Test", "Test", 1, 10);
        Employee actual = out.addEmployee(expected);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurname(), actual.getSurname());
        assertEquals(expected.getDepartment(), actual.getDepartment());
        assertEquals(expected.getSalary(), actual.getSalary());

        assertThat(out.getAllEmployees()).contains(actual);
    }

    @Test
    void shouldCapitaliseName() {
        EmployeeRequest request = new EmployeeRequest(
                "test", "test", 1, 10);
        Employee actual = out.addEmployee(request);

        assertEquals(
                StringUtils.capitalize(request.getName()),
                actual.getName());

        assertEquals(StringUtils.capitalize(
                request.getSurname()),
                actual.getSurname());
    }

    @Test
    void shouldThrowInvalidEmployeeRequestException() {
        EmployeeRequest request1 = new EmployeeRequest(
                "   ", "Test", 1, 10);
        EmployeeRequest request2 = new EmployeeRequest(
                "Test", "123", 1, 10);
        EmployeeRequest request3 = new EmployeeRequest(
                "Test", "Test", -1, 10);
        EmployeeRequest request4 = new EmployeeRequest(
                "Test", "Test", 1, -10);

        assertThrows(InvalidEmployeeRequestException.class,
                () -> out.addEmployee(request1));
        assertThrows(InvalidEmployeeRequestException.class,
                () -> out.addEmployee(request2));
        assertThrows(InvalidEmployeeRequestException.class,
                () -> out.addEmployee(request3));
        assertThrows(InvalidEmployeeRequestException.class,
                () -> out.addEmployee(request4));
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedException() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(EMPLOYEE_REQUESTS.get(0)));
    }

    @Test
    void deleteEmployee() {
        assertThat(out.getAllEmployees()).hasSize(4);
        Employee expected = out.getAllEmployees().stream().findAny().get();
        out.deleteEmployee(expected.getId());
        assertThat(out.getAllEmployees())
                .hasSize(3)
                .doesNotContain(expected);
    }

    @Test
    void findEmployee() {
        Employee expected = out.getAllEmployees().stream().findAny().get();
        Employee actual = out.findEmployee(expected.getId());
        assertSame(expected, actual);
    }

    @Test
    void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.deleteEmployee(0));
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(0));
    }

    @Test
    void getAllEmployees() {
        Collection<Employee> actual = out.getAllEmployees();
        assertThat(actual)
                .hasSize(4)
                .contains(ALL_EMPLOYEES.listIterator().next());
    }

    @Test
    void getWhoHasSalaryAboveAverage() {
        Collection<Employee> actual = out.getWhoHasSalaryAboveAverage();
        assertThat(actual)
                .hasSize(2)
                .contains(DEP_2.listIterator().next());
    }

    @Test
    void getMaxSalaryEmployee() {
        Optional<Employee> actual = out.getMaxSalaryEmployee();
        assertThat(actual)
                .isNotEmpty()
                .contains(DEP_2.get(0));
    }

    @Test
    void getMinSalaryEmployee() {
        Optional<Employee> actual = out.getMinSalaryEmployee();
        assertThat(actual)
                .isNotEmpty()
                .contains(DEP_1.get(0));
    }

    @Test
    void getSalarySum() {
        double actual = out.getSalarySum();
        assertEquals(50, actual);
    }
}