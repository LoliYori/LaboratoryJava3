public class Point2D {
    // Поля
    private int x;
    private int y;

    // Конструктор
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Свойство
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Метод
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point2D point = (Point2D) obj;
        return x == point.x && y == point.y;
    }

    public int hashCode() {
        return 31 * x + y;
    }
}