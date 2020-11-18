package PaternLearn.InterfaceCapsule;

public class Main {
    public static void main(String[] agrs) {
        Man stan = new Man();
        System.out.println("Output: " + stan.playWork());
        Woman lena = new Woman();
        lena.playRelax();
    }
}