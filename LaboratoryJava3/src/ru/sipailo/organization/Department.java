import java.util.ArrayList;
import java.util.List;

public class Department {
    // Поля
    private String name;
    private Employee boss;
    private List<Employee> employees;

    // Конструктор
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Свойство
    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        if (!employees.contains(boss)) {
            throw new IllegalArgumentException("Сотрудник " + boss.getName() + " не работает в отделе " + name);
        }
        this.boss = boss;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    // Метод
    public String toString() {
        return "Отдел " + name + ", начальник отдела " + (boss != null ? boss.getName() : "не назначен");
    }
}