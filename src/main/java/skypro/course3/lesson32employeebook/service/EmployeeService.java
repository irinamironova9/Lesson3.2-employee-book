package skypro.course3.lesson32employeebook.service;

import org.springframework.stereotype.Service;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeBook = new HashMap<>();

    public Employee addEmployee(EmployeeRequest er) {

        if (er.getFullName() == null ||
                er.getFullName().isBlank() ||
                er.getDepartment() < 1 ||
                er.getDepartment() > 5 ||
                er.getSalary() < 0) {
            throw new IllegalArgumentException("Введены некорректные данные!");
        }

        Employee employee = new Employee(er.getFullName(),
                er.getDepartment(), er.getSalary());

        if (this.employeeBook.containsValue(employee)) {
            throw new RuntimeException("Данный сотрудник уже добавлен.");
        }

        this.employeeBook.put(employee.getId(), employee);

        return employee;
    }

    public Collection<Employee> getAllEmployees() {
        return employeeBook.values();
    }

    public Collection<Employee> getWhoHasSalaryAboveAverage() {

        return employeeBook.values()
                .stream()
                .filter(e -> e.getSalary() >= getAverageSalary())
                .collect(Collectors.toList());
    }

    public Optional<Employee> getMaxSalaryEmployee() {
        return employeeBook.values()
                .stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public Optional<Employee> getMinSalaryEmployee() {
        return employeeBook.values()
                .stream()
                .min(Comparator.comparing(Employee::getSalary));
    }

    public double getSalarySum() {

        return employeeBook.values()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    private double getAverageSalary() {

        return employeeBook.isEmpty() ? 0 : employeeBook.values()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average().getAsDouble();
    }
}
