package skypro.course3.lesson32employeebook.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import skypro.course3.lesson32employeebook.exception.EmployeeAlreadyAddedException;
import skypro.course3.lesson32employeebook.exception.EmployeeNotFoundException;
import skypro.course3.lesson32employeebook.exception.InvalidEmployeeRequestException;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeBook = new HashMap<>();

    public Employee addEmployee(EmployeeRequest er) {

        if (!StringUtils.isAlpha(er.getName()) ||
                !StringUtils.isAlpha(er.getSurname()) ||
                er.getDepartment() < 1 ||
                er.getDepartment() > 5 ||
                er.getSalary() < 0) {
            throw new InvalidEmployeeRequestException("Введены некорректные данные сотрудника");
        }

        Employee employee = new Employee(
                StringUtils.capitalize(er.getName()),
                StringUtils.capitalize(er.getSurname()),
                er.getDepartment(),
                er.getSalary());

        if (this.employeeBook.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен");
        }

        this.employeeBook.put(employee.getId(), employee);

        return employee;
    }

    public void deleteEmployee(int id) {
        if (!employeeBook.containsKey(id)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employeeBook.remove(id);
    }

    public Employee findEmployee(int id) {
        if (!employeeBook.containsKey(id)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeBook.get(id);
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
                .average()
                .getAsDouble();
    }
}
