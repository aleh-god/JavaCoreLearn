package PaternLearn.PaternIterator;

public class Main {
    public static void main(String args[]) {

        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        Menu cafeMenu = new CafeMenu();

        WaitressOld waitress = new WaitressOld(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
    }
}
