import java.util.Random;

abstract class Bird {
    // Свойство
    public abstract String getName();

    // Метод
    public abstract void sing();
}

class Sparrow extends Bird {
    // Свойство
    public String getName() {
        return "Воробей";
    }

    // Метод
    public void sing() {
        System.out.println("чырык");
    }
}

class Cuckoo extends Bird {
    // Свойство
    public String getName() {
        return "Кукушка";
    }

    // Метод
    public void sing() {
        Random random = new Random();
        int repeatCount = random.nextInt(10) + 1;
        for (int i = 0; i < repeatCount; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println();
    }
}

class Parrot extends Bird {
    // Поле
    private String text;
    private Random random = new Random();

    // Конструктор с текстом
    public Parrot(String text) {
        this.text = text;
    }

    // Свойство
    public String getName() {
        return "Попугай";
    }

    // Метод
    public void sing() {
        if (text.isEmpty()) {
            System.out.println("Попугай молчит...");
        } else {
            int length = random.nextInt(text.length()) + 1;
            System.out.println(text.substring(0, length));
        }
    }
}