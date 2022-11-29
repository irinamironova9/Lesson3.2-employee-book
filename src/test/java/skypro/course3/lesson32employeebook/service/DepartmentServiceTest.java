package skypro.course3.lesson32employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course3.lesson32employeebook.model.Employee;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static skypro.course3.lesson32employeebook.service.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    EmployeeService mock;

    @InjectMocks
    DepartmentService out;

    @BeforeEach
    public void setUp() {
        when(mock.getAllEmployees()).thenReturn(ALL_EMPLOYEES);
    }

    @Test
    void getAllEmployeesSortedByDepartment() {
        Map<Integer, List<Employee>> actual = out.getAllEmployeesSortedByDepartment();
        assertEquals(EXPECTED, actual);
    }

    @Test
    void getEmployeesOfGivenDepartment() {
        Collection<Employee> actual = out.getEmployeesOfGivenDepartment(1);
        assertThat(actual)
                .hasSize(2)
                .contains(DEP_1.get(0), DEP_1.get(1));
    }

    @Test
    void getMaxSalaryInDepartment() {
        double actual = out.getMaxSalaryInDepartment(1);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    void getMinSalaryInDepartment() {
        double actual = out.getMinSalaryInDepartment(2);
        assertThat(actual).isEqualTo(13);
    }

    @Test
    void getSumOfSalariesInDepartment() {
        double actual = out.getSumOfSalariesInDepartment(2);
        assertThat(actual).isEqualTo(28);
    }
}