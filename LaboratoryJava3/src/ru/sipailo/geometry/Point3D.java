public class Point3D extends Point2D {
    // Поля
    private int z;

    // Конструктор
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Свойство
    public int getZ() {
        return z;
    }

    // Метод
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point3D)) return false;
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        return z == point3D.z;
    }

    public int hashCode() {
        return 31 * super.hashCode() + z;
    }
}