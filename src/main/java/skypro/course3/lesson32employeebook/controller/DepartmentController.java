package skypro.course3.lesson32employeebook.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import skypro.course3.lesson32employeebook.model.Employee;
import skypro.course3.lesson32employeebook.service.DepartmentService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all-employees")
    public Map<Integer, List<Employee>> getAllEmployeesSortedByDepartment() {
        return departmentService.getAllEmployeesSortedByDepartment();
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesOfGivenDepartment(@RequestParam("dep") int department) {
        return departmentService.getEmployeesOfGivenDepartment(department);
    }

    @GetMapping("/salary/max")
    public double getMaxSalaryInDepartment(@RequestParam("dep") int department) {
        return departmentService.getMaxSalaryInDepartment(department);
    }

    @GetMapping("/salary/min")
    public double getMinSalaryInDepartment(@RequestParam("dep") int department) {
        return departmentService.getMinSalaryInDepartment(department);
    }

    @GetMapping("/salary/sum")
    public double getSumOfSalariesInDepartment(@RequestParam("dep") int department) {
        return departmentService.getSumOfSalariesInDepartment(department);
    }
}
