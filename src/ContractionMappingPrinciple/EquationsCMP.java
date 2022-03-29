package ContractionMappingPrinciple;

public class EquationsCMP {
    static double f(double x) {
        return ((- Math.pow(x, 7) / 2) - (2 * Math.pow(x, 5)) - 0.5);
    }

    static double fixedPointIteration(double x_0, double eps) {
        double x_KMinusOne = x_0;
        double x_K = f(x_KMinusOne);
        int k = 1;
        while(Math.abs(f(x_KMinusOne) - f(x_K)) >= eps) {
            x_KMinusOne = x_K;
            x_K = f(x_KMinusOne);
            k++;
        }
        System.out.println(k);
        return x_K;
    }

    public static void main(String[] args) {
        System.out.println(fixedPointIteration(0.0, Math.pow(10, -4)));
    }
}