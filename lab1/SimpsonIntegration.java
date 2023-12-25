import java.util.function.Function;

class SimpsonIntegration extends NumIntegration {
    public SimpsonIntegration(int numPoints, double step, double accuracy) {
        super(numPoints, step, accuracy);
    }
    @Override
    public double calc(Function<Double, Double> function, double lowerBound, double upperBound) {
        if (!isValidParameters()) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        double sum = 0;
        double x = lowerBound;
        for (int i = 0; i < numPoints; i++) {
            double y1 = function.apply(x);
            double y2 = function.apply(x + step / 2);
            double y3 = function.apply(x + step);
            sum += (step / 6) * (y1 + 4 * y2 + y3);
            x += step;
        }
        return Math.round(sum / accuracy) * accuracy;
    }
}
