
import java.util.function.Function;

abstract class NumIntegration {
    protected int numPoints;
    protected double step;
    protected double accuracy;
    public NumIntegration(int numPoints, double step, double accuracy) {
        this.numPoints = numPoints;
        this.step = step;
        this.accuracy = accuracy;
    }
    public abstract double calc(Function<Double, Double> expression, double lowerBound, double upperBound);
    protected boolean isValidParameters() {
        return numPoints > 0 && step > 0 && accuracy > 0;
    }
}
