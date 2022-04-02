package ContractionMappingPrinciple;

public class FredholmCMP {
    static void iterationsMethod(int iterationsQuantity) {
        System.out.println("x0 = 0");
        System.out.println("x1 = t^2");
        double beta = 0.2;
        System.out.println("x2 = t^2 + " + beta + " + t * " + beta);
        int k = 2;
        while(k < iterationsQuantity) {
            k++;
            beta = 0.2 + beta / 3 + beta / 4;
            System.out.println("x" + k + " = t^2 + " + beta + " + t * " + beta);
        }
    }

    public static void main(String[] args) {
        iterationsMethod(20); // 7 for C[0,1], 20 for L2[0,1]
    }
}
