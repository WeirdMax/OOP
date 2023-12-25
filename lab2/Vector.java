public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point p1, Point p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
        this.z = p2.getZ() - p1.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    // сложение
    public Vector add(Vector v) {
        double newX = this.x + v.getX();
        double newY = this.y + v.getY();
        double newZ = this.z + v.getZ();
        return new Vector(newX, newY, newZ);
    }

    //вычитание
    public Vector subtract(Vector v) {
        double newX = this.x - v.getX();
        double newY = this.y - v.getY();
        double newZ = this.z - v.getZ();
        return new Vector(newX, newY, newZ);
    }
    public Vector getInverse() {
        return new Vector(-this.x, -this.y, -this.z);
    }

    //единичный
    public Vector getUnitVector() {
        double length = getLength();
        double newX = this.x / length;
        double newY = this.y / length;
        double newZ = this.z / length;
        return new Vector(newX, newY, newZ);
    }

    //скалярное текущего и вектора v
    public double getDotProduct(Vector v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    //векторное произведение текущего и v
    public Vector getCrossProduct(Vector v) {
        double newX = this.y * v.getZ() - this.z * v.getY();
        double newY = this.z * v.getX() - this.x * v.getZ();
        double newZ = this.x * v.getY() - this.y * v.getX();
        return new Vector(newX, newY, newZ);
    }

    //скалярное тройное произведение
    public double getScalarTripleProduct(Vector v1, Vector v2) {
        return this.getDotProduct(v1.getCrossProduct(v2));
    }

    //векторное тройное произведение
    public double getVectorTripleProduct(Vector v1, Vector v2) {
        return this.getCrossProduct(v1).getDotProduct(v2);
    }
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    //параллельные или противоположные
    public boolean isCollinear(Vector v) {
        return this.getDotProduct(v) == 0;
    }

    // в одной плоскоски
    public boolean isCoplanar(Vector v1, Vector v2) {
        return this.getScalarTripleProduct(v1, v2) == 0;
    }
    public double getDistance(Vector v) {
        return this.subtract(v).getLength();
    }
    public double getAngle(Vector v) {
        double dotProduct = this.getDotProduct(v);
        double lengthProduct = this.getLength() * v.getLength();
        return Math.acos(dotProduct / lengthProduct);
    }
}