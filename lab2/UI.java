
import java.util.Scanner;
public class UI {
    private Scanner scanner;
    private Vector vector;
    public UI() {
        scanner = new Scanner(System.in);
    }
    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter 1 to create vector by one point, or 2 to create vector by two points: ");
                    int createChoice = scanner.nextInt();
                    if (createChoice == 1) {
                        createVector(false);
                    } else if (createChoice == 2) {
                        createVector(true);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
                case 2 -> performArithmeticOperations();
                case 3 -> normalizeVector();
                case 4 -> getVectorLength();
                case 5 -> checkCollinearity();
                case 6 -> checkCoplanarity();
                case 7 -> calculateDistance();
                case 8 -> calculateAngle();
                case 9 -> ScalarTripleProduct();
                case 10 -> VectorTripleProduct();
                case 11 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    private void printMenu() {
        System.out.println("\n-- Vector Operations --");
        System.out.println("1. Create a new vector. All vectors gonna perform with this like 1st vector");
        System.out.println("2. Perform arithmetic operations on vectors");
        System.out.println("3. Normalize a vector");
        System.out.println("4. Get the length of a vector");
        System.out.println("5. Check if two vectors are collinear");
        System.out.println("6. Check if three vectors are coplanar");
        System.out.println("7. Calculate the distance between two vectors");
        System.out.println("8. Calculate the angle between two vectors");
        System.out.println("9. Calculate scalar product of 3 vectors");
        System.out.println("10. Calculate vector product of 3 vectors");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
    }
    private void createVector(boolean useTwoPoints) {
        if (useTwoPoints) {
            System.out.print("Enter the x-coordinate of the first point: ");
            double x1 = scanner.nextDouble();
            System.out.print("Enter the y-coordinate of the first point: ");
            double y1 = scanner.nextDouble();
            System.out.print("Enter the z-coordinate of the first point: ");
            double z1 = scanner.nextDouble();
            System.out.print("Enter the x-coordinate of the second point: ");
            double x2 = scanner.nextDouble();
            System.out.print("Enter the y-coordinate of the second point: ");
            double y2 = scanner.nextDouble();
            System.out.print("Enter the z-coordinate of the second point: ");
            double z2 = scanner.nextDouble();
            Point p1 = new Point(x1, y1, z1);
            Point p2 = new Point(x2, y2, z2);
            vector = new Vector(p1, p2);
            System.out.println("Vector created: " + vector);
        } else {
            System.out.print("Enter the x-coordinate: ");
            double x = scanner.nextDouble();
            System.out.print("Enter the y-coordinate: ");
            double y = scanner.nextDouble();
            System.out.print("Enter the z-coordinate: ");
            double z = scanner.nextDouble();
            vector = new Vector(x, y, z);
            System.out.println("Vector created: " + vector);
        }
    }

    private void performArithmeticOperations() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z = scanner.nextDouble();
        Vector secondVector = new Vector(x, y, z);
        System.out.println("Addition: " + vector.add(secondVector));
        System.out.println("Subtraction: " + vector.subtract(secondVector));
        System.out.println("Dot Product: " + vector.getDotProduct(secondVector));
        System.out.println("Cross Product: " + vector.getCrossProduct(secondVector));
    }
    private void normalizeVector() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        Vector unitVector = vector.getUnitVector();
        System.out.println("Normalized Vector: " + unitVector);
    }
    private void getVectorLength() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        double length = vector.getLength();
        System.out.println("Vector Length: " + length);
    }
    private void checkCollinearity() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z = scanner.nextDouble();
        Vector secondVector = new Vector(x, y, z);
        boolean collinear = vector.isCollinear(secondVector);
        System.out.println("Are the vectors collinear? " + collinear);
    }
    private void checkCoplanarity() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z1 = scanner.nextDouble();
        System.out.print("Enter the x-coordinate of the third vector: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the third vector: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the third vector: ");
        double z2 = scanner.nextDouble();
        Vector secondVector = new Vector(x1, y1, z1);
        Vector thirdVector = new Vector(x2, y2, z2);
        boolean coplanar = vector.isCoplanar(secondVector, thirdVector);
        System.out.println("Are the vectors coplanar? " + coplanar);
    }

    private void ScalarTripleProduct() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z1 = scanner.nextDouble();
        System.out.print("Enter the x-coordinate of the third vector: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the third vector: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the third vector: ");
        double z2 = scanner.nextDouble();
        Vector secondVector = new Vector(x1, y1, z1);
        Vector thirdVector = new Vector(x2, y2, z2);
        double result = vector.getScalarTripleProduct(secondVector, thirdVector);
        System.out.println("Triple scalar product " + result);
    }

    private void VectorTripleProduct() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z1 = scanner.nextDouble();
        System.out.print("Enter the x-coordinate of the third vector: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the third vector: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the third vector: ");
        double z2 = scanner.nextDouble();
        Vector secondVector = new Vector(x1, y1, z1);
        Vector thirdVector = new Vector(x2, y2, z2);
        double result = vector.getVectorTripleProduct(secondVector, thirdVector);
        System.out.println("Vector triple product " + result);
    }

    private void calculateDistance() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z = scanner.nextDouble();
        Vector secondVector = new Vector(x, y, z);
        double distance = vector.getDistance(secondVector);
        System.out.println("Distance between the vectors: " + distance);
    }
    private void calculateAngle() {
        if (vector == null) {
            System.out.println("No vector created. Please create a vector first.");
            return;
        }
        System.out.print("Enter the x-coordinate of the second vector: ");
        double x = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second vector: ");
        double y = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second vector: ");
        double z = scanner.nextDouble();
        Vector secondVector = new Vector(x, y, z);
        double angle = vector.getAngle(secondVector);
        System.out.println("Angle between the vectors (in radians): " + angle);
    }
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}