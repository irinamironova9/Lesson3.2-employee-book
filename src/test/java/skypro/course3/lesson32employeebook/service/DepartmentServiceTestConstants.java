package skypro.course3.lesson32employeebook.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class DepartmentServiceTestConstants {

    public static final List<EmployeeRequest> EMPLOYEE_REQUESTS = List.of(
            new EmployeeRequest("Alexandra", "Browne", 1, 10),
            new EmployeeRequest("Alex", "Greene", 1, 12),
            new EmployeeRequest("Anna", "Gray", 2, 15),
            new EmployeeRequest("Adam", "Red", 2, 13));

    public static final List<Employee> LIST_1 = List.of(
            new Employee("Alexandra", "Browne", 1, 10),
            new Employee("Alex", "Greene", 1, 12));

    public static final List<Employee> LIST_2 = List.of(
            new Employee("Anna", "Gray", 2, 15),
            new Employee("Adam", "Red", 2, 13));

    public static final List<Employee> EMPLOYEES = Stream.concat(
            LIST_1.stream(), LIST_2.stream()).toList();

    public static final Map<Integer, List<Employee>> EXPECTED = Map.of(
            1, LIST_1,
            2, LIST_2);

}