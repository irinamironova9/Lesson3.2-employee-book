package skypro.course3.lesson32employeebook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.record.EmployeeRequest;
import skypro.course3.lesson32employeebook.service.EmployeeService;
import java.util.Collection;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
            return this.employeeService.addEmployee(employeeRequest);
    }

    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "Сотрудник успешно удалён";
    }

    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam("id") int id) {
        return employeeService.findEmployee(id);
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/high-salary")
    public Collection<Employee> getWhoHasSalaryAboveAverage() {
        return this.employeeService.getWhoHasSalaryAboveAverage();
    }

    @GetMapping("/employee/salary/max")
    public Optional<Employee> getMaxSalaryEmployee() {
        return this.employeeService.getMaxSalaryEmployee();
    }

    @GetMapping("/employee/salary/min")
    public Optional<Employee> getMinSalaryEmployee() {
        return this.employeeService.getMinSalaryEmployee();
    }

    @GetMapping("/employees/salary/sum")
    public double getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> ExceptionsHandler(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}