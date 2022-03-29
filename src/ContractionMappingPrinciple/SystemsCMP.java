package ContractionMappingPrinciple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SystemsCMP {
    static double norm(double[] x, double[] y) {
        double max = 0.0;
        for (int i = 0; i < x.length; i++) {
            if(Math.abs(x[i] - y[i]) > max)
                max = Math.abs(x[i] - y[i]);
        }
        return max;
    }

    static void iterationsMethod(double[] x_0, double[][] C, double[] d, double eps) {
        int m = x_0.length;
        double[] x_KMinusOne = new double[m];
        double[] x_K = new double[m];
        for (int i = 0; i < m; i++) {
            x_KMinusOne[i] = x_0[i];
        }
        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < m; j++) {
                sum += C[i][j] * x_KMinusOne[j];
            }
            x_K[i] = sum + d[i];
        }
        for (double x_Ki : x_K)
            System.out.println(x_Ki);
        int k = 1;
        while(norm(x_KMinusOne, x_K) >= eps) {
            for (int i = 0; i < m; i++) {
                x_KMinusOne[i] = x_K[i];
            }
            for (int i = 0; i < m; i++) {
                double sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += C[i][j] * x_KMinusOne[j];
                }
                x_K[i] = sum + d[i];
            }
            k++;
        }
        System.out.println(k);
        for (double x_Ki : x_K)
            System.out.println(x_Ki);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C.txt"));
        int size = Integer.parseInt(sc.nextLine());
        int i = 0;
        double[][] C = new double[size][size];
        while(sc.hasNextLine()) {
            String[] numbers = sc.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                C[i][j] = Double.parseDouble(numbers[j]);
            }
            i++;
        }
        sc = new Scanner(new File("d.txt"));
        double[] d = new double[size];
        i = 0;
        while(sc.hasNextLine()) {
            d[i] = Double.parseDouble(sc.nextLine());
            i++;
        }
        double[] x_0 = {0.0, 0.0, 0.0};
        double eps = Math.pow(10, -3);
        iterationsMethod(x_0, C, d, eps);
    }
}