import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Работа с Time
        System.out.println("Введите общее количество секунд ИЛИ часы, минуты, секунды через пробел:");
        String input = scanner.nextLine();

        Time time;
        String[] parts = input.trim().split("\\s+");

        try {
            if (parts.length == 1) {
                // Введено одно число: общее количество секунд
                int seconds = Integer.parseInt(parts[0]);
                if (seconds < 0) {
                    throw new IllegalArgumentException("Количество секунд не может быть отрицательным.");
                }
                time = new Time(seconds);
            } else if (parts.length == 3) {
                // Введены три числа: часы, минуты, секунды
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                int seconds = Integer.parseInt(parts[2]);

                if (hours < 0 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60) {
                    throw new IllegalArgumentException("Неверные значения для времени.");
                }

                time = new Time(hours, minutes, seconds);
            } else {
                throw new IllegalArgumentException("Неверный формат ввода. Укажите либо одно число, либо три числа через пробел.");
            }

            System.out.println("Текущее время: " + time);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Все введённые значения должны быть целыми числами.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        // Создание отдела
        scanner.nextLine();
        System.out.print("Введите название отдела: ");
        String departmentName = scanner.nextLine();
        Department department = new Department(departmentName);

        // Ввод сотрудников
        System.out.print("Введите имена сотрудников через пробел: ");
        String employeeNamesInput = scanner.nextLine().trim();
        if (employeeNamesInput.isEmpty()) {
            System.out.println("Ошибка! Необходимо указать хотя бы одного сотрудника.");
            return;
        }
        String[] employeeNames = employeeNamesInput.split("\\s+");
        List<Employee> employees = new ArrayList<>();
        for (String name : employeeNames) {
            employees.add(new Employee(name, department));
        }

        // Выбор начальника
        Employee boss = null;
        while (boss == null) {
            System.out.print("Введите имя начальника из списка: ");
            String bossName = scanner.nextLine();
            for (Employee employee : employees) {
                if (employee.getName().equals(bossName)) {
                    boss = employee;
                    break;
                }
            }
            if (boss == null) {
                System.out.println("Ошибка! Имя должно быть из списка сотрудников: " + String.join(", ", employeeNames));
            }
        }
        department.setBoss(boss);

        // Вывод данных
        System.out.println(department);
        for (Employee employee : department.getEmployees()) {
            System.out.println(employee);
        }

        // Создание бинарного дерева
        BinaryTree tree = new BinaryTree();

        // Ввод чисел для добавления в бинарное дерево
        String[] binaryTreeInput = null;
        while (binaryTreeInput == null || binaryTreeInput.length == 0) {
            System.out.println("Введите числа для добавления в бинарное дерево, разделенные пробелом и нажмите Enter:");
            String binaryTreeInputStr = scanner.nextLine().trim();
            if (binaryTreeInputStr.isEmpty()) {
                System.out.println("Ошибка! Ввод не может быть пустым.");
            } else {
                binaryTreeInput = binaryTreeInputStr.split("\\s+");
            }
        }

        for (String str : binaryTreeInput) {
            try {
                int value = Integer.parseInt(str);
                if (value == 0) {
                    System.out.println("Ошибка! Значение 0 недопустимо.");
                } else if (value < 0) {
                    System.out.println("Ошибка! Число не может быть отрицательным: " + value);
                } else {
                    tree.addValue(value); // Добавляем в дерево
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
                return;
            }
        }

        // Вывод дерева
        System.out.println("Текущее дерево (левосторонний обход):");
        System.out.println(tree.getTreeAsString());

        // Проверка на существование значения
        System.out.print("Введите число для проверки существования в дереве: ");
        int checkValue = scanner.nextInt();
        if (tree.containsValue(checkValue)) {
            System.out.println("Число " + checkValue + " существует в дереве.");
        } else {
            System.out.println("Число " + checkValue + " не найдено в дереве.");
        }

        // Удаление значения
        System.out.print("Введите число для удаления из дерева: ");
        int removeValue = scanner.nextInt();
        tree.removeValue(removeValue);

        // Вывод дерева после удаления
        System.out.println("Дерево после удаления числа " + removeValue + ":");
        System.out.println(tree.getTreeAsString());

        System.out.print("Введите количество точек: ");
        int numPoints = getPositiveNumber(scanner);

        Point3D[] points = new Point3D[numPoints];
        for (int i = 0; i < numPoints; i++) {
            System.out.println("Введите координаты для точки " + (i + 1) + ":");
            int x = getCoordinate(scanner, "X");
            int y = getCoordinate(scanner, "Y");
            int z = getCoordinate(scanner, "Z");

            points[i] = new Point3D(x, y, z);
        }

        System.out.println("\nВведенные точки:");
        for (Point3D point : points) {
            System.out.println(point);
        }

        comparePoints(points);

        // Ввод типа птицы
        scanner.nextLine();
        while (true) {
            scanner.nextLine();
            System.out.print("Введите тип птицы (Воробей, Кукушка, Попугай) или 'стоп' для завершения: ");
            String birdType = scanner.nextLine().trim();

            if (birdType.equalsIgnoreCase("стоп")) {
                break;
            }

            System.out.print("Введите количество птиц: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
            int count = scanner.nextInt();
            scanner.nextLine();

            // Обработка выбранной птицы
            if (birdType.equalsIgnoreCase("Воробей")) {
                for (int i = 0; i < count; i++) {
                    Sparrow sparrow = new Sparrow();
                    sparrow.sing();
                }
            } else if (birdType.equalsIgnoreCase("Кукушка")) {
                for (int i = 0; i < count; i++) {
                    Cuckoo cuckoo = new Cuckoo();
                    cuckoo.sing();
                }
            } else if (birdType.equalsIgnoreCase("Попугай")) {
                System.out.print("Введите фразу для попугая: ");
                String phrase = scanner.nextLine();
                for (int i = 0; i < count; i++) {
                    Parrot parrot = new Parrot(phrase);
                    parrot.sing();
                }
            } else {
                System.out.println("Неизвестный тип птицы. Попробуйте снова.");
            }
        }
    }


        // Метод для ввода координат
    public static int getCoordinate(Scanner scanner, String coordinateName) {
        System.out.print("Введите координату " + coordinateName + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Метод для проверки совпадения точек
    public static void comparePoints(Point3D[] points) {
        boolean hasDuplicates = false;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    System.out.println("Совпадение найдено: " + points[i] + " и " + points[j]);
                    hasDuplicates = true;
                }
            }
        }
        if (!hasDuplicates) {
            System.out.println("Совпадений среди точек нет.");
        }
    }

    // Метод для ввода положительного числа
    public static int getPositiveNumber(Scanner scanner) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Ошибка! Введите положительное число.");
                }
            }
            System.out.println("Ошибка! Введите положительное число.");
            scanner.nextLine();
        }
    }
}
