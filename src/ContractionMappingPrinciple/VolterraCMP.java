package ContractionMappingPrinciple;

public class VolterraCMP {
    static double factorial(int x){
        double result = 1;
        for (int i = 1; i <= x; i ++){
            result = result * i;
        }
        return result;
    }

    static void iterationsMethod(double eps) {
        System.out.print(1);
        int k = 1;
        while(true) {
            if(k % 2 == 0)
                System.out.print("+t^" + 2 * k + "/" + 2 * k + "!");
            else
                System.out.print("-t^" + 2 * k + "/" + 2 * k + "!");
            if(1 / factorial(2 * k + 4) <= eps)
                break;
            k++;
        }
        System.out.print("\n" + (k + 1));
    }

    public static void main(String[] args) {
        iterationsMethod(0.001);
    }
}
