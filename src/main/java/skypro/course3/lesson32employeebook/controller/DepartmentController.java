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

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesSortedByDepartment() {
        return departmentService.getAllEmployeesSortedByDepartment();
    }

    @GetMapping("/dep/employees")
    public List<Employee> getEmployeesOfGivenDepartment(@RequestParam("dep") String department) {
        int dep = Integer.parseInt(department);
        return departmentService.getEmployeesOfGivenDepartment(dep);
    }

    @GetMapping("/{}/salary/max")
    public double getMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMaxSalaryInDepartment(department);
    }

    @GetMapping("/{}/salary/min")
    public double getMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMinSalaryInDepartment(department);
    }

    @GetMapping("/{}/salary/sum")
    public double getSumOfSalariesInDepartment(@RequestParam int department) {
        return departmentService.getSumOfSalariesInDepartment(department);
    }
}
