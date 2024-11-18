public class Time {
    // Поля
    private int seconds;

    // Конструктор
    public Time(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным.");
        }
        this.seconds = seconds % 86400;
    }

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0 || minutes >= 60 || seconds >= 60) {
            throw new IllegalArgumentException("Неверные значения для времени.");
        }
        this.seconds = (hours * 3600 + minutes * 60 + seconds) % 86400;
    }

    // Свойство
    public int getHours() {
        return seconds / 3600;
    }

    public int getMinutes() {
        return (seconds % 3600) / 60;
    }

    public int getSeconds() {
        return seconds % 60;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным.");
        }
        this.seconds = seconds % 86400;
    }

    // Метод
    public String toString() {
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
    }
}