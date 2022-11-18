package skypro.course3.lesson32employeebook.model;

import java.util.Objects;

public class Employee {

    private static int counter;
    private final String fullName;
    private final int department;
    private final double salary;
    private final int id;

    public Employee(String fullName, int department, double salary) {

        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        counter++;
        id = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return fullName + ", отдел №" + department + ", з/п " + salary + " руб./мес., id = " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }
}
