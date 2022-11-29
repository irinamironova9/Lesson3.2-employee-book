package skypro.course3.lesson32employeebook.service;

import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class TestConstants {

    public static final List<EmployeeRequest> EMPLOYEE_REQUESTS = List.of(
            new EmployeeRequest("alexandra", "browne", 1, 10),
            new EmployeeRequest("Alex", "Greene", 1, 12),
            new EmployeeRequest("Anna", "Gray", 2, 15),
            new EmployeeRequest("adam", "red", 2, 13));

    public static final List<Employee> DEP_1 = List.of(
            new Employee("Alexandra", "Browne", 1, 10),
            new Employee("Alex", "Greene", 1, 12));

    public static final List<Employee> DEP_2 = List.of(
            new Employee("Anna", "Gray", 2, 15),
            new Employee("Adam", "Red", 2, 13));

    public static final List<Employee> ALL_EMPLOYEES = Stream.concat(
            DEP_1.stream(), DEP_2.stream()).toList();

    public static final Map<Integer, List<Employee>> EXPECTED = Map.of(
            1, DEP_1,
            2, DEP_2);
}