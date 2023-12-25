import java.util.function.Function;

public class TrapezoidalIntegration extends NumIntegration {
    public TrapezoidalIntegration(int numPoints, double step, double accuracy) {
        super(numPoints, step, accuracy);
    }

    @Override
    public double calc(Function<Double, Double> function, double lowerBound, double upperBound) {
        if (!isValidParameters()) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        double sum = 0.0;
        double x = lowerBound;
        double h = (upperBound - lowerBound) / numPoints;
        for (int i = 0; i <= numPoints; i++) {
            double y = function.apply(x);
            if (i == 0 || i == numPoints) {
                sum += 0.5 * y;
            } else {
                sum += y;
            }
            x += h;
        }
        return Math.round((sum * h) / accuracy) * accuracy;
    }
}
