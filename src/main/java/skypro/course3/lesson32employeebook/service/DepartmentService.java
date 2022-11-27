package skypro.course3.lesson32employeebook.service;

import org.springframework.stereotype.Service;
import skypro.course3.lesson32employeebook.model.Employee;

import java.util.*;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployeesSortedByDepartment() {
        Map<Integer, List<Employee>> sorted = new HashMap<>();
        employeeService.getEmployeeBook().values()
                .forEach(e -> sorted.put(e.getDepartment(), null));
        for (int i : sorted.keySet()) {
            int finalI = i;
            List<Employee> list = employeeService.getEmployeeBook().values().stream()
                    .filter(e -> e.getDepartment() == finalI).toList();
            sorted.put(finalI, list);
        }
        return sorted;
    }

    public List<Employee> getEmployeesOfGivenDepartment(int department) {
        return employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department).toList();
    }

    public double getMaxSalaryInDepartment(int department) {
        return employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .min().orElse(0);
        // .orElseThrow(DepartmentNotFoundException::new)
    }

    public double getMinSalaryInDepartment(int department) {
        return employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .max().orElse(0);
    }

    public double getSumOfSalariesInDepartment(int department) {
        return employeeService.getEmployeeBook().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
