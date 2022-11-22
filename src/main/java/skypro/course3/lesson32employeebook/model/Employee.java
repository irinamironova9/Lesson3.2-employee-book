package skypro.course3.lesson32employeebook.model;

import java.util.Objects;

public class Employee {

    private static int counter;
    private final String name;
    private final String surname;
    private final int department;
    private final double salary;
    private final int id;

    public Employee(String name, String surname, int department, double salary) {

        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        counter++;
        id = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
        return name + " " + surname +
                ", отдел №" + department +
                ", з/п " + salary + " руб./мес., id = " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, department, salary);
    }
}
