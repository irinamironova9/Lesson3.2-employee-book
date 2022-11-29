package skypro.course3.lesson32employeebook.service;

import org.springframework.stereotype.Service;
import skypro.course3.lesson32employeebook.model.Employee;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployeesSortedByDepartment() {
        return employeeService.getAllEmployees().stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> getEmployeesOfGivenDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department).toList();
    }

    public double getMaxSalaryInDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .max().orElse(0);
    }

    public double getMinSalaryInDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .min().orElse(0);
    }

    public double getSumOfSalariesInDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
