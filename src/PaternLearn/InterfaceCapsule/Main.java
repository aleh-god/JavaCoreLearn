package PaternLearn.InterfaceCapsule;

public class Main {
    public static void main(String[] agrs) {
        Man stan = new Man("Stan");
        System.out.println(stan.nameMan + " output: " + stan.playWork());
        Woman lena = new Woman("Lena");
        System.out.println(lena.womanName + " say: ");
        lena.playRelax();
        stan.setWorkBehavior(new NoWorkBehavior());
        System.out.println(stan.nameMan + " new output: " + stan.playWork());
        Robot R3D3 = new Robot("R3D3");
        R3D3.playWork();
    }
}