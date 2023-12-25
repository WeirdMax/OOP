
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        TrapezoidalIntegration trapezoidalIntegration = new TrapezoidalIntegration(1000, 0.001, 0.00001);
        SimpsonIntegration simpsonIntegration = new SimpsonIntegration(1000, 0.001, 0.00001);
        Function<Double, Double> expression = x -> x * x;
        double lowerBound = 0;
        double upperBound = 1;
        double trapezoidalResult = trapezoidalIntegration.calc(expression, lowerBound, upperBound);
        double simpsonResult = simpsonIntegration.calc(expression, lowerBound, upperBound);
        System.out.println("Trapezoidal integration result: " + trapezoidalResult);
        System.out.println("Simpson integration result: " + simpsonResult);
    }
}
