public class Employee {
    // Поля
    private String name;
    private Department department;

    // Конструктор
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    // Свойство
    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    // Метод
    public String toString() {
        if (this.equals(department.getBoss())) {
            return name + " работает в отделе " + department.getName() + " и является начальником отдела";
        } else {
            return name + " работает в отделе " + department.getName() + ", работает на начальника " + department.getBoss().getName();
        }
    }
}