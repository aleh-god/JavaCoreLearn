package LambdaTest;

public class Expressionable {
    public static void main(String[] args) {
        Parametr parametr;
        parametr = (i , j) -> i != j;
        int z = 0;

        while (parametr.telo(z , 5)) {
            z++;
            System.out.println("Scan i: " + z);
        }
        System.out.println("End i: " + z);
    }
}
interface Parametr {
    boolean telo(int i , int j);
}
